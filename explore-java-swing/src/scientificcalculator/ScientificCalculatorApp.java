package scientificcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ScientificCalculatorApp extends JFrame {

  private final JTextField display = new JTextField("0");
  private final JLabel resultLabel = new JLabel("Result: 0");

  private double firstNumber;
  private double memory;
  private String pendingOperator = "";
  private boolean startNewNumber = true;

  private enum AngleMode {
    DEGREE, RADIAN, GRADE
  }

  private AngleMode angleMode = AngleMode.RADIAN;

  private final Random random = new Random();

  public ScientificCalculatorApp() {
    super("Scientific Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 420);
    setResizable(false);
    setLayout(new BorderLayout(5, 5));
    createDisplay();
    createMenu();
    createButtons();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  // ---------------- DISPLAY ----------------

  private void createDisplay() {
    JPanel panel = new JPanel(new BorderLayout(5, 5));
    display.setFont(new Font("Monospaced", Font.BOLD, 22));
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setEditable(false);
    display.setBackground(Color.BLACK);
    display.setForeground(Color.GREEN);

    resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
    resultLabel.setForeground(Color.RED);

    panel.add(resultLabel, BorderLayout.NORTH);
    panel.add(display, BorderLayout.CENTER);

    add(panel, BorderLayout.NORTH);
  }

  // ---------------- MENU ----------------

  private void createMenu() {
    JMenuBar menuBar = new JMenuBar();

    JMenu calculatorMenu = new JMenu("Calculator");
    JMenuItem clearItem = new JMenuItem("Clear");
    JMenuItem exitItem = new JMenuItem("Exit");

    clearItem.addActionListener(e -> clear());
    exitItem.addActionListener(e -> exitApplication());

    calculatorMenu.add(clearItem);
    calculatorMenu.add(exitItem);

    JMenu modeMenu = new JMenu("Mode");

    JRadioButtonMenuItem degree = new JRadioButtonMenuItem("Degree");
    JRadioButtonMenuItem radian = new JRadioButtonMenuItem("Radian", true);
    JRadioButtonMenuItem grade = new JRadioButtonMenuItem("Grade");

    ButtonGroup group = new ButtonGroup();
    group.add(degree);
    group.add(radian);
    group.add(grade);

    degree.addActionListener(e -> angleMode = AngleMode.DEGREE);
    radian.addActionListener(e -> angleMode = AngleMode.RADIAN);
    grade.addActionListener(e -> angleMode = AngleMode.GRADE);

    modeMenu.add(degree);
    modeMenu.add(radian);
    modeMenu.add(grade);

    JMenu viewMenu = new JMenu("View");
    JMenuItem aboutItem = new JMenuItem("Created By");

    aboutItem.addActionListener(e -> showAbout());
    viewMenu.add(aboutItem);

    menuBar.add(calculatorMenu);
    menuBar.add(modeMenu);
    menuBar.add(viewMenu);

    setJMenuBar(menuBar);
  }

  // ---------------- BUTTONS ----------------

  private void createButtons() {

    String[][] buttons = {
        {"AND", "OR", "NOT", "XOR", "XNOR", "sin", "cos", "tan"},
        {"asin", "acos", "atan", "log", "ln", "alog", "aln", "Rand"},
        {"7", "8", "9", "/", "sqrt", "cbrt", "1/x", "x!"},
        {"4", "5", "6", "*", "x^2", "x^3", "10^x", "e^x"},
        {"1", "2", "3", "-", "x^y", "MOD", "%", "Abs"},
        {"0", ".", "+/-", "+", "(", ")", "MEM", "="},
        {"Bksp", "CE"}
    };

    JPanel buttonPanel = new JPanel(new GridLayout(7, 8, 3, 3));

    for (String[] row : buttons) {
      for (String name : row) {
        JButton button = createButton(name);
        buttonPanel.add(button);
      }

      // Fill unused columns in the last row.
      if (row.length < 8) {
        for (int i = row.length; i < 8; i++) {
          buttonPanel.add(new JLabel());
        }
      }
    }

    add(buttonPanel, BorderLayout.CENTER);
  }

  private JButton createButton(String name) {
    JButton button = new JButton(name);

    button.setFont(new Font("SansSerif", Font.BOLD, 13));

    if (name.matches("\\d") || name.equals(".")) {
      button.setForeground(Color.BLUE);
    } else {
      button.setForeground(Color.RED);
    }

    button.addActionListener(this::handleButton);
    return button;
  }

  // ---------------- BUTTON HANDLER ----------------

  private void handleButton(ActionEvent event) {
    String command = event.getActionCommand();

    try {
      // Number buttons
      if (command.matches("\\d")) {
        enterNumber(command);
        return;
      }

      switch (command) {
        case "." -> enterDecimal();
        case "+/-" -> changeSign();
        case "+", "-", "*", "/", "^", "x^y", "%", "MOD", "AND", "OR", "XOR", "XNOR" -> setOperator(command);
        case "=" -> calculate();
        case "CE" -> clear();
        case "Bksp" -> backspace();
        case "MEM" -> recallMemory();
        case "(", ")" -> display.setText("Parentheses not supported");
        case "Rand" -> showResult(random.nextDouble());
        case "sqrt", "cbrt", "1/x", "x!", "sin", "cos", "tan", "asin", "acos", "atan", "x^2", "x^3", "e^x", "10^x", "log", "ln", "alog", "aln", "Abs", "NOT" ->
            calculateScientific(command);
        default -> {
        }
      }
    } catch (ArithmeticException ex) {
      showError("Arithmetic error");
    } catch (NumberFormatException ex) {
      showError("Invalid number");
    } catch (Exception ex) {
      showError("Invalid operation");
    }
  }

  // ---------------- NUMBER INPUT ----------------

  private void enterNumber(String number) {
    if (startNewNumber || display.getText().equals("0")) {
      display.setText(number);
      startNewNumber = false;
    } else {
      display.setText(display.getText() + number);
    }
  }

  private void enterDecimal() {
    if (startNewNumber) {
      display.setText("0.");
      startNewNumber = false;
    } else if (!display.getText().contains(".")) {
      display.setText(display.getText() + ".");
    }
  }

  private void changeSign() {
    double value = getCurrentValue();
    showResult(-value);
  }

  private void backspace() {
    if (startNewNumber) {
      return;
    }
    String value = display.getText();
    if (value.length() <= 1 ||
        (value.length() == 2 && value.startsWith("-"))) {
      display.setText("0");
    } else {
      display.setText(value.substring(0, value.length() - 1));
    }
  }

  // ---------------- BASIC CALCULATIONS ----------------

  private void setOperator(String operator) {
    firstNumber = getCurrentValue();
    pendingOperator = operator;
    startNewNumber = true;
  }

  private void calculate() {
    if (pendingOperator.isEmpty()) {
      memory = getCurrentValue();
      return;
    }

    double secondNumber = getCurrentValue();
    double answer;

    switch (pendingOperator) {
      case "+" -> answer = firstNumber + secondNumber;
      case "-" -> answer = firstNumber - secondNumber;
      case "*" -> answer = firstNumber * secondNumber;
      case "/" -> {
        if (secondNumber == 0) {
          throw new ArithmeticException("Division by zero");
        }
        answer = firstNumber / secondNumber;
      }
      case "^", "x^y" -> answer = Math.pow(firstNumber, secondNumber);
      case "%" -> answer = firstNumber * secondNumber / 100.0;
      case "MOD" -> {
        if (secondNumber == 0) {
          throw new ArithmeticException("Division by zero");
        }
        answer = firstNumber % secondNumber;
      }
      case "AND" -> answer = (int) firstNumber & (int) secondNumber;
      case "OR" -> answer = (int) firstNumber | (int) secondNumber;
      case "XOR" -> answer = (int) firstNumber ^ (int) secondNumber;
      case "XNOR" -> answer = ~((int) firstNumber ^ (int) secondNumber);
      default -> throw new IllegalArgumentException("Unknown operator");
    }

    pendingOperator = "";
    memory = answer;
    showResult(answer);
  }

  // ---------------- SCIENTIFIC CALCULATIONS ----------------

  private void calculateScientific(String function) {
    double value = getCurrentValue();
    double answer;
    switch (function) {
      case "sqrt" -> answer = Math.sqrt(value);
      case "cbrt" -> answer = Math.cbrt(value);
      case "1/x" -> {
        if (value == 0) {
          throw new ArithmeticException("Division by zero");
        }
        answer = 1.0 / value;
      }
      case "x!" -> answer = factorial(value);
      case "x^2" -> answer = Math.pow(value, 2);
      case "x^3" -> answer = Math.pow(value, 3);
      case "e^x", "aln" -> answer = Math.exp(value);
      case "10^x", "alog" -> answer = Math.pow(10, value);
      case "log" -> answer = Math.log10(value);
      case "ln" -> answer = Math.log(value);
      case "Abs" -> answer = Math.abs(value);
      case "sin" -> answer = Math.sin(toRadians(value));
      case "cos" -> answer = Math.cos(toRadians(value));
      case "tan" -> answer = Math.tan(toRadians(value));
      case "asin" -> answer = fromRadians(Math.asin(value));
      case "acos" -> answer = fromRadians(Math.acos(value));
      case "atan" -> answer = fromRadians(Math.atan(value));
      case "NOT" -> answer = ~(int) value;
      default -> throw new IllegalArgumentException("Unknown function");
    }
    showResult(answer);
  }

  // ---------------- ANGLE CONVERSION ----------------

  private double toRadians(double value) {
    return switch (angleMode) {
      case DEGREE -> Math.toRadians(value);
      case GRADE -> value * Math.PI / 200.0;
      default -> value;
    };
  }

  private double fromRadians(double value) {
    return switch (angleMode) {
      case DEGREE -> Math.toDegrees(value);
      case GRADE -> value * 200.0 / Math.PI;
      default -> value;
    };
  }

  // ---------------- FACTORIAL ----------------
  private double factorial(double number) {
    if (number < 0 || number != Math.floor(number)) {
      throw new ArithmeticException("Factorial requires a non-negative integer");
    }
    if (number > 170) {
      throw new ArithmeticException("Factorial too large");
    }
    double result = 1;
    for (int i = 1; i <= (int) number; i++) {
      result *= i;
    }
    return result;
  }

  // ---------------- MEMORY ----------------
  private void recallMemory() {
    showResult(memory);
  }

  // ---------------- COMMON METHODS ----------------

  private double getCurrentValue() {
    return Double.parseDouble(display.getText());
  }

  private void showResult(double value) {
    if (Double.isNaN(value) || Double.isInfinite(value)) {
      throw new ArithmeticException("Invalid result");
    }
    display.setText(String.valueOf(value));
    resultLabel.setText("Result: " + value);
    startNewNumber = true;
  }

  private void showError(String message) {
    display.setText(message);
    resultLabel.setText("Result: Error");
    pendingOperator = "";
    startNewNumber = true;
  }

  private void clear() {
    display.setText("0");
    resultLabel.setText("Result: 0");
    firstNumber = 0;
    pendingOperator = "";
    startNewNumber = true;
  }

  // ---------------- ABOUT ----------------

  private void showAbout() {
    JOptionPane.showMessageDialog(
        this,
        "Scientific Calculator\n\nDeveloper: Abhinaw Kumar\nJava Swing Application",
        "About Calculator",
        JOptionPane.INFORMATION_MESSAGE
    );
  }
  // ---------------- EXIT ----------------
  private void exitApplication() {
    int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?","Exit Calculator", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }

  // ---------------- MAIN ----------------
  public static void main(String[] args) {
    SwingUtilities.invokeLater(ScientificCalculatorApp::new);
  }
}
