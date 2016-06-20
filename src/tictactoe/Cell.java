/*
 *  Copyright 2016 Mathieu Voisin
 */

package tictactoe;

public class Cell {
    
    // Properties
    Square content;
    int row, col;
    
    // Constructors
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }
    
    // Getters and Setters
    public void setContent(Square newContent) {
        this.content = newContent;
    }
    
    public Square getContent() {
        return content;
    }
    
    // Methods
    public void clear() {
        content = Square.BLANK;
    }
    
    public String cellToString() {
        switch (content) {
            case BLANK: return " ";
            case CROSS: return "X";
            case NOUGHT: return "O";
        }
        return " ";
    }
    
    public boolean isBlank() {
        return content == Square.BLANK;
    }

}
