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
        Scanner input = new Scanner(System.in);
        int currentPlayer = 1;

        while (!solved) {
            board.setLetterValue();

            if (currentPlayer % 2 == 1) {
                System.out.println("\n" + player1.getName() + " it is your turn to guess");
            } else {
                System.out.println("\n" + player2.getName() + " it is your turn to guess");
            }

            System.out.println("\nCurrent phrase: " + board.getSolvedPhrase());
            System.out.println("Letter Value: " + board.getCurrentLetterValue());
            System.out.println(player1.getName() + " points: " + player1.getPoints());
            System.out.println(player2.getName() + " points: " + player2.getPoints());

            String guess = "";
            while (guess.length() != 1) {
                System.out.print("Enter a letter: ");
                guess = input.nextLine().trim();
            }

            boolean isCorrect = board.guessLetter(guess);

            if (isCorrect) {
                if (currentPlayer % 2 == 1) {
                    player1.setPoints(player1.getPoints() + board.getCurrentLetterValue());
                } else {
                    player2.setPoints(player2.getPoints() + board.getCurrentLetterValue());
                }
                System.out.println("That is correct");
            } else {
                System.out.println("That is the wrong guess.");
                currentPlayer++;
            }

            if (board.isSolved()) {
                solved = true;
                System.out.println("\nPhrase is solved!");
                System.out.println(player1.getName() + " points: " + player1.getPoints());
                System.out.println(player2.getName() + " points: " + player2.getPoints());

                if (player1.getPoints() > player2.getPoints()) {
                    System.out.println("Winner: " + player1.getName());
                } else if (player2.getPoints() > player1.getPoints()) {
                    System.out.println("Winner: " + player2.getName());
                } else {
                    System.out.println("It's a tie");
                }
            }
        }
    }
}
