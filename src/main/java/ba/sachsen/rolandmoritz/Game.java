package ba.sachsen.rolandmoritz;

import ba.sachsen.rolandmoritz.models.Score;
import ba.sachsen.rolandmoritz.models.enums.GameResult;
import ba.sachsen.rolandmoritz.models.enums.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String[] validInputs = {"r", "p", "s"};

    private final Random rand = new Random();

    private final Score score = new Score();

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning;
            do {
                isRunning = gameLoop(scanner);
            } while (isRunning);
        }
    }

    private boolean gameLoop(Scanner scanner) {
        System.out.println("Enter your next move (r, p, s): ");
        String userInput = scanner.nextLine().toLowerCase().trim();

        if (userInput.equals("exit")) {
            return false;
        }

        GameResult result = playRound(userInput);

        if (result == GameResult.Invalid) {
            return true;
        }

        if (result == GameResult.Win) {
            System.out.println("Congratulations! You won! Can you do it again?");
        } else if (result == GameResult.Loss) {
            System.out.println("You lost. Try again!");
        } else {
            System.out.println("It's a tie. Play again!");
        }

        sleep(1000);
        adjustScore(result);
        System.out.println("Score: " + score.wins + "/" + score.ties + "/" + score.losses);
        return true;
    }

    private GameResult playRound(String userInput) {
        RockPaperScissors userMove;
        try {
            userMove = getRockPaperScissors(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return GameResult.Invalid;
        }
        System.out.println("You chose " + userMove.toString() + ".");

        RockPaperScissors computerMove = getRockPaperScissors(validInputs[rand.nextInt(3)]);

        sleep(rand.nextInt(700, 2000));
        System.out.println("The computer chose " + computerMove.toString() + ".");

        sleep(1000);

        return userMove.getResultAgainst(computerMove);
    }

    private static RockPaperScissors getRockPaperScissors(String input) {
        if (input.equals(validInputs[0])) {
            return RockPaperScissors.Rock;
        }
        if (input.equals(validInputs[1])) {
            return RockPaperScissors.Paper;
        }
        if (input.equals(validInputs[2])) {
            return RockPaperScissors.Scissors;
        }

        throw new IllegalArgumentException("Invalid move, please try again.");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception ignored) {
        }
    }

    private void adjustScore(GameResult result) {
        if (result == GameResult.Win) {
            score.wins += 1;
            return;
        }

        if (result == GameResult.Tie) {
            score.ties += 1;
            return;
        }

        score.losses += 1;
    }
}
