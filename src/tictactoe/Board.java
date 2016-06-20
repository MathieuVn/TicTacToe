/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    // Properties
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public Cell[][] board;
    Scanner scanner;
    
    // Constructors
    public Board() {
        board = new Cell[ROWS][COLS];
        scanner = new Scanner(System.in);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }
    
    // Methods
    public void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col].clear();
            }
        }
    }
    
    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            String s = "|";
            for (int j = 0; j < COLS; j++) {
                s += board[i][j].cellToString();
                s += "|";
            }
            System.out.println(s);
        }
        System.out.println("-------");
    }
    
    public boolean isFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].isBlank()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!board[i][j].isBlank()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean weGotWinner(Square player) {
        // Rows
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].getContent() == player
                    && board[row][1].getContent() == player
                    && board[row][2].getContent() == player) {
                return true;
            }
        }
        // Columns
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].getContent() == player
                    && board[1][col].getContent() == player
                    && board[2][col].getContent() == player) {
                return true;
            }
        }
        
        // Diagonal
        if (board[0][0].getContent() == player
                && board[1][1].getContent() == player
                && board[2][2].getContent() == player) {
            return true;
        } else if (board[2][0].getContent() == player
                && board[1][1].getContent() == player
                && board[0][2].getContent() == player) {
            return true;
        }
        return false;
    }
    
    public void playSquare(Square player) {
        int move = scanner.nextInt();
        int col = (int) move % 10;
        int row = (int) move / 10;
        if (row > 3 || col > 3 || row <= 0 || col <= 0 ) {
            System.out.println("Please enter a valid case [1-3][1-3]");
            playSquare(player);
        } else if (getBoardCase(row - 1, col - 1) == Square.BLANK) {
            setBoardCase(row - 1, col - 1, player);
        } else {
            System.out.println("You can't play on this case");
            playSquare(player);
        }
    }
    
    public void playSquare(Square player, int move) {
        int col = (int) move % 10;
        int row = (int) move / 10;
        if (row > 3 || col > 3 || row <= 0 || col <= 0 ) {
            System.out.println("Please enter a valid case [1-3][1-3]");
            playSquare(player, 0);
        } else if (getBoardCase(row - 1, col - 1) == Square.BLANK) {
            setBoardCase(row - 1, col - 1, player);
        } else {
            System.out.println("You can't play on this case");
            playSquare(player, 0);
        }
    }
       
    // Getters and Setters
    public Cell[][] getBoard() {
        return board;
    }
    
    public Square getBoardCase(int i, int j) {
        return board[i][j].getContent();
    }
    
    public void setBoardCase(int i, int j, Square player) {
        board[i][j].setContent(player);
    }
    
    public ArrayList<Cell> getAvailableMoves() {
        ArrayList<Cell> result = new ArrayList<>();
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].isBlank()) {
                    result.add(board[i][j]);
                }
            }
        }
        return result;
    }
    
}
