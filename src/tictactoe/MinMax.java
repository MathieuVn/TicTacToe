/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;
import java.util.ArrayList;

public class MinMax extends AIPlayer {
    
    // Constructor
    public MinMax(Board board) {
        super(board);
    }
    
    // Methods
    @Override
    int move() {
        return minimax(2, computerSquare)[1];
    }
    
    // Minimax return [int score, int move]
    private int[] minimax(int depth, Square player) {
        // Get the list of possible moves
        ArrayList<Cell> nextMoves = this.board.getAvailableMoves();
        
        int bestScore = (player == computerSquare) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestMove = 0;
        
        if(nextMoves.isEmpty() || depth == 0) {
            // Gameover or depth reached, evaluate score
            bestScore = evaluate();
        } else {
            for (Cell move : nextMoves) {
                move.content = player;
                if(player == computerSquare) { // Maximaze score
                    currentScore = minimax(depth - 1, opponentSquare )[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestMove = (move.row + 1) * 10 + move.col + 1;
                    }
                    
                } else {
                    currentScore = minimax(depth - 1, computerSquare)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestMove = (move.row + 1) * 10 + move.col + 1;
                    }
                }
                // Undo move
                move.setContent(Square.BLANK);
            }
        }
        return new int[] {bestScore, bestMove};
    }
    
    /** Returns +100, +10, +1 for 3-, 2- or 1-in-a-line for computer
     *  Returns -100, -10, -1 for 3-, 2- or 1-in-a-line for opponent
     */
    public int evaluate() {
        int score = 0;
        score += evaluateLine(0, 0, 0, 1, 0, 2); // Row 0
        score += evaluateLine(1, 0, 1, 1, 1, 2); // Row 1
        score += evaluateLine(2, 0, 2, 1, 2, 2); // Row 2
        score += evaluateLine(0, 0, 1, 0, 2, 0); // Col 0
        score += evaluateLine(0, 1, 1, 1, 2, 1); // Col 1
        score += evaluateLine(0, 2, 1, 2, 2, 2); // Col 2
        score += evaluateLine(0, 0, 1, 1, 2, 2); // Diag
        score += evaluateLine(2, 0, 1, 1, 0, 2); // Rev Diag
        return score;
    }
    
    private int evaluateLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        int score = 0;
        
        // First Cell
        if (board.getBoardCase(x1, y1) == computerSquare) {
            score = 1;
        } else if (board.getBoardCase(x1, y1) == opponentSquare) {
            score = -1;
        }
        
        // Second Cell
        if (board.getBoardCase(x2, y2) == computerSquare) {
            if (score == 1) {
                score = 10;
            } else if (score == -1) {
                return 0;
            } else {
                score = 1;
            }
        } else if (board.getBoardCase(x2, y2) == opponentSquare) {
            if (score == -1) {
                score = -10;
            } else if (score == 1) {
                return 0;
            } else {
                score = -1;
            }
        }
        
        // Third Cell
        if (board.getBoardCase(x3, y3) == computerSquare) {
            if (score > 0) {
                score *= 10;
            } else if (score < 0) {
                score = 0;
            } else {
                score = 1;
            }
        } else if (board.getBoardCase(x3, y3) == opponentSquare) {
            if (score < 0) {
                score *= 10;
            } else if (score > 1) {
                score = 0;
            } else {
                score = -1;
            }
        }
    return score;  
    }
   
}
