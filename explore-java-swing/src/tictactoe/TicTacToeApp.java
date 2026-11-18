package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TicTacToeApp extends JFrame {
    private final JButton[] buttons = new JButton[9];
    private final String[]  board   = new String[9];
    private final JButton startButton = new JButton("Start");
    private final JButton resetButton = new JButton("Reset");
    private final JLabel status = new JLabel("Tic Tac Toe", SwingConstants.CENTER);
    private String currentPlayer = "X";
    private int moves = 0;
    private boolean gameStarted = false;
    // All possible winning combinations
    private static final int[][] WINNING_COMBINATIONS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    public TicTacToeApp() {
        setTitle("Tic Tac Toe");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        // Status label
        status.setFont(new Font("Arial", Font.BOLD, 22));
        add(status, BorderLayout.NORTH);
        // Game board
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 2, 2));
        for (int i = 0; i < 9; i++) {
            board[i] = "";
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 35));
            buttons[i].setEnabled(false);
            final int position = i;
            buttons[i].addActionListener(e -> play(position));
            boardPanel.add(buttons[i]);
        }
        add(boardPanel, BorderLayout.CENTER);
        // Start and Reset buttons
        JPanel controlPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        resetButton.setEnabled(false);
        startButton.addActionListener(e -> startGame());
        resetButton.addActionListener(e -> resetGame());
        controlPanel.add(startButton);
        controlPanel.add(resetButton);
        add(controlPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Start the game
    private void startGame() {
        gameStarted = true;
        currentPlayer = "X";
        moves = 0;
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
        status.setText("Player X's Turn");
    }

    // Handle button click
    private void play(int position) {
        if (!gameStarted || !board[position].isEmpty()) {
            return;
        }
        board[position] = currentPlayer;
        buttons[position].setText(currentPlayer);
        buttons[position].setForeground(currentPlayer.equals("X") ? Color.RED : Color.BLUE);
        moves++;
        if (hasWinner()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " Has Won!");
            endGame();
            return;
        }
        if (moves == 9) {
            JOptionPane.showMessageDialog(this, "Match Draw!");
            endGame();
            return;
        }
        // Switch player
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        status.setText("Player " + currentPlayer + "'s Turn");
    }

    // Check winner
    private boolean hasWinner() {
        for (int[] combination : WINNING_COMBINATIONS) {
            int a = combination[0];
            int b = combination[1];
            int c = combination[2];
            if (!board[a].isEmpty() && board[a].equals(board[b]) && board[b].equals(board[c])) {
                return true;
            }
        }
        return false;
    }

    // Stop the game
    private void endGame() {
        gameStarted = false;
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        startButton.setEnabled(true);
        status.setText("Game Over");
    }

    // Reset the game
    private void resetGame() {
        gameStarted = false;
        currentPlayer = "X";
        moves = 0;
        Arrays.fill(board, "");
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(false);
            button.setBackground(Color.WHITE);
        }
        startButton.setEnabled(true);
        resetButton.setEnabled(false);
        status.setText("Tic Tac Toe");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeApp::new);
    }
}
