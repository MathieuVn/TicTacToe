/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;
import java.util.Scanner;

public class TicTacToe {

    final int BLANK = 0;
    final int CROSS = 1;
    final int NOUGHT = -1;
    
    int[][] board = new int[3][3];
    Scanner scanner = new Scanner(System.in);
    
    // Constructor
    public TicTacToe() {
        // Init empty board
        for (int i=0; i < 3; i++)
            for (int j=0; j < 3; j++)
                this.board[i][j] = BLANK;
    }
    
    // Methods
    public void crossPlay() {
        int move = scanner.nextInt();
        int j = (int) move % 10;
        int i = (int) move / 10;
        if (j > 3 || i > 3 || j <= 0 || i <= 0 ) {
            System.out.println("Please enter a valid case [1-3][1-3]");
            crossPlay();
        } else if (board[i - 1][j - 1] == BLANK) {
            board[i - 1][j - 1] = CROSS;
        } else {
            System.out.println("You can't play on this case");
            crossPlay();
        }
    }
    
    public void circlePlay() {
        int move = scanner.nextInt();
        int j = (int) move % 10;
        int i = (int) move / 10;
        if (j > 3 || i > 3 || j <= 0 || i <= 0 ) {
            System.out.println("Please enter a valid case [1-3][1-3]");
            circlePlay();
        } else if (board[i - 1][j - 1] == BLANK) {
            board[i - 1][j - 1] = NOUGHT;
        } else {
            System.out.println("You can't play on this case");
            circlePlay();
        }
    }
    
    public int weHaveAWinner() {
        // Returns 1 if CROSS wins, -1 if CIRCLE wins or 0 if no winners
        // Rows
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[i][j];
            }
            if (Math.abs(sum) == 3) {
                return (int) Math.signum(sum);
            }
        }
        // Columns
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += board[i][j];
            }
            if (Math.abs(sum) == 3) {
                return (int) Math.signum(sum);
            }
        }
        // Diag
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < 3; i++) {
            sum += board[i][i];
            sum2 += board[i][2 - i];
        }
        if (Math.abs(sum) == 3) {
            return (int) Math.signum(sum);
        }
        if (Math.abs(sum2) == 3) {
            return (int) Math.signum(sum2);
        }
        return 0;
    }
    
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            String s = "|";
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case NOUGHT: s += "O";
                        break;
                    case BLANK: s += " ";
                        break;
                    case CROSS: s += "X";
                        break;  
                }
                s += "|";
            }
            System.out.println(s);
        }
        System.out.println("-------");
    }
    
    public void play() {
        System.out.println("===========================================");
        System.out.println("===   Welcome to the Tic Tac Toe game   ===");
        System.out.println("===========================================");
        
        int count = 0;
        int player = 1;
        
        while (true) {
            this.printBoard();
            System.out.println("Player " + player + " to play:");
            if (player == 1) {
                this.crossPlay();
                count++;
                player = 2;
            } else if (player == 2) {
                this.circlePlay();
                count++;
                player = 1;
            }
            if (weHaveAWinner() == 1) {
                this.printBoard();
                System.out.println("Player 1 wins ! Congrats");
                break;
            } else if (weHaveAWinner() == -1) {
                this.printBoard();
                System.out.println("Player 2 wins ! Congrats");
                break;                
            } else if (count == 9) {
                this.printBoard();
                System.out.println("Draw ! No winner, no looser");
                break;
            }
        }
    }
    
    public void robotPlay(int playerNum) {
        // Robot (AI) using MinMax algorithm
        // playerNum == 1 means first to play
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe myGame = new TicTacToe();
        myGame.play();
    }
    
}
