// A Simple Swing Editor
package notepad;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Stack;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;

public class NotepadApp implements ActionListener {
    private JFrame jfrm;
    private JMenu[] menu;
    private JMenuItem[] item;
    private JRadioButtonMenuItem[] rbtn;
    private ButtonGroup[] bg;
    private JMenuBar jmb;
    private JTextArea jtxt, ar;
    private Font[] font;
    private JScrollPane jscp;
    private JButton[] jbtn;
    private String fname;
    private int c, ln, fsize, ftype, wc, i;
    private JToolBar toolBar;
    private JPopupMenu popMenu = new JPopupMenu();
    private Stack<String> stk = new Stack<>();
    private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    private NotepadApp() {
        jfrm = new JFrame("Notepad");
        jfrm.setSize(700, 600);
        jfrm.getContentPane().setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setIconImage(jfrm.getToolkit().getImage("C:/Netbeans/Notepad/src/notepad/Images/Notepad.gif"));
        jfrm.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    quit();
                }
            });
        font = new Font[3];
        font[0] = new Font("Monospaced", Font.BOLD, 15);
        font[1] = new Font("Sans", Font.BOLD, 11);
        font[2] = new Font("Times New Roman", Font.BOLD, 14);
        menu = new JMenu[10];
        menu[0] = new JMenu("File");
        menu[0].setMnemonic(KeyEvent.VK_F);
        menu[1] = new JMenu("Edit");
        menu[1].setMnemonic(KeyEvent.VK_E);
        menu[2] = new JMenu("View");
        menu[2].setMnemonic(KeyEvent.VK_V);
        menu[3] = new JMenu("Help");
        menu[3].setMnemonic(KeyEvent.VK_H);
        for (i = 0; i < 4; i++) {
            menu[i].setFont(font[0]);
            menu[i].setForeground(Color.BLACK);
        }
        item = new JMenuItem[27];
        item[0] = new JMenuItem("New", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/new.gif"));
        item[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, CTRL_DOWN_MASK));
        item[1] = new JMenuItem("Open", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/Open.gif"));
        item[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, CTRL_DOWN_MASK));
        item[2] = new JMenuItem("Save", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/save.gif"));
        item[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, CTRL_DOWN_MASK));
        item[3] = new JMenuItem("SaveAs");
        item[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, CTRL_DOWN_MASK));
        item[4] = new JMenuItem("Exit", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/Quit.gif"));
        item[4].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, CTRL_DOWN_MASK));
        item[5] = new JMenuItem("Copy", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/copy.gif"));
        item[5].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, CTRL_DOWN_MASK));
        item[6] = new JMenuItem("Cut", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/cut.gif"));
        item[6].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, CTRL_DOWN_MASK));
        item[7] = new JMenuItem("Paste", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/paste.gif"));
        item[7].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, CTRL_DOWN_MASK));
        item[8] = new JMenuItem("Clear All", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/refresh.gif"));
        item[8].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, CTRL_DOWN_MASK));
        item[9] = new JMenuItem("Select All");
        item[9].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, CTRL_DOWN_MASK));
        item[10] = new JMenuItem("Undo");
        item[10].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, CTRL_DOWN_MASK));
        item[11] = new JMenuItem("Redo");
        item[11].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, CTRL_DOWN_MASK));
        item[12] = new JMenuItem("Hide");
        item[12].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, CTRL_DOWN_MASK));
        item[13] = new JMenuItem("Show");
        item[13].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));

        menu[4] = new JMenu("Font");

        rbtn = new JRadioButtonMenuItem[53];
        rbtn[0] = new JRadioButtonMenuItem("DialogInput", false);
        rbtn[1] = new JRadioButtonMenuItem("LuxiMono", false);
        rbtn[2] = new JRadioButtonMenuItem("SansSerif", false);
        rbtn[3] = new JRadioButtonMenuItem("Monospaced", true);
        rbtn[4] = new JRadioButtonMenuItem("Serif", false);
        rbtn[5] = new JRadioButtonMenuItem("Sans", false);
        rbtn[6] = new JRadioButtonMenuItem("LuxiSans", false);
        rbtn[7] = new JRadioButtonMenuItem("LuxiSerif", false);
        rbtn[8] = new JRadioButtonMenuItem("Console", false);
        rbtn[9] = new JRadioButtonMenuItem("Courier", false);
        rbtn[10] = new JRadioButtonMenuItem("Cursor", false);
        rbtn[10] = new JRadioButtonMenuItem("Utopia", false);
        rbtn[11] = new JRadioButtonMenuItem("LucidaTypeWriter", false);
        rbtn[12] = new JRadioButtonMenuItem("LiberationSerif", false);
        rbtn[13] = new JRadioButtonMenuItem("LiberationSans", false);
        rbtn[14] = new JRadioButtonMenuItem("LiberationMono", false);
        rbtn[15] = new JRadioButtonMenuItem("NimbusMonoL", false);
        rbtn[16] = new JRadioButtonMenuItem("Default", true);
        bg = new ButtonGroup[5];
        bg[0] = new ButtonGroup();
        for (i = 0; i < 17; i++) {
            menu[4].add(rbtn[i]);
            bg[0].add(rbtn[i]);
        }

        menu[5] = new JMenu("FontType");

        rbtn[17] = new JRadioButtonMenuItem("Bold", true);
        rbtn[18] = new JRadioButtonMenuItem("Italic", false);
        rbtn[19] = new JRadioButtonMenuItem("BoldItalic", false);
        rbtn[20] = new JRadioButtonMenuItem("Regular", false);

        bg[1] = new ButtonGroup();
        for (i = 17; i < 21; i++) {
            menu[5].add(rbtn[i]);
            bg[1].add(rbtn[i]);
        }

        menu[6] = new JMenu("Size");

        rbtn[21] = new JRadioButtonMenuItem("7", false);
        rbtn[22] = new JRadioButtonMenuItem("8", false);
        rbtn[23] = new JRadioButtonMenuItem("9", false);
        rbtn[24] = new JRadioButtonMenuItem("10", false);
        rbtn[25] = new JRadioButtonMenuItem("11", false);
        rbtn[26] = new JRadioButtonMenuItem("12", false);
        rbtn[27] = new JRadioButtonMenuItem("13", true);
        rbtn[28] = new JRadioButtonMenuItem("14", false);
        rbtn[29] = new JRadioButtonMenuItem("15", false);
        rbtn[30] = new JRadioButtonMenuItem("16", false);
        rbtn[31] = new JRadioButtonMenuItem("17", false);
        rbtn[32] = new JRadioButtonMenuItem("18", false);
        rbtn[33] = new JRadioButtonMenuItem("19", false);
        rbtn[34] = new JRadioButtonMenuItem("20", false);
        rbtn[35] = new JRadioButtonMenuItem("21", false);
        rbtn[36] = new JRadioButtonMenuItem("22", false);
        rbtn[37] = new JRadioButtonMenuItem("23", false);
        rbtn[38] = new JRadioButtonMenuItem("24", false);
        rbtn[39] = new JRadioButtonMenuItem("25", false);
        rbtn[40] = new JRadioButtonMenuItem("26", false);
        rbtn[41] = new JRadioButtonMenuItem("27", false);
        rbtn[42] = new JRadioButtonMenuItem("28", false);
        rbtn[43] = new JRadioButtonMenuItem("29", false);
        rbtn[44] = new JRadioButtonMenuItem("30", false);
        bg[2] = new ButtonGroup();
        for (i = 21; i <= 44; i++) {
            bg[2].add(rbtn[i]);
            menu[6].add(rbtn[i]);
        }
        item[14] = new JMenuItem("TextColor");
        item[15] = new JMenuItem("BackGround");
        menu[7] = new JMenu("Count");
        rbtn[45] = new JRadioButtonMenuItem("Words", false);
        rbtn[46] = new JRadioButtonMenuItem("Lines", false);
        rbtn[47] = new JRadioButtonMenuItem("Characters", false);
        bg[3] = new ButtonGroup();
        for (i = 45; i < 48; i++) {
            bg[3].add(rbtn[i]);
            menu[7].add(rbtn[i]);
        }
        item[16] = new JMenuItem("CreatedBy");
        item[17] = new JMenuItem("Goto LineNo");
        item[18] = new JMenuItem("Search Word", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/Search.gif"));
        item[19] = new JMenuItem("Find Length", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/find.gif"));

        bg[4] = new ButtonGroup();

        menu[8] = new JMenu("Theme");

        rbtn[48] = new JRadioButtonMenuItem("Swing", false);
        rbtn[49] = new JRadioButtonMenuItem("Greenish", false);
        rbtn[50] = new JRadioButtonMenuItem("Nimbus", false);
        rbtn[51] = new JRadioButtonMenuItem("Window", false);
        rbtn[52] = new JRadioButtonMenuItem("WindowsClassic", false);

        for (i = 48; i < 53; i++) {
            bg[4].add(rbtn[i]);
            menu[8].add(rbtn[i]);
        }
        item[20] = new JMenuItem("Copy", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/copy.gif"));
        item[20].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, CTRL_DOWN_MASK));
        item[20].setActionCommand("Copy");
        item[21] = new JMenuItem("Cut", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/cut.gif"));
        item[21].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, CTRL_DOWN_MASK));
        item[21].setActionCommand("Cut");
        item[22] = new JMenuItem("Paste", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/paste.gif"));
        item[22].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, CTRL_DOWN_MASK));
        item[22].setActionCommand("Paste");
        item[23] = new JMenuItem("Clear All", new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/refresh.gif"));
        item[23].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, CTRL_DOWN_MASK));
        item[23].setActionCommand("Clear All");
        item[24] = new JMenuItem("Select All");
        item[24].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, CTRL_DOWN_MASK));
        item[24].setActionCommand("Select All");
        item[25] = new JMenuItem("Undo");
        item[25].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, CTRL_DOWN_MASK));
        item[25].setActionCommand("Undo");
        item[26] = new JMenuItem("Redo");
        item[26].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, CTRL_DOWN_MASK));
        item[26].setActionCommand("Redo");
        for (i = 20; i <= 26; i++) {
            popMenu.add(item[i]);
            popMenu.addSeparator();
        }
        for (i = 4; i < 9; i++) {
            menu[i].setFont(font[1]);
            menu[i].setForeground(Color.BLACK);
        }
        for (i = 0; i < 53; i++) {
            if (i < 27) {
                item[i].setFont(font[1]);
                item[i].setForeground(Color.BLACK);
                item[i].addActionListener(this);
            }
            rbtn[i].setFont(font[2]);
            rbtn[i].setForeground(Color.BLACK);
            rbtn[i].addActionListener(this);
        }
        for (i = 0; i <= 20; i++) {
            if (i >= 0 && i <= 4) {
                menu[0].add(item[i]);
                menu[0].addSeparator();
            }
            if (i >= 5 && i <= 11) {
                menu[1].add(item[i]);
                menu[1].addSeparator();
            }
            if (i >= 12 && i <= 15) {
                menu[2].add(item[i]);
                menu[2].addSeparator();
            }
            if (i >= 16 && i <= 19) {
                menu[3].add(item[i]);
                menu[3].addSeparator();
            }
        }
        for (i = 4; i < 9; i++) {
            if (i != 6) {
                menu[2].add(menu[i]);
                menu[2].addSeparator();
            }
        }
        menu[2].add(menu[6]);
        jmb = new JMenuBar();
        for (i = 0; i < 4; i++) {
            jmb.add(menu[i]);
        }
        jfrm.setJMenuBar(jmb);

        jbtn = new JButton[10];
        jbtn[0] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/new.gif"));
        jbtn[0].setToolTipText("New File");
        jbtn[0].setActionCommand("New");
        jbtn[1] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/Open.gif"));
        jbtn[1].setToolTipText("Open");
        jbtn[1].setActionCommand("Open");
        jbtn[2] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/save.gif"));
        jbtn[2].setToolTipText("Save");
        jbtn[2].setActionCommand("Save");
        jbtn[3] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/cut.gif"));
        jbtn[3].setToolTipText("Cut");
        jbtn[3].setActionCommand("Cut");
        jbtn[4] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/copy.gif"));
        jbtn[4].setToolTipText("Copy");
        jbtn[4].setActionCommand("Copy");
        jbtn[5] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/paste.gif"));
        jbtn[5].setToolTipText("Paste");
        jbtn[5].setActionCommand("Paste");
        jbtn[6] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/Search.gif"));
        jbtn[6].setToolTipText("Search");
        jbtn[6].setActionCommand("Search Word");
        jbtn[7] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/refresh.gif"));
        jbtn[7].setToolTipText("Clear All");
        jbtn[7].setActionCommand("Clear All");
        jbtn[8] = new JButton(new ImageIcon("C:/Netbeans/Notepad/src/notepad/Images/find.gif"));
        jbtn[8].setToolTipText("Find Length");
        jbtn[8].setActionCommand("Find Length");

        toolBar = new JToolBar();
        for (i = 0; i < 9; i++) {
            jbtn[i].addActionListener(this);
            toolBar.add(jbtn[i]);
            toolBar.addSeparator();
        }
        jfrm.add(toolBar, BorderLayout.NORTH);

        jtxt = new JTextArea(650, 450);
        jtxt.setEditable(true);
        jtxt.setCaretPosition(0);
        ar = new JTextArea(650, 450);
        jtxt.setTabSize(2);
        jtxt.setLineWrap(true);
        jtxt.setWrapStyleWord(true);
        jtxt.setText("");
        jscp = new JScrollPane(jtxt);
        jbtn[9] = new JButton("");
        jbtn[9].setPreferredSize(new Dimension(20, 20));
        jbtn[9].setFont(font[1]);
        jbtn[9].setForeground(Color.green);
        jbtn[9].setBackground(Color.black);
        jscp.setPreferredSize(new Dimension(650, 450));
        jtxt.addCaretListener(new CaretListener() {
                public void caretUpdate(CaretEvent ce) {
                    item[10].setEnabled(true);
                    if (!jtxt.getText().equals(""))
                        stk.push(jtxt.getText());
                    ln = jtxt.getLineCount();
                    jbtn[9].setText("Total Line : " + ln + " Caret Position : " + jtxt.getCaretPosition());
                    if (jtxt.getText().length() == 0) {
                        wc = 0;
                    } else {
                        String[] strsplit = jtxt.getText().split("\\W+");
                        wc = strsplit.length;
                        if (strsplit.length > 0 && strsplit[0].length() == 0) {
                            wc--;
                        }
                    }
                }
            });
        jtxt.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    checkMouseTrigger(me);
                }

                public void mouseReleased(MouseEvent me) {
                    checkMouseTrigger(me);
                }

                private void checkMouseTrigger(MouseEvent me) {
                    if (me.isPopupTrigger()) {
                        popMenu.show(me.getComponent(), me.getX(), me.getY());
                    }
                }
            });

        fname = "Monospaced";
        ftype = Font.BOLD;
        fsize = 13;
        jtxt.setFont(new Font("Monospaced", Font.PLAIN, 14));
        jfrm.add(jscp);
        jfrm.add(jbtn[9], BorderLayout.SOUTH);
        jfrm.setResizable(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Exit")) {
            if (jtxt.getText() != null) {
                quit();
            }
        } else if (str.equals("Copy")) {
            jtxt.copy();
        } else if (str.equals("Cut")) {
            jtxt.cut();
        } else if (str.equals("Paste")) {
            jtxt.paste();
        } else if (str.equals("Clear All")) {
            jtxt.setText("");
        } else if (str.equals("Select All")) {
            jtxt.selectAll();
        } else if (str.equals("Sans")) {
            fname = "Sans";
            jtxtFont();
        } else if (str.equals("Serif")) {
            fname = "Serif";
            jtxtFont();
        } else if (str.equals("Monospaced")) {
            fname = "Monospaced";
            jtxtFont();
        } else if (str.equals("SansSerif")) {
            fname = "SansSerif";
            jtxtFont();
        } else if (str.equals("DialogInput")) {
            fname = "DialogInput";
            jtxtFont();
        } else if (str.equals("Utopia")) {
            fname = "Utopia";
            jtxtFont();
        } else if (str.equals("LucidaTypeWriter")) {
            fname = "LucidaTypeWriter";
            jtxtFont();
        } else if (str.equals("LuxiMono")) {
            fname = "Luxi Mono";
            jtxtFont();
        } else if (str.equals("LuxiSans")) {
            fname = "Luxi Sans Regular";
            jtxtFont();
        } else if (str.equals("LuxiSerif")) {
            fname = "Luxi Serif";
            jtxtFont();
        } else if (str.equals("Console")) {
            fname = "Console";
            jtxtFont();
        } else if (str.equals("Courier")) {
            fname = "Courier";
            jtxtFont();
        } else if (str.equals("LiberationSerif")) {
            fname = "Liberation Serif";
            jtxtFont();
        } else if (str.equals("LiberationMono")) {
            fname = "Liberation Mono";
            jtxtFont();
        } else if (str.equals("LiberationSans")) {
            fname = "Liberation Sans";
            jtxtFont();
        } else if (str.equals("NimbusMonoL")) {
            fname = "Nimbus Mono L";
            jtxtFont();
        } else if (str.equals("Default")) {
            jtxt.setFont(new Font("Monospaced", Font.BOLD, 13));
        } else if (str.equals("6")) {
            fsize = 6;
            jtxtFont();
        } else if (str.equals("7")) {
            fsize = 7;
            jtxtFont();
        } else if (str.equals("8")) {
            fsize = 8;
            jtxtFont();
        } else if (str.equals("9")) {
            fsize = 9;
            jtxtFont();
        } else if (str.equals("10")) {
            fsize = 10;
            jtxtFont();
        } else if (str.equals("11")) {
            fsize = 11;
            jtxtFont();
        } else if (str.equals("12")) {
            fsize = 12;
            jtxtFont();
        } else if (str.equals("13")) {
            fsize = 13;
            jtxtFont();
        } else if (str.equals("14")) {
            fsize = 14;
            jtxtFont();
        } else if (str.equals("15")) {
            fsize = 15;
            jtxtFont();
        } else if (str.equals("16")) {
            fsize = 16;
            jtxtFont();
        } else if (str.equals("17")) {
            fsize = 17;
            jtxtFont();
        } else if (str.equals("18")) {
            fsize = 18;
            jtxtFont();
        } else if (str.equals("19")) {
            fsize = 19;
            jtxtFont();
        } else if (str.equals("20")) {
            fsize = 20;
            jtxtFont();
        } else if (str.equals("21")) {
            fsize = 21;
            jtxtFont();
        } else if (str.equals("22")) {
            fsize = 22;
            jtxtFont();
        } else if (str.equals("23")) {
            fsize = 23;
            jtxtFont();
        } else if (str.equals("24")) {
            fsize = 24;
            jtxtFont();
        } else if (str.equals("25")) {
            fsize = 25;
            jtxtFont();
        } else if (str.equals("26")) {
            fsize = 26;
            jtxtFont();
        } else if (str.equals("27")) {
            fsize = 27;
            jtxtFont();
        } else if (str.equals("28")) {
            fsize = 28;
            jtxtFont();
        } else if (str.equals("29")) {
            fsize = 29;
            jtxtFont();
        } else if (str.equals("30")) {
            fsize = 30;
            jtxtFont();
        } else if (str.equals("Bold")) {
            ftype = Font.BOLD;
            jtxtFont();
        } else if (str.equals("Italic")) {
            ftype = Font.ITALIC;
            jtxtFont();
        } else if (str.equals("BoldItalic")) {
            ftype = Font.BOLD | Font.ITALIC;
            jtxtFont();
        } else if (str.equals("Regular")) {
            ftype = Font.PLAIN;
            jtxtFont();
        } else if (str.equals("Hide")) {
            if (jtxt.getText() != null) {
                ar.setText(jtxt.getText());
                jtxt.setText("");
            }
        } else if (str.equals("Show")) {
            if (c == 0) {
                jtxt.setText(ar.getText());
            }
        } else if (str.equals("Lines")) {
            JOptionPane.showMessageDialog(jfrm, "Total No Of Line Is :" + jtxt.getLineCount());
        } else if (str.equals("Characters")) {
            char[] a = jtxt.getText().toCharArray();
            JOptionPane.showMessageDialog(jfrm, "Total No Of Characters Is :" + a.length);
        } else if (str.equals("Words")) {
            JOptionPane.showMessageDialog(jfrm, "Total No Of Word Is :" + wc);
        } else if (str.equals("Open")) {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                FileReader fw;
                File file = jfc.getSelectedFile();
                if (file == null) {
                    return;
                }
                try {
                    fw = new FileReader(file);
                    BufferedReader R = new BufferedReader(fw);
                    String msg1, msg2 = "";
                    while ((msg1 = R.readLine()) != null) {
                        msg2 = msg2 + "\n" +
                                msg1;
                    }
                    jtxt.setText(msg2);
                    fw.close();
                    jtxt.setCaretPosition(0);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(jfrm, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (str.equals("Save")) {
            save();
        } else if (str.equals("SaveAs")) {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                FileWriter fw;
                File file = jfc.getSelectedFile();
                if (file == null) {
                    return;
                }
                String s1 = file.toString();
                int idx = s1.lastIndexOf('/');
                String fn = s1.substring(idx + 1, s1.length());
                File fp = new File(file.getParent());
                String[] fileall = fp.list();
                for (String s : fileall) {
                    if (s.equals(fn)) {
                        int response = JOptionPane.showConfirmDialog(jfrm, "Want To Replace ?", "Select An Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        switch (response) {
                        case JOptionPane.YES_OPTION:
                            try {
                                fw = new FileWriter(file);
                                jtxt.write(fw);
                                fw.close();
                                JOptionPane.showMessageDialog(jfrm, "File Saved SuccessFully");
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(jfrm, "File Not Found");
                            }
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            break;
                        }
                    }
                }
            } else {
                return;
            }
        } else if (str.equals("New")) {

            if (jtxt.getText().equals("")) {
                jtxt.setText("");
            } else {
                int flag = JOptionPane.showConfirmDialog(jfrm, "File Is Not Save, Save File", "Select An Option", JOptionPane.YES_NO_OPTION);
                switch (flag) {
                case JOptionPane.YES_OPTION:
                    save();
                    break;
                case JOptionPane.NO_OPTION:
                    jtxt.setText("");
                    break;
                }
            }
        } else if (str.equals("CreatedBy")) {
            JOptionPane.showMessageDialog(jfrm, "    Developer : Abhinaw Kumar\n\n      Sun Certified Java Programmer", "Developer", JOptionPane.PLAIN_MESSAGE);
        } else if (str.equals("Goto LineNo")) {
            if (ln != 0) {
                String s = JOptionPane.showInputDialog("Enter Line No");
                if (s == null) {
                    JOptionPane.showMessageDialog(jfrm, "No Line No Entered", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else if (s.length() == 0) {
                    JOptionPane.showMessageDialog(jfrm, "No Line No Entered", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int n = Integer.parseInt(s);
                    if (n <= ln) {
                        jtxt.requestFocusInWindow();
                    } else {
                        JOptionPane.showMessageDialog(jfrm, "Invalid Line No Entered");
                    }
                }
            }
        } else if (str.equals("Search Word")) {
            String s = JOptionPane.showInputDialog("Enter Word To Be Searched");
            if (s == null) {
                JOptionPane.showMessageDialog(jfrm, "No Word Entered", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (s.length() == 0) {
                JOptionPane.showMessageDialog(jfrm, "No Word Entered", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String s1 = jtxt.getText();
                int idx = s1.indexOf(s, 0);
                if (idx > -1) {
                    jtxt.setCaretPosition(idx);
                    JOptionPane.showMessageDialog(jfrm, "String Found");
                    jtxt.requestFocusInWindow();
                    int start = jtxt.getCaretPosition();
                    jtxt.select(start, (start + s.length()));
                } else {
                    JOptionPane.showMessageDialog(jfrm, "String Not Found");
                }
            }
        } else if (str.equals("Find Length")) {
            if (jtxt.getSelectedText() != null) {
                JOptionPane.showMessageDialog(jfrm, "The Length Is " + jtxt.getSelectedText().length());
            } else {
                JOptionPane.showMessageDialog(jfrm, "You Haven't Selected Any Text");
            }
            return;
        } else if (str.equals("Swing")) {
            changeLookAndFeel(0);
        } else if (str.equals("Greenish")) {
            changeLookAndFeel(1);
        } else if (str.equals("Nimbus")) {
            changeLookAndFeel(2);
        } else if (str.equals("Window")) {
            changeLookAndFeel(3);
        } else if (str.equals("WindowsClassic")) {
            changeLookAndFeel(4);
        } else if (str.equals("Undo")) {
            try {
                stk.pop();
                jtxt.setText(stk.pop());
            } catch (Exception e) {
                jtxt.setText("");
                item[10].setEnabled(false);
            }
        }
        /*
		 * else if(str.equals("Redo")) { try { stk.pop();
		 * jtxt.setText(stk.pop()); }catch(Exception e) { jtxt.setText("");
		 * item[10].setEnabled(false); } }
		 */
    }

    private void jtxtFont() {
        jtxt.setFont(new Font(fname, ftype, fsize));
    }

    private void save() {
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            FileWriter fr;
            File file = jfc.getSelectedFile();
            if (file == null) {
                return;
            }
            try {
                fr = new FileWriter(file);
                jtxt.write(fr);
                fr.close();
                JOptionPane.showMessageDialog(jfrm, "File Saved SuccessFully", "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jfrm, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void changeLookAndFeel(int val) {
        try {
            UIManager.setLookAndFeel(looks[val].getClassName());
            SwingUtilities.updateComponentTreeUI(jfrm);
        } catch (Exception e) {

        }
    }

    private void quit() {
        int response = JOptionPane.showConfirmDialog(jfrm, "File Is Not Save, Save File");
        switch (response) {
        case JOptionPane.YES_OPTION:
            save();
            break;
        case JOptionPane.NO_OPTION:
            System.exit(0);
            return;
        case JOptionPane.CANCEL_OPTION:
            return;
        }
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(()-> new NotepadApp());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
    }
}
