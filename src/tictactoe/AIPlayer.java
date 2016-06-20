/*
 *  Copyright 2016 Mathieu Voisin
 */

package tictactoe;

public abstract class AIPlayer {
    // Properties
    protected int ROWS = Board.ROWS;
    protected int COLS = Board.COLS;
    
    protected Board board;
    protected Square computerSquare;
    protected Square opponentSquare;
    
    // Constructor
    public AIPlayer(Board newBoard) {
        board = newBoard;
    }
    
    // Getters & Setters
    public void setSquare(Square computerSquare) {
        this.computerSquare = computerSquare;
        this.opponentSquare = computerSquare.opposite();
    }
    
    // Methods
    abstract int move();
}
