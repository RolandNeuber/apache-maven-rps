package ba.sachsen.rolandmoritz;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("To exit the game, type \"exit\".");

        new Game().run();

        System.out.println("Thanks for playing!");
    }
}
