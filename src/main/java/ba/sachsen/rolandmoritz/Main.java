package ba.sachsen.rolandmoritz;
import java.util.*;

public class Main {
    private static final Random rand = new Random();

    private static final String[] validInputs = {"r", "p", "s"};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Welcome to Rock, Paper, Scissors!");
            System.out.println("To exit the game, type \"exit\".");

            while (true) {
                System.out.println("Enter your next move (r, p, s): ");
                String userMove = scanner.nextLine().toLowerCase().trim();

                if (userMove.equals("exit")) {
                    break;
                }

                try {
                    System.out.println(playRound(userMove));
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Thanks for playing!");
        }
    }

    private static String playRound(String userInput) {
        RockPaperScissors userMove = getRockPaperScissors(userInput);
        System.out.println("You chose " + userMove.toString() + ".");
        RockPaperScissors computerMove = getRockPaperScissors(validInputs[rand.nextInt(3)]);

        try {
            Thread.sleep(rand.nextInt(700, 2000));
        } catch (Exception ignored){ }

        System.out.println("The computer chose " + computerMove.toString() + ".");

        Boolean result = userMove.wonAgainst(computerMove);

        try {
            Thread.sleep(1000);
        } catch (Exception ignored){ }

        if(result == null){
            return "It's a tie. Play again!";
        }

        if(result){
            return "Congratulations! You won! Can you do it again?";
        }

        return "You lost. Try again!";
    }

    private static RockPaperScissors getRockPaperScissors(String input){
        if(input.equals(validInputs[0])){
            return RockPaperScissors.Rock;
        }
        if(input.equals(validInputs[1])){
            return RockPaperScissors.Paper;
        }
        if(input.equals(validInputs[2])){
            return RockPaperScissors.Scissors;
        }

        throw new IllegalArgumentException("Invalid move, please try again.");
    }
}
