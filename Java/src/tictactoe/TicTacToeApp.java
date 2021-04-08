package tictactoe;

// Simple Java Game

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TicTacToeApp implements ActionListener {
    private JFrame jfrm;
    private JButton[] jbtn;
    private JMenu jmenu;
    private JMenuItem jexit;
    private JMenuBar jmb;
    private JButton R, X, O;
    private JPanel[] jpnl;
    private Font[] font;
    private JLabel jlab;
    private Timer timer;
    private static int i, x, o, k, d;
    private static int k0, k1, k2, k3, k4, k5, k6, k7, k8;
    private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

    private TicTacToeApp() {
        jfrm = new JFrame("Simple Java Game");
        jfrm.setLayout(new BorderLayout());
        jfrm.setSize(230, 350);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        font = new Font[3];
        font[0] = new Font("Monospaced", Font.BOLD, 15);
        font[1] = new Font("SansSerif", Font.BOLD, 15);
        font[2] = new Font("Times New Roman", Font.BOLD, 15);
        jmb = new JMenuBar();
        jmenu = new JMenu("Menu");
        jmenu.setFont(font[0]);
        jmenu.setMnemonic(KeyEvent.VK_M);
        jexit = new JMenuItem("Exit");
        jexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        jexit.setFont(font[1]);
        jexit.setForeground(Color.black);
        jexit.addActionListener(this);
        jmenu.add(jexit);
        jmb.add(jmenu);
        jfrm.setJMenuBar(jmb);
        jbtn = new JButton[12];
        for (i = 0; i < 12; i++) {
            jbtn[i] = new JButton("");
            jbtn[i].setFont(font[2]);
            jbtn[i].setPreferredSize(new Dimension(20, 50));
            jbtn[i].setEnabled(false);
            jbtn[i].setForeground(Color.black);
            jbtn[i].setBackground(Color.white);
            jbtn[i].addActionListener(this);
            jbtn[i].setActionCommand(String.valueOf(i));
        }
        jbtn[11].setText("Reset");
        jbtn[11].setFont(new Font("Monospaced", Font.BOLD, 12));
        jbtn[11].setForeground(Color.green);
        jbtn[11].setForeground(Color.black);
        jbtn[11].setActionCommand("Reset");
        jpnl = new JPanel[3];
        jpnl[0] = new JPanel();
        jpnl[0].setLayout(new GridLayout(4, 3, 2, 2));
        for (i = 0; i < 9; i++) {
            jpnl[0].add(jbtn[i]);
        }
        jpnl[0].add(jbtn[11]);
        jfrm.add(jpnl[0], BorderLayout.CENTER);
        R = new JButton("Start");
        X = new JButton("X");
        O = new JButton("O");
        R.setFont(new Font("Monospaced", Font.BOLD, 10));
        X.setFont(font[0]);
        O.setFont(font[0]);
        R.setForeground(Color.red);
        R.setBackground(Color.black);
        X.setForeground(Color.black);
        O.setForeground(Color.black);
        R.setPreferredSize(new Dimension(20, 50));
        X.setPreferredSize(new Dimension(20, 50));
        O.setPreferredSize(new Dimension(20, 50));
        R.addActionListener(this);
        X.addActionListener(this);
        O.addActionListener(this);
        X.setEnabled(false);
        O.setEnabled(false);
        jpnl[1] = new JPanel();
        jpnl[1].setLayout(new GridLayout(1, 3, 2, 2));
        jpnl[1].add(R);
        jpnl[1].add(X);
        jpnl[1].add(O);
        jfrm.add(jpnl[1], BorderLayout.SOUTH);
        jlab = new JLabel("Tic Tac Toe");
        jlab.setBackground(Color.green);
        jlab.setForeground(Color.red);
        jlab.setFont(new Font("Monospaced", Font.BOLD, 20));
        jpnl[2] = new JPanel();
        jpnl[2].setLayout(new FlowLayout());
        jpnl[2].add(jlab);
        jfrm.add(jpnl[2], BorderLayout.NORTH);
        timer = new Timer(1, (ActionEvent ae) -> resultGame());
        try {
            UIManager.setLookAndFeel(looks[1].getClassName());
            SwingUtilities.updateComponentTreeUI(jfrm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jfrm.setResizable(false);
        jfrm.setTitle("Tic Tac Toe");
        jfrm.setVisible(true);
    }

    private void resultGame() {
        if (((jbtn[0].getText().equals("X")) && (jbtn[1].getText().equals("X")) && (jbtn[2].getText().equals("X"))) || ((jbtn[3].getText().equals("X")) && (jbtn[4].getText().equals("X")) && (jbtn[5].getText().equals("X"))) || ((jbtn[6].getText().equals("X")) && (jbtn[7].getText().equals("X")) && (jbtn[8].getText().equals("X"))) || ((jbtn[0].getText().equals("X")) && (jbtn[3].getText().equals("X")) && (jbtn[6].getText().equals("X"))) ||
                ((jbtn[1].getText().equals("X")) && (jbtn[4].getText().equals("X")) && (jbtn[7].getText().equals("X"))) || ((jbtn[2].getText().equals("X")) && (jbtn[5].getText().equals("X")) && (jbtn[8].getText().equals("X"))) || ((jbtn[0].getText().equals("X")) && (jbtn[4].getText().equals("X")) && (jbtn[8].getText().equals("X"))) || ((jbtn[2].getText().equals("X")) && (jbtn[4].getText().equals("X")) && (jbtn[6].getText().equals("X")))) {
            JOptionPane.showMessageDialog(jfrm, "Player X Has Won");
            d = 1;
            timer.stop();
            for (i = 0; i < 9; i++) {
                jbtn[i].setText("");
                jbtn[i].setEnabled(false);
            }
            return;
        } else if (((jbtn[0].getText().equals("O")) && (jbtn[1].getText().equals("O")) && (jbtn[2].getText().equals("O"))) || ((jbtn[3].getText().equals("O")) && (jbtn[4].getText().equals("O")) && (jbtn[5].getText().equals("O"))) || ((jbtn[6].getText().equals("O")) && (jbtn[7].getText().equals("O")) && (jbtn[8].getText().equals("O"))) || ((jbtn[0].getText().equals("O")) && (jbtn[3].getText().equals("O")) && (jbtn[6].getText().equals("O"))) ||
                ((jbtn[1].getText().equals("O")) && (jbtn[4].getText().equals("O")) && (jbtn[7].getText().equals("O"))) || ((jbtn[2].getText().equals("O")) && (jbtn[5].getText().equals("O")) && (jbtn[8].getText().equals("O"))) || ((jbtn[0].getText().equals("O")) && (jbtn[4].getText().equals("O")) && (jbtn[8].getText().equals("O"))) || ((jbtn[2].getText().equals("O")) && (jbtn[4].getText().equals("O")) && (jbtn[6].getText().equals("O")))) {
            JOptionPane.showMessageDialog(jfrm, "Player O Has Won");
            d = 1;
            timer.stop();
            for (i = 0; i < 9; i++) {
                jbtn[i].setText("");
                jbtn[i].setEnabled(false);
            }
            return;
        } else {
            if (k == 9 && d == 0) {
                JOptionPane.showMessageDialog(jfrm, "Match Draw");
                timer.stop();
                for (i = 0; i < 9; i++) {
                    jbtn[i].setText("");
                    jbtn[i].setEnabled(false);
                }
                return;
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Exit")) {
            int response = JOptionPane.showConfirmDialog(jfrm, "Are U Sure To Exit");
            switch (response) {
                case JOptionPane.YES_OPTION:
                    System.gc();
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }
        } else if (str.equals("Start")) {
            for (i = 0; i < 9; i++) {
                jbtn[i].setEnabled(true);
            }
            X.setEnabled(true);
            O.setEnabled(true);
            jbtn[11].setEnabled(true);
            R.setEnabled(false);
            timer.start();
        } else if (str.equals("Reset")) {
            timer.stop();
            for (i = 0; i < 9; i++) {
                jbtn[i].setText("");
                jbtn[i].setEnabled(false);
                jbtn[i].setBackground(Color.white);
            }
            X.setEnabled(false);
            O.setEnabled(false);
            jbtn[11].setEnabled(false);
            R.setEnabled(true);
            x = 0;
            o = 0;
            k = 0;
            d = 0;
            k0 = 0;
            k1 = 0;
            k2 = 0;
            k3 = 0;
            k4 = 0;
            k5 = 0;
            k6 = 0;
            k7 = 0;
            k8 = 0;
        } else if (str.equals("X")) {
            x = 1;
            X.setEnabled(false);
            O.setEnabled(false);
        } else if (str.equals("O")) {
            o = 1;
            X.setEnabled(false);
            O.setEnabled(false);
        } else if (str.equals("0")) {
            if (k0 == 0) {
                if (x == 1) {
                    jbtn[0].setText("X");
                    jbtn[0].setForeground(Color.red);
                    jbtn[0].setBackground(Color.black);
                    k0++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[0].setText("O");
                    jbtn[0].setForeground(Color.blue);
                    jbtn[0].setBackground(Color.green);
                    k0++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("1")) {
            if (k1 == 0) {
                if (x == 1) {
                    jbtn[1].setText("X");
                    jbtn[1].setForeground(Color.red);
                    jbtn[1].setBackground(Color.black);
                    k1++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[1].setText("O");
                    jbtn[1].setForeground(Color.blue);
                    jbtn[1].setBackground(Color.green);
                    k1++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("2")) {
            if (k2 == 0) {
                if (x == 1) {
                    jbtn[2].setText("X");
                    jbtn[2].setForeground(Color.red);
                    jbtn[2].setBackground(Color.black);
                    k2++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[2].setText("O");
                    jbtn[2].setForeground(Color.blue);
                    jbtn[2].setBackground(Color.green);
                    k2++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("3")) {
            if (k3 == 0) {
                if (x == 1) {
                    jbtn[3].setText("X");
                    jbtn[3].setForeground(Color.red);
                    jbtn[3].setBackground(Color.black);
                    k3++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[3].setText("O");
                    jbtn[3].setForeground(Color.blue);
                    jbtn[3].setBackground(Color.green);
                    k3++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("4")) {
            if (k4 == 0) {
                if (x == 1) {
                    jbtn[4].setText("X");
                    jbtn[4].setForeground(Color.red);
                    jbtn[4].setBackground(Color.black);
                    k4++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[4].setText("O");
                    jbtn[4].setForeground(Color.blue);
                    jbtn[4].setBackground(Color.green);
                    k4++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("5")) {
            if (k5 == 0) {
                if (x == 1) {
                    jbtn[5].setText("X");
                    jbtn[5].setForeground(Color.red);
                    jbtn[5].setBackground(Color.black);
                    k5++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[5].setText("O");
                    jbtn[5].setForeground(Color.blue);
                    jbtn[5].setBackground(Color.green);
                    k5++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("6")) {
            if (k6 == 0) {
                if (x == 1) {
                    jbtn[6].setText("X");
                    jbtn[6].setForeground(Color.red);
                    jbtn[6].setBackground(Color.black);
                    k6++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[6].setText("O");
                    jbtn[6].setForeground(Color.blue);
                    jbtn[6].setBackground(Color.green);
                    k6++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("7")) {
            if (k7 == 0) {
                if (x == 1) {
                    jbtn[7].setText("X");
                    jbtn[7].setForeground(Color.red);
                    jbtn[7].setBackground(Color.black);
                    k7++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[7].setText("O");
                    jbtn[7].setForeground(Color.blue);
                    jbtn[7].setBackground(Color.green);
                    k7++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        } else if (str.equals("8")) {
            if (k8 == 0) {
                if (x == 1) {
                    jbtn[8].setText("X");
                    jbtn[8].setForeground(Color.red);
                    jbtn[8].setBackground(Color.black);
                    k8++;
                    O.setEnabled(true);
                    X.setEnabled(false);
                    x = 0;
                    k++;
                } else if (o == 1) {
                    jbtn[8].setText("O");
                    jbtn[8].setForeground(Color.blue);
                    jbtn[8].setBackground(Color.green);
                    k8++;
                    O.setEnabled(false);
                    X.setEnabled(true);
                    o = 0;
                    k++;
                }
            } else {
                JOptionPane.showMessageDialog(jfrm, "Wrong Entry,Plz Choose Right Position");
                return;
            }
        }
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> new TicTacToeApp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
