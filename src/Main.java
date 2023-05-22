import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int random = ThreadLocalRandom.current().nextInt(1,1000);
        Scanner scan = new Scanner(System.in);
        int chances = 10;
        int guess;
        boolean endGame = false;

        while (true) {
            while (endGame) {
                System.out.println("play again?");
                System.out.println("please enter 'y' or 'n'");
                String replay = scan.nextLine();
                scan.nextLine();
                if (Objects.equals(replay, "y")) {
                    endGame = false;
                    random = ThreadLocalRandom.current().nextInt(1,1000);
                    break;
                } else if (Objects.equals(replay, "n")) {
                    return;
                }
            }

            System.out.println("you have " + chances + " chances");
            System.out.println("devtest: " + random); //for testing purposes, to be removed
            System.out.println("guess a number between 0 and 1000 (exclusive)");
            while (!scan.hasNextInt()) {
                System.out.println("that is not a number");
                scan.next();
            }
            guess = scan.nextInt();

            if (guess >= 1000 || guess <= 0) {
                System.out.println("guess is out of range");
                continue;
            } else if (guess > random) {
                System.out.println("your guess is too high, try a lower number");
                chances -= 1;
                continue;
            } else if (guess < random) {
                System.out.println("your guess is too low, try a greater number");
                chances -= 1;
                continue;
            } else {
                System.out.println("congratulations, your guess is correct");
                System.out.println("the number was " + random);
                endGame = true;
            }
            if (chances <= 0) {
                System.out.println("the number was " + random);
                endGame = true;
            }
        }
    }
}