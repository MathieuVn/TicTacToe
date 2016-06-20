/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;

public enum Square {
    BLANK,
    CROSS,
    NOUGHT;
    
    public Square opposite() {
        return this == CROSS ? NOUGHT : CROSS;
    }    
}
