/* Copyright 2016 Mathieu Voisin
 */
package tictactoe;
import java.util.Scanner;

public class TicTacToe {

    Board board;
    
    // Constructor
    public TicTacToe() {
        // Init empty board
        board = new Board();
        Scanner sc = new Scanner(System.in);
        System.out.println("===========================================");
        System.out.println("===   Welcome to the Tic Tac Toe game   ===");
        System.out.println("===           2016 Version 2.1          ===");
        System.out.println("===========================================");
        System.out.println(" ");
        System.out.println("          1: Human vs Computer");
        System.out.println("          2: Human vs Human");
        
        while(true) {
            int answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("Who is starting ?");
                System.out.println("1: Human");
                System.out.println("2: Computer");
                if (sc.nextInt() == 1) {
                    play(true, Square.NOUGHT);
                    break;
                } else {
                    play(true, Square.CROSS);
                    break;
                }
            } else if (answer == 2) {
                play(false, Square.CROSS);
                break;
            } else {
                System.out.println("Please enter 1 or 2");
            }
        }
    }
    
    // Methods
    public void play(boolean withComputer, Square computerSquare) {
        // CROSS player start first
        Square player = Square.CROSS;
        
        if (withComputer) {
            MinMax aiPlayer = new MinMax(board);
            aiPlayer.setSquare(computerSquare);
            
            while (true) {
                if (computerSquare == player) {
                    if (board.isEmpty()) {
                        board.playSquare(player, 11);
                    } else {
                        board.playSquare(player, aiPlayer.move());
                    }
                } else {
                    this.board.printBoard();
                    System.out.println("Player " + player.toString() + " has to play:");
                    board.playSquare(player);
                }
                if (board.weGotWinner(player)) {
                    this.board.printBoard();
                    System.out.println("Player " + player.toString() + " has won !");
                    break;
                } else if (board.isFull()) {
                    this.board.printBoard();
                    System.out.println("Draw ! No winner, no looser");
                    break;                
                }
                player = player.opposite();
            }
            
        } else {
            while (true) {
                this.board.printBoard();
                System.out.println("Player " + player.toString() + " to play:");
                board.playSquare(player);
                if (board.weGotWinner(player)) {
                    this.board.printBoard();
                    System.out.println("Player " + player.toString() + " has won !");
                    break;
                } else if (board.isFull()) {
                    this.board.printBoard();
                    System.out.println("Draw ! No winner, no looser");
                    break;                
                }
                player = player.opposite();
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe myGame = new TicTacToe();
    }   
}
