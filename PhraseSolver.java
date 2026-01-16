
import java.util.Scanner;

public class PhraseSolver {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean solved;

    public PhraseSolver() {
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        solved = false;
    }

    public void play() {
        boolean solved = false;
        int currentPlayer = 1;

        Scanner input = new Scanner(System.in);

        boolean correct = true;

        while (!solved) {
            System.out.println("Letter Guess Value:" + board.getCurrentLetterValue());

            if (currentPlayer == 1) {
                System.out.println("You have " + player1.getPoints() + " points.");
                System.out.println(player1.getName() + " it's your turn.");

                currentPlayer = 2;
            } else {
                System.out.println(player2.getName() + " it's your turn.");
                currentPlayer = 1;
            }
            String playerGuess = input.nextLine();
            if (board.guessLetter(playerGuess)) {
                System.out.println("Correct!");
                if(currentPlayer == 1) {
                    player1.setPoints(board.getCurrentLetterValue() + player1.getPoints());
                    currentPlayer = 1;
                } else {
                    player2.setPoints(board.getCurrentLetterValue() + player2.getPoints());
                    currentPlayer = 2;
                }
                if (board.isSolved(playerGuess)) {
                    solved = true;
                    if (player1.getPoints() > player2.getPoints()) {
                        System.out.println("Player 1 wins!");
                    } else if (player1.getPoints() < player2.getPoints()) {
                        System.out.println("Player 2 wins!");
                    } else {
                        System.out.println("It's a tie!");
                    }
                }
                    
            }
            System.out.println(board.getSolvedPhrase());

            solved = true;
        }
    }
}
