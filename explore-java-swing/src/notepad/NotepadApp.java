package notepad;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class NotepadApp extends JFrame {

  private final JTextArea textArea = new JTextArea();
  private final JFileChooser fileChooser = new JFileChooser();
  private final UndoManager undoManager = new UndoManager();

  private File currentFile;
  private boolean modified = false;
  private boolean updatingDocument = false;

  private Font currentFont = new Font("Monospaced", Font.PLAIN, 14);

  private final JLabel statusBar = new JLabel("Ready");

  public NotepadApp() {
    setTitle("Notepad");
    setSize(800, 600);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLocationRelativeTo(null);

    textArea.setFont(currentFont);
    textArea.setTabSize(4);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    add(new JScrollPane(textArea), BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
    createMenuBar();
    createToolBar();
    createPopupMenu();
    registerListeners();
    setVisible(true);
  }

  // ---------------- MENU BAR ----------------

  private void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    addMenuItem(fileMenu, "New", KeyEvent.VK_N, e -> newFile());
    addMenuItem(fileMenu, "Open", KeyEvent.VK_O, e -> openFile());
    addMenuItem(fileMenu, "Save", KeyEvent.VK_S, e -> saveFile());
    addMenuItem(fileMenu, "Save As", 0, e -> saveFileAs());
    fileMenu.addSeparator();
    addMenuItem(fileMenu, "Exit", 0, e -> exitApplication());

    JMenu editMenu = new JMenu("Edit");

    addMenuItem(editMenu, "Undo", KeyEvent.VK_Z, e -> undo());
    addMenuItem(editMenu, "Redo", KeyEvent.VK_Y, e -> redo());

    editMenu.addSeparator();

    addMenuItem(editMenu, "Cut", KeyEvent.VK_X, e -> textArea.cut());
    addMenuItem(editMenu, "Copy", KeyEvent.VK_C, e -> textArea.copy());
    addMenuItem(editMenu, "Paste", KeyEvent.VK_V, e -> textArea.paste());
    addMenuItem(editMenu, "Select All", KeyEvent.VK_A, e -> textArea.selectAll());

    JMenu formatMenu = new JMenu("Format");

    addMenuItem(formatMenu, "Font", 0, e -> chooseFont());
    addMenuItem(formatMenu, "Text Color", 0, e -> chooseTextColor());
    addMenuItem(formatMenu, "Background Color", 0, e -> chooseBackgroundColor());

    JMenu searchMenu = new JMenu("Search");

    addMenuItem(searchMenu, "Find Word", KeyEvent.VK_F, e -> searchWord());
    addMenuItem(searchMenu, "Go To Line", 0, e -> goToLine());
    addMenuItem(searchMenu, "Find Selected Length", 0, e -> findSelectedLength());
    JMenu toolsMenu = new JMenu("Tools");

    addMenuItem(toolsMenu, "Word Count", 0, e -> showWordCount());
    addMenuItem(toolsMenu, "Line Count", 0, e -> showLineCount());
    addMenuItem(toolsMenu, "Character Count", 0, e -> showCharacterCount());

    JMenu helpMenu = new JMenu("Help");

    addMenuItem(helpMenu, "About", 0, e -> showAbout());

    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(formatMenu);
    menuBar.add(searchMenu);
    menuBar.add(toolsMenu);
    menuBar.add(helpMenu);

    setJMenuBar(menuBar);
  }

  private void addMenuItem(JMenu menu, String name, int shortcut, ActionListener action) {
    JMenuItem item = new JMenuItem(name);
    if (shortcut != 0) {
      item.setAccelerator(KeyStroke.getKeyStroke(shortcut, InputEvent.CTRL_DOWN_MASK));
    }
    item.addActionListener(action);
    menu.add(item);
  }

  // ---------------- TOOLBAR ----------------
  private void createToolBar() {
    JToolBar toolBar = new JToolBar();

    addToolButton(toolBar, "New", e -> newFile());
    addToolButton(toolBar, "Open", e -> openFile());
    addToolButton(toolBar, "Save", e -> saveFile());

    toolBar.addSeparator();
    addToolButton(toolBar, "Cut", e -> textArea.cut());
    addToolButton(toolBar, "Copy", e -> textArea.copy());
    addToolButton(toolBar, "Paste", e -> textArea.paste());
    toolBar.addSeparator();
    addToolButton(toolBar, "Undo", e -> undo());
    addToolButton(toolBar, "Redo", e -> redo());
    add(toolBar, BorderLayout.NORTH);
  }

  private void addToolButton(JToolBar toolBar, String name, ActionListener action) {
    JButton button = new JButton(name);
    button.addActionListener(action);
    toolBar.add(button);
  }

  // ---------------- POPUP MENU ----------------

  private void createPopupMenu() {
    JPopupMenu popup = new JPopupMenu();
    String[] actions = {"Cut", "Copy", "Paste", "Select All", "Undo", "Redo"};
    for (String action : actions) {
      JMenuItem item = new JMenuItem(action);
      item.addActionListener(e -> {
        switch (action) {
          case "Cut" -> textArea.cut();
          case "Copy" -> textArea.copy();
          case "Paste" -> textArea.paste();
          case "Select All" -> textArea.selectAll();
          case "Undo" -> undo();
          case "Redo" -> redo();
        }
      });
      popup.add(item);
    }
    textArea.setComponentPopupMenu(popup);
  }

  // ---------------- LISTENERS ----------------
  private void registerListeners() {
    textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
    textArea.getDocument().addDocumentListener(
        new DocumentListener() {
          public void insertUpdate(DocumentEvent e) {
            documentChanged();
          }

          public void removeUpdate(DocumentEvent e) {
            documentChanged();
          }

          public void changedUpdate(DocumentEvent e) {
            documentChanged();
          }
        });
    textArea.addCaretListener(e -> updateStatus());
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        exitApplication();
      }
    });
  }

  private void documentChanged() {
    if (!updatingDocument) {
      modified = true;
      updateTitle();
    }
    updateStatus();
  }

  // ---------------- FILE OPERATIONS ----------------
  private void newFile() {
    if (!confirmSaveChanges()) {
      return;
    }
    currentFile = null;
    textArea.setText("");
    undoManager.discardAllEdits();
    modified = false;
    updateTitle();
  }

  private void openFile() {
    if (!confirmSaveChanges()) {
      return;
    }
    if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
      return;
    }
    File file = fileChooser.getSelectedFile();
    try {
      String content = Files.readString(file.toPath());
      updatingDocument = true;
      textArea.setText(content);
      textArea.setCaretPosition(0);
      updatingDocument = false;
      currentFile = file;
      modified = false;
      undoManager.discardAllEdits();
      updateTitle();
    } catch (IOException ex) {
      showError("Unable to open file: " + ex.getMessage());
    } finally {
      updatingDocument = false;
    }
  }

  private boolean saveFile() {
    if (currentFile == null) {
      return saveFileAs();
    }
    return writeFile(currentFile);
  }

  private boolean saveFileAs() {
    if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
      return false;
    }
    File file = fileChooser.getSelectedFile();
    if (file.exists()) {
      int choice = JOptionPane.showConfirmDialog(
          this,
          "File already exists. Replace it?",
          "Confirm Save",
          JOptionPane.YES_NO_OPTION);
      if (choice != JOptionPane.YES_OPTION) {
        return false;
      }
    }
    if (writeFile(file)) {
      currentFile = file;
      updateTitle();
      return true;
    }
    return false;
  }

  private boolean writeFile(File file) {
    try {
      Files.writeString(file.toPath(), textArea.getText());
      currentFile = file;
      modified = false;
      updateTitle();
      JOptionPane.showMessageDialog(this, "File saved successfully.");
      return true;
    } catch (IOException ex) {
      showError("Unable to save file: " + ex.getMessage());
      return false;
    }
  }

  private boolean confirmSaveChanges() {
    if (!modified) {
      return true;
    }
    int choice = JOptionPane.showConfirmDialog(
        this,
        "Do you want to save your changes?",
        "Unsaved Changes",
        JOptionPane.YES_NO_CANCEL_OPTION);
    if (choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.CLOSED_OPTION) {
      return false;
    }
    if (choice == JOptionPane.YES_OPTION) {
      return saveFile();
    }
    return true;
  }

  private void exitApplication() {
    if (confirmSaveChanges()) {
      dispose();
      System.exit(0);
    }
  }

  private void updateTitle() {
    String name = currentFile == null ? "Untitled" : currentFile.getName();
    setTitle((modified ? "*" : "") + name + " - Notepad");
  }

  // ---------------- UNDO / REDO ----------------
  private void undo() {
    if (undoManager.canUndo()) {
      undoManager.undo();
    }
  }

  private void redo() {
    if (undoManager.canRedo()) {
      undoManager.redo();
    }
  }

  // ---------------- FONT OPERATIONS ----------------

  private void chooseFont() {
    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String selectedFont = (String) JOptionPane.showInputDialog(
        this,
        "Choose Font Family",
        "Font",
        JOptionPane.PLAIN_MESSAGE,
        null,
        fonts,
        currentFont.getFamily());
    if (selectedFont == null) {
      return;
    }

    String[] styles = {"Plain", "Bold", "Italic", "Bold Italic"};

    String selectedStyle = (String) JOptionPane.showInputDialog(
        this,
        "Choose Font Style",
        "Font Style",
        JOptionPane.PLAIN_MESSAGE,
        null,
        styles,
        "Plain");

    if (selectedStyle == null) {
      return;
    }

    int style = switch (selectedStyle) {
      case "Bold" -> Font.BOLD;
      case "Italic" -> Font.ITALIC;
      case "Bold Italic" -> Font.BOLD | Font.ITALIC;
      default -> Font.PLAIN;
    };
    String size = JOptionPane.showInputDialog(this, "Enter Font Size", currentFont.getSize());
    if (size == null) {
      return;
    }

    try {
      int fontSize = Integer.parseInt(size);
      if (fontSize < 6 || fontSize > 100) {
        showError("Font size must be between 6 and 100.");
        return;
      }
      currentFont = new Font(selectedFont, style, fontSize);
      textArea.setFont(currentFont);
    } catch (NumberFormatException ex) {
      showError("Please enter a valid font size.");
    }
  }

  private void chooseTextColor() {
    Color color = JColorChooser.showDialog(this, "Choose Text Color", textArea.getForeground());
    if (color != null) {
      textArea.setForeground(color);
    }
  }

  private void chooseBackgroundColor() {
    Color color = JColorChooser.showDialog(this, "Choose Background Color", textArea.getBackground());
    if (color != null) {
      textArea.setBackground(color);
    }
  }

  // ---------------- SEARCH OPERATIONS ----------------
  private void searchWord() {
    String word = JOptionPane.showInputDialog(this, "Enter word to search:");
    if (word == null || word.isEmpty()) {
      return;
    }

    String content = textArea.getText();
    int start = textArea.getCaretPosition();
    int index = content.indexOf(word, start);
    if (index == -1) {
      index = content.indexOf(word);
    }
    if (index == -1) {
      JOptionPane.showMessageDialog(this, "Word not found.");
    } else {
      textArea.requestFocusInWindow();
      textArea.select(index, index + word.length());
    }
  }

  private void goToLine() {
    String input = JOptionPane.showInputDialog(this, "Enter line number:");
    if (input == null) {
      return;
    }

    try {
      int line = Integer.parseInt(input);
      if (line < 1 || line > textArea.getLineCount()) {
        showError("Invalid line number.");
        return;
      }
      int position = textArea.getLineStartOffset(line - 1);
      textArea.setCaretPosition(position);
      textArea.requestFocusInWindow();
    } catch (NumberFormatException ex) {
      showError("Enter a valid line number.");
    } catch (javax.swing.text.BadLocationException ex) {
      showError("Unable to navigate to that line.");
    }
  }

  private void findSelectedLength() {
    String selectedText = textArea.getSelectedText();
    if (selectedText == null) {
      JOptionPane.showMessageDialog(this, "Please select some text first.");
      return;
    }
    JOptionPane.showMessageDialog(this, "Selected text length: " + selectedText.length());
  }

  // ---------------- COUNT OPERATIONS ----------------
  private void showWordCount() {
    String content = textArea.getText().trim();
    int count = content.isEmpty() ? 0 : content.split("\\s+").length;
    JOptionPane.showMessageDialog(this, "Total words: " + count);
  }

  private void showLineCount() {
    JOptionPane.showMessageDialog(this, "Total lines: " + textArea.getLineCount());
  }

  private void showCharacterCount() {
    JOptionPane.showMessageDialog(this, "Total characters: " + textArea.getText().length());
  }

  // ---------------- STATUS BAR ----------------
  private void updateStatus() {
    int line = 1, column = 1;
    try {
      int position = textArea.getCaretPosition();
      line = textArea.getLineOfOffset(position) + 1;
      column = position - textArea.getLineStartOffset(line - 1) + 1;
    } catch (javax.swing.text.BadLocationException ignored) {
    }
    statusBar.setText("Line: " + line + " | Column: " + column + " | Characters: " + textArea.getText().length());
  }

  // ---------------- HELPERS ----------------
  private void showAbout() {
    JOptionPane.showMessageDialog(
        this,
        "Simple Java Notepad\nDeveloped by Abhinaw Kumar",
        "About Notepad",
        JOptionPane.INFORMATION_MESSAGE);
  }

  private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  // ---------------- MAIN ----------------
  public static void main(String[] args) {
    SwingUtilities.invokeLater(NotepadApp::new);
  }
}
