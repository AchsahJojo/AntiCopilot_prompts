
// fully correct version of number guess
import java.util.*;

public class Guess {
    // syntax error
    public static int parseInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            // expected error 1 syntax -> refer to GuessError to see the error
            String s = sc.nextLine();

            try {
                return Integer.parseString(s);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an integer. Try again.");
            }
        }
    }

    public static int[] narrowRange(int minV, int maxV, int guess, int secret) {
        // error # 2 -> refer to GuessError to see the error
        if (guess < secret) {
            minV = Math.max(minV, guess + 1);
        } else if (guess > secret) {
            maxV = Math.min(maxV, guess - 1);
        }
        // error # 3 -> refer to GuessError to see the error
        if (minV > maxV) {
            minV = maxV;
        }
        return new int[] { minV, maxV };
    }

    public static double averageGuess(int[] guesses) {
        int sum = 0;
        for (int g : guesses)
            sum += g;
        // error #4 -> refer to GuessError to see the error
        return sum / (double) guesses.length;
    }

    public static void play(Scanner sc, Random rng) {
        int minV = 1, maxV = 100;
        // error #5 -> refer to GuessError to see the error
        int secret = rng.nextInt(maxV - minV + 1) + minV;

        int rounds = 8;
        int[] guesses = new int[rounds];

        // error #6 -> refer to GuessError to see the error
        for (int attempt = 1; attempt <= 8; attempt++) {
            System.out.printf("Attempt %d/8 — range is [%d, %d]%n", attempt, minV, maxV);
            int guess = parseInt(sc, "Your guess: ");

            guesses[attempt - 1] = guess;

            if (guess == secret) {
                System.out.println("Correct! 🎉");
                break;
            } else if (guess < secret) {
                System.out.println("Higher.");
            } else {
                System.out.println("Lower.");
            }
            int[] range = narrowRange(minV, maxV, guess, secret);

            // error #7 -> refer to GuessError to see the error
            minV = range[0];
            maxV = range[1];
        }

        // error #8 -> refer to GuessError to see the error
        if (guesses[guesses.length - 1] != secret) {
            System.out.printf("Out of attempts! Secret was %d.%n", secret);
        }

        // error #9 -> refer to GuessError to see the error
        double avg = averageGuess(guesses);
        System.out.printf("You made %d guesses; average guess value: %.1f%n", guesses.length, avg);
    }

    void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random(42); // deterministic default
        play(sc, rng);
    }
}
