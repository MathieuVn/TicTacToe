/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;

public class TicTacToe {

    Board board;
    
    // Constructor
    public TicTacToe() {
        // Init empty board
        board = new Board();
    }
    
    // Methods
    public void play() {
        System.out.println("===========================================");
        System.out.println("===   Welcome to the Tic Tac Toe game   ===");
        System.out.println("===           2016 Version 1.1          ===");
        System.out.println("===========================================");
        
        Square player = Square.CROSS;
        
        while (true) {
            this.board.printBoard();
            System.out.println("Player " + player.toString() + " to play:");
            board.playSquare(player);
            if (board.weGotWinner(player)) {
                System.out.println("Player " + player.toString() + " has won !");
                break;
            } else if (board.isFull()) {
                System.out.println("Draw ! No winner, no looser");
                break;                
            }
            player = player.opposite();
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
