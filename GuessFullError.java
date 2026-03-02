
// full version of the incorrect code
import java.util.*;

public class Guess {
    // syntax error
    public static int parseInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            // ** logic error: should be nextInt instead of next
            int s = sc.next();

            try {
                return Integer.parseString(s);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an integer. Try again.");
            }
        }
    }

    public static int[] narrowRange(int minV, int maxV, int guess, int secret) {
        // ** invert the minV and maxV to create a logic/runtime error
        // make this as a suggestion*
        if (guess > secret) {
            minV = Math.max(minV, guess + 1);
        } else if (guess < secret) {
            maxV = Math.min(maxV, guess - 1);
        }
        // switch here for logic error with min and maxV
        // make this as a suggestion*
        if (maxV > minV) {
            minV = maxV;
        }
        // return array with new minV and maxV
        // make this as a correct suggestion*
        return new int[] { minV, maxV };
    }

    public static double averageGuess(int[] guesses) {
        // syntax error: Type mismatch: cannot convert from long to int
        int sum = 0L;
        for (int g : guesses)
            sum += g;
        // logic error on line 49, it doesnt do proper casting
        return (int) sum / guesses.length;
    }

    public static void play(Scanner sc, Random rng) {
        int minV = 1;
        int maxV = 100;

        // Exception in thread "main" java.lang.IllegalArgumentException: bound must be
        // positive
        int secret = rng.nextInt(maxV - minV + 1) + minV;

        int rounds = 8;
        int[] guesses = new int[rounds];

        // logic error : ends at 7 and not 8 attempts
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

            // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2
            // out of bounds for length 2
            minV = range[1];
            maxV = range[2];
        }

        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 8 out
        // of bounds for length 8
        if (guesses[guesses.length - 1] != secret) {
            System.out.printf("Out of attempts! Secret was %d.%n", secret);
        }

        // You made 8 guesses; average guess value: Exception in thread "main"
        // java.util.IllegalFormatConversionException: f != java.lang.Integer
        double avg = averageGuess(guesses);
        System.out.printf("You made %d guesses; average guess value: %.1f%n", guesses.length, avg);
    }

    void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random(42); // deterministic default
        play(sc, rng);
    }
}
