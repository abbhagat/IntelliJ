// Scientific Calculator
package scientificcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ScientificCalculatorApp implements ActionListener {
    private JFrame jfrm;
    private JMenu jcal, jmode, jview, jselect;
    private JMenuItem jexit, jabout, jclear;
    private JRadioButtonMenuItem jdegree, jradian, jgrade;
    private ButtonGroup bg;
    private JMenuBar jmb;
    private JLabel jlab;
    private Font jfont1, jfont2, jfont3;
    private JButton[] jbtn;
    private JPanel jplbtn, jplmaster, jplback, jplctrl;
    private JTextField jtfd;
    private static int i;
    private static int k;
    private static int e;
    private String s1;
    private String s2;
    private String s3;
    private String msg;
    private static double firstNumber, lastNumber;
    private static boolean dmode;
    private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    private ScientificCalculatorApp() {
        jfrm = new JFrame("Scientific Calculator");
        jfrm.setSize(620, 320);
        jfrm.getContentPane().setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfont1 = new Font("Times New Roman", Font.BOLD, 13);
        jfont2 = new Font("SansSerif", Font.BOLD, 13);
        jfont3 = new Font("Monospaced", Font.BOLD, 12);
        jcal = new JMenu("Calculator");
        jcal.setFont(jfont1);
        jcal.setMnemonic(KeyEvent.VK_C);
        jmode = new JMenu("Mode");
        jmode.setFont(jfont1);
        jmode.setMnemonic(KeyEvent.VK_M);
        jview = new JMenu("View");
        jview.setFont(jfont1);
        jview.setMnemonic(KeyEvent.VK_V);
        jabout = new JMenuItem("Created By");
        jabout.setFont(jfont2);
        jabout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        jabout.addActionListener(this);
        jexit = new JMenuItem("Exit");
        jexit.setFont(jfont2);
        jexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        jexit.addActionListener(this);
        jselect = new JMenu("Select");
        jselect.setFont(jfont2);
        jdegree = new JRadioButtonMenuItem("Degree", false);
        jdegree.setFont(jfont2);
        jdegree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        jdegree.addActionListener(this);
        jradian = new JRadioButtonMenuItem("Radian", true);
        jradian.setFont(jfont2);
        jradian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        jradian.addActionListener(this);
        jgrade = new JRadioButtonMenuItem("Grade", false);
        jgrade.setFont(jfont2);
        jgrade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        jgrade.addActionListener(this);
        jcal.add(jexit);
        jclear = new JMenuItem("Clear");
        jclear.setFont(jfont2);
        jclear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        jclear.addActionListener(this);
        jselect.add(jdegree);
        jselect.add(jradian);
        jselect.add(jgrade);
        bg = new ButtonGroup();
        bg.add(jdegree);
        bg.add(jradian);
        bg.add(jgrade);
        jmode.add(jselect);
        jmode.add(jclear);
        jview.add(jabout);
        jlab = new JLabel("Result := 0");
        jlab.setForeground(Color.red);
        jlab.setBackground(Color.black);
        jtfd = new JTextField(20);
        jtfd.setBackground(Color.black);
        jtfd.setEditable(false);
        Font font = new Font("Monospaced", Font.BOLD, 15);
        jtfd.setFont(font);
        jtfd.setForeground(Color.green);
        jmb = new JMenuBar();
        jmb.add(jcal);
        jmb.add(jmode);
        jmb.add(jview);
        jfrm.setJMenuBar(jmb);
        jfrm.add(jtfd);
        jfrm.setForeground(Color.green);
        jplmaster = new JPanel();
        jlab.setHorizontalTextPosition(JLabel.RIGHT);
        jlab.setBackground(Color.white);
        jlab.setOpaque(false);
        jfrm.add(jlab, BorderLayout.NORTH);
        jbtn = new JButton[50];
        for (i = 0; i < 10; i++) {
            jbtn[i] = new JButton(String.valueOf(i));
            jbtn[i].setForeground(Color.blue);
            jbtn[i].setFont(jfont3);
            jbtn[i].addActionListener(this);
        }
        jbtn[10] = new JButton("/");
        jbtn[11] = new JButton("*");
        jbtn[12] = new JButton("-");
        jbtn[13] = new JButton("+");
        jbtn[14] = new JButton("+/-");
        jbtn[15] = new JButton(".");
        for (i = 10; i <= 15; i++) {
            jbtn[i].setFont(jfont2);
            jbtn[i].setForeground(Color.red);
            jbtn[i].addActionListener(this);
        }
        jbtn[16] = new JButton("Rand");
        jbtn[16].setFont(jfont2);
        jbtn[16].setForeground(Color.pink);
        jbtn[16].addActionListener(this);
        jbtn[17] = new JButton("AND");
        jbtn[18] = new JButton("OR");
        jbtn[19] = new JButton("NOT");
        jbtn[20] = new JButton("XOR");
        for (i = 17; i <= 20; i++) {
            jbtn[i].setFont(jfont2);
            jbtn[i].setForeground(Color.green);
            jbtn[i].addActionListener(this);
        }
        jbtn[21] = new JButton("XNOR");
        jbtn[22] = new JButton("sin");
        jbtn[23] = new JButton("cos");
        jbtn[24] = new JButton("tan");
        jbtn[25] = new JButton("%");
        jbtn[26] = new JButton("x^3");
        jbtn[27] = new JButton("MOD");
        jbtn[28] = new JButton("sqrt");
        jbtn[29] = new JButton("1/x");
        jbtn[30] = new JButton("cbrt");
        jbtn[31] = new JButton("(");
        jbtn[32] = new JButton("e^x");
        jbtn[33] = new JButton("log");
        jbtn[34] = new JButton("ln");
        jbtn[35] = new JButton("x^2");
        jbtn[36] = new JButton(")");
        jbtn[37] = new JButton("10^x");
        jbtn[38] = new JButton("x^y");
        jbtn[38].setActionCommand("^");
        jbtn[39] = new JButton("x!");
        jbtn[40] = new JButton("=");
        jbtn[43] = new JButton("asin");
        jbtn[44] = new JButton("acos");
        jbtn[45] = new JButton("atan");
        jbtn[46] = new JButton("alog");
        jbtn[47] = new JButton("aln");
        jbtn[48] = new JButton("Abs");
        jbtn[49] = new JButton("MEM");
        for (i = 43; i < 50; i++) {
            jbtn[i].setFont(jfont2);
            jbtn[i].addActionListener(this);
        }
        jbtn[43].setForeground(Color.magenta);
        jbtn[44].setForeground(Color.magenta);
        jbtn[45].setForeground(Color.magenta);
        jbtn[46].setForeground(Color.orange);
        jbtn[47].setForeground(Color.orange);
        jbtn[48].setForeground(Color.black);
        jbtn[49].setForeground(Color.red);
        for (i = 21; i <= 40; i++) {
            jbtn[i].setFont(jfont2);
            jbtn[i].addActionListener(this);
        }
        for (i = 22; i <= 24; i++) {
            jbtn[i].setForeground(Color.blue);
        }
        jbtn[21].setForeground(Color.green);
        jbtn[25].setForeground(Color.red);
        jbtn[26].setForeground(Color.orange);
        for (i = 27; i <= 30; i++) {
            jbtn[i].setForeground(Color.gray);
        }
        for (i = 31; i <= 39; i++) {
            if (i == 31 || i == 36)
                jbtn[i].setForeground(Color.red);
            else
                jbtn[i].setForeground(Color.orange);
        }
        jbtn[40].setForeground(Color.red);
        jplbtn = new JPanel();
        jplbtn.setLayout(new GridLayout(6, 8, 2, 2));
        for (i = 17; i <= 22; i++) {
            jplbtn.add(jbtn[i]);
        }
        jplbtn.add(jbtn[43]);
        jplbtn.add(jbtn[16]);
        jplbtn.add(jbtn[33]);
        jplbtn.add(jbtn[34]);
        jplbtn.add(jbtn[46]);
        jplbtn.add(jbtn[47]);
        jplbtn.add(jbtn[32]);
        jplbtn.add(jbtn[23]);
        jplbtn.add(jbtn[44]);
        jplbtn.add(jbtn[39]);
        jplbtn.add(jbtn[7]);
        jplbtn.add(jbtn[8]);
        jplbtn.add(jbtn[9]);
        jplbtn.add(jbtn[10]);
        jplbtn.add(jbtn[37]);
        jplbtn.add(jbtn[24]);
        jplbtn.add(jbtn[45]);
        jplbtn.add(jbtn[29]);
        jplbtn.add(jbtn[4]);
        jplbtn.add(jbtn[5]);
        jplbtn.add(jbtn[6]);
        jplbtn.add(jbtn[11]);
        jplbtn.add(jbtn[38]);
        jplbtn.add(jbtn[31]);
        jplbtn.add(jbtn[27]);
        jplbtn.add(jbtn[30]);
        jplbtn.add(jbtn[1]);
        jplbtn.add(jbtn[2]);
        jplbtn.add(jbtn[3]);
        jplbtn.add(jbtn[12]);
        jplbtn.add(jbtn[26]);
        jplbtn.add(jbtn[36]);
        jplbtn.add(jbtn[25]);
        jplbtn.add(jbtn[28]);
        jplbtn.add(jbtn[0]);
        jplbtn.add(jbtn[15]);
        jplbtn.add(jbtn[49]);
        jplbtn.add(jbtn[13]);
        jplbtn.add(jbtn[35]);
        jplbtn.add(jbtn[48]);
        jplbtn.add(jbtn[14]);
        jplbtn.add(jbtn[40]);
        jplback = new JPanel();
        jplback.setLayout(new GridLayout(1, 1, 2, 2));
        jbtn[41] = new JButton("Bksp");
        jbtn[41].setFont(jfont2);
        jbtn[41].setForeground(Color.darkGray);
        jbtn[41].addActionListener(this);
        jplback.add(jbtn[41]);
        jplctrl = new JPanel();
        jplctrl.setLayout(new GridLayout(1, 2, 2, 2));
        jbtn[42] = new JButton("CE");
        jbtn[42].setFont(jfont2);
        jbtn[42].setForeground(Color.darkGray);
        jbtn[42].addActionListener(this);
        jplctrl.add(jbtn[42]);
        jplmaster.setLayout(new BorderLayout());
        jplmaster.add(jplback, BorderLayout.WEST);
        jplmaster.add(jplctrl, BorderLayout.EAST);
        jplmaster.add(jplbtn, BorderLayout.SOUTH);
        jfrm.getContentPane().add(jplmaster, BorderLayout.SOUTH);
        try {
            UIManager.setLookAndFeel(looks[3].getClassName());
            SwingUtilities.updateComponentTreeUI(jfrm);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jfrm.setResizable(false);
        jfrm.setVisible(true);
        String str;
        s1 = s2 = s3 = str = msg = "";
        i = 0;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String str = ae.getActionCommand();
            boolean gmode;
            boolean rmode;
            if (str.equals("Exit")) {
                int response = JOptionPane.showConfirmDialog(jfrm, "Are U Sure To Exit");
                switch (response) {
                    case JOptionPane.YES_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                }
            } else if (str.equals("0")) {
                s1 += str;
                msg += str;
            } else if (str.equals("1")) {
                s1 += str;
                msg += str;
            } else if (str.equals("2")) {
                s1 += str;
                msg += str;
            } else if (str.equals("3")) {
                s1 += str;
                msg += str;
            } else if (str.equals("4")) {
                s1 += str;
                msg += str;
            } else if (str.equals("5")) {
                s1 += str;
                msg += str;
            } else if (str.equals("6")) {
                s1 += str;
                msg += str;
            } else if (str.equals("7")) {
                s1 += str;
                msg += str;
            } else if (str.equals("8")) {
                s1 += str;
                msg += str;
            } else if (str.equals("9")) {
                s1 += str;
                msg += str;
            } else if (str.equals(".")) {
                s1 += str;
                msg += str;
            } else if (str.equals("/")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "/";
                msg += str;
                k = 1;
            } else if (str.equals("*")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "*";
                msg += str;
                k = 1;
            } else if (str.equals("+")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "+";
                msg += str;
                k = 1;
            } else if (str.equals("-")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "-";
                msg += str;
                k = 1;
            } else if (str.equals("%")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "%";
                msg += str;
                k = 1;
            } else if (str.equals("+/-")) {
                if (k == 0) {
                    firstNumber = assignValue(s1) * -1;
                    s1 = String.valueOf(firstNumber);
                } else {
                    e = 1;
                }
                msg += s1;
            } else if (str.equals("=")) {
                if (e != 1)
                    lastNumber = assignValue(s1);
                else
                    lastNumber = assignValue(s1) * -1;
                s1 = "";
                if (s2.equals("/"))
                    jtfd.setText(Divide());
                else if (s2.equals("*"))
                    jtfd.setText(Multiply());
                else if (s2.equals("-"))
                    jtfd.setText(Subtract());
                else if (s2.equals("+"))
                    jtfd.setText(Add());
                else if (s2.equals("%"))
                    jtfd.setText(Percent());
                else if (s2.equals("^y"))
                    jtfd.setText(xexpy());
                else if (s2.equals("MOD"))
                    jtfd.setText(MOD());
                else if (s2.equals("AND"))
                    jtfd.setText(AND());
                else if (s2.equals("OR"))
                    jtfd.setText(OR());
                else if (s2.equals("XOR"))
                    jtfd.setText(XOR());
                else if (s2.equals("XNOR"))
                    jtfd.setText(XNOR());
                msg = jtfd.getText();
                s1 = msg;
                s3 = jtfd.getText();
                int d;
                k = d = e = 0;
            } else if (str.equals("sqrt")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(Sqrt());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("cbrt")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(cbrt());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("sin")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(sin());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("cos")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(cos());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("tan")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(tan());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("asin")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(asin());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("acos")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(acos());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("atan")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(atan());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("Rand")) {
                jtfd.setText(random());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("CE")) {
                jlab.setText(" Result : = 0.0 ");
                jtfd.setText("");
                s1 = "";
                s2 = "";
                msg = "";
            } else if (str.equals("1/x")) {
                Double k = 0.0;
                k = assignValue(s1);
                k = 1 / k;
                jtfd.setText(k.toString());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("x!")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(fact());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("e^x")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(expx());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("^")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "^y";
                msg += str;
                k = 1;
            } else if (str.equals("10^x")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(tenX());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("x^3")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(xexp3());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("x^2")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(xexp2());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("Abs")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(Abs());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("MOD")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "MOD";
                msg += str;
            } else if (str.equals("log")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(log());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("ln")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(ln());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("alog")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(alog());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("aln")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(aln());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("NOT")) {
                firstNumber = assignValue(s1);
                s1 = "";
                jtfd.setText(NOT());
                msg = jtfd.getText();
                s1 = msg;
            } else if (str.equals("AND")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "AND";
                msg += str;
                k = 1;
            } else if (str.equals("OR")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "OR";
                msg += str;
                k = 1;
            } else if (str.equals("XOR")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "XOR";
                msg += str;
                k = 1;
            } else if (str.equals("XNOR")) {
                firstNumber = assignValue(s1);
                s1 = "";
                s2 = "XNOR";
                msg += str;
                k = 1;
            } else if (str.equals("Degree")) {
                dmode = true;
                rmode = false;
                gmode = false;
            } else if (str.equals("Radian")) {
                rmode = true;
                dmode = false;
                gmode = false;
            } else if (str.equals("Grade")) {
                gmode = true;
                rmode = false;
                dmode = false;
            } else if (str.equals("MEM")) {
                jtfd.setText(s3);
            } else if (str.equals("Created By")) {
                JDialog jdlg = new JDialog(jfrm, "About Java Scientific Calculator", true);
                jdlg.setSize(300, 150);
                JTextArea jtxt = new JTextArea(10, 10);
                StringBuffer s = new StringBuffer();
                s.append("\nCalculator Information\n\n");
                s.append("Developer : Abhinaw Kumar\n");
                s.append("Sun Certified Java Programmer\n");
                jtxt.setText(s.toString());
                jtxt.setFont(new Font("Times New Roman", 1, 13));
                jtxt.setForeground(Color.red);
                jtxt.setBackground(Color.green);
                jtxt.setEditable(false);
                jdlg.add(jtxt);
                jdlg.setLocation(250, 250);
                jdlg.setResizable(false);
                jdlg.setVisible(true);
            }
            jtfd.setText(msg);
            jlab.setText("Result : =" + s3);
        } catch (Exception e) {
            jtfd.setText("Illegal Arithematic Operation, Press CE");
            s1 = "";
            s2 = "";
            msg = "";
        }
    }

    private double assignValue(String s) {
        return Double.parseDouble(s);
    }

    private String Percent() {
        Double k = 0.0;
        k = ((firstNumber / lastNumber) * 100.0);
        return (k.toString());
    }

    private String Inverse() {
        Double k = 0.0;
        k = 1 / firstNumber;
        return (k.toString());
    }

    private String Sqrt() {
        Double k = 0.0;
        k = Math.sqrt(firstNumber);
        return (k.toString());
    }

    private String cbrt() {
        Double k = 0.0;
        k = Math.cbrt(firstNumber);
        return (k.toString());
    }

    private String expx() {
        Double k = 0.0;
        k = Math.exp(firstNumber);
        return (k.toString());
    }

    private String tenX() {
        Double k = 0.0;
        k = Math.pow(10, firstNumber);
        return (k.toString());
    }

    private String xexpy() {
        Double k = 0.0;
        k = Math.pow(firstNumber, lastNumber);
        return (k.toString());
    }

    private String xexp3() {
        Double k = 0.0;
        k = Math.pow(firstNumber, 3);
        return (k.toString());
    }

    private String xexp2() {
        Double k = 0.0;
        k = Math.pow(firstNumber, 2);
        return (k.toString());
    }

    private String Abs() {
        Double k = 0.0;
        k = Math.abs(firstNumber);
        return (k.toString());
    }

    private String MOD() {
        Double k = 0.0;
        k = firstNumber - (int) (firstNumber / lastNumber) * lastNumber;
        return (k.toString());
    }

    private String Divide() {
        Double k = 0.0;
        try {
            k = firstNumber / lastNumber;
            return (k.toString());
        } finally {
            jtfd.setText("");
            s1 = "";
            s2 = "";
            msg = "";
            return (k.toString());
        }
    }

    private String Multiply() {
        Double k = 0.0;
        k = firstNumber * lastNumber;
        return (k.toString());
    }

    private String Add() {
        Double k = 0.0;
        k = firstNumber + lastNumber;
        return (k.toString());
    }

    private String Subtract() {
        Double k = 0.0;
        k = firstNumber - lastNumber;
        return (k.toString());
    }

    private String sin() {
        Double k = 0.0;
        k = Math.sin(firstNumber);
        if (dmode) {
            k = Math.sin(Math.toRadians(firstNumber));
        }
        return (k.toString());
    }

    private String cos() {
        Double k = 0.0;
        k = Math.cos(firstNumber);
        if (dmode) {
            k = Math.cos(Math.toRadians(firstNumber));
        }
        return (k.toString());
    }

    private String tan() {
        Double k = 0.0;
        k = Math.tan(firstNumber);
        if (dmode) {
            k = Math.tan(Math.toRadians(firstNumber));
        }
        return (k.toString());
    }

    private String asin() {
        Double k = 0.0;
        k = Math.asin(firstNumber);
        if (dmode) {
            k = Math.asin(Math.toRadians(firstNumber));
        }
        return (k.toString());
    }

    private String acos() {
        Double k = 0.0;
        k = Math.acos(firstNumber);
        if (dmode) {
            k = Math.acos(Math.toRadians(firstNumber));
        }
        return (k.toString());
    }

    private String atan() {
        Double k = 0.0;
        k = Math.atan(firstNumber);
        if (dmode) {
            k = Math.atan(Math.toDegrees(firstNumber));
        }
        return (k.toString());
    }

    private String log() {
        Double k = 0.0;
        k = Math.log10(firstNumber);
        return (k.toString());
    }

    private String ln() {
        Double k = 0.0;
        k = Math.log(firstNumber);
        return (k.toString());
    }

    private String aln() {
        Double k = 0.0;
        k = Math.exp(firstNumber);
        return (k.toString());
    }

    private String alog() {
        Double k = 0.0;
        k = Math.pow(10, firstNumber);
        return (k.toString());
    }

    private String random() {
        Double k = 0.0;
        Random r = new Random();
        k = r.nextDouble();
        return (k.toString());
    }

    private String AND() {
        Integer k = 0;
        int m, n;
        m = (int) firstNumber;
        n = (int) lastNumber;
        k = m & n;
        return (k.toString());
    }

    private String OR() {
        Integer k = 0;
        int m, n;
        m = (int) firstNumber;
        n = (int) lastNumber;
        k = m | n;
        return (k.toString());
    }

    private String NOT() {
        Integer k = 0;
        int m;
        m = (int) firstNumber;
        k = ~m;
        return (k.toString());
    }

    private String XOR() {
        Integer k = 0;
        int m, n;
        m = (int) firstNumber;
        n = (int) lastNumber;
        k = m ^ n;
        return (k.toString());
    }

    private String XNOR() {
        Integer k = 0;
        int m, n;
        m = (int) firstNumber;
        n = (int) lastNumber;
        k = ~(m ^ n);
        return (k.toString());
    }

    private String fact() {
        Double f = 1.0;
        if (firstNumber >= 0) {
            for (int i = 1; i <= firstNumber; i++) {
                f *= (double) i;
            }
            return (f.toString());
        } else {
            return ("Arithematic Exception, Press CE");
        }
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(ScientificCalculatorApp::new);
    }
}
