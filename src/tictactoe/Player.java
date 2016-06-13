/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;

public enum Player {
    CROSS,
    NOUGHT;
    
    public Player opposite() {
        return this == CROSS ? NOUGHT : CROSS;
    }    
}
