
// full version of the incorrect code
import java.util.*;

public class GuessFullError {
    // syntax error
    public static int parseInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            // ** logic error: should be nextInt instead of next and String data type is
            // supp to be int

            int s = sc.next();

            return s;
        }
    }

    public static int[] narrowRange(int minV, int maxV, int guess, int secret) {
        // ** invert the minV and maxV to create a logic/runtime error
        // make this as a suggestion*
        if (guess > secret) {
            minV = guess + 1;
        }
        if (guess < secret) {
            maxV = guess - 1;
        }
        // switch here for logic error with min and maxV
        // make this as a suggestion*
        if (maxV > minV) {
            minV = maxV;
        }
        // return array with new minV and maxV
        // make this as a correct suggestion*
        int[] range = { minV, maxV };
        return range;
    }

    public static double averageGuess(int[] guesses) {
        int sum = 0
        for (int g : guesses)
            sum += g;
        // logic error on line 46, it doesnt do proper casting
        return (int) sum / guesses[0];
    }

    public static void play(Scanner sc, Random rng) {
        int minV = 1;
        int maxV = 100;

        // Exception in thread "main" java.lang.IllegalArgumentException: bound must be
        // positive
        int secret = rng.nextInt(maxV - minV + 2) + minV;

        int[] guesses = new int[8];
        boolean correct = false;

        // logic error : ends at 7 and not 8 attempts
        # change this in patterns
        for (int attempt = 1; attempt < 8 && !correct; attempt++) {
            System.out.println("Attempt " + attempt + "/9 — range is [" + minV + ", " + maxV + "]");
            int guess = parseInt(sc, "Your guess: ");

            guesses[0] = attempt;
            guesses[attempt] = guess;

            if (guess == secret) {
                System.out.println("Correct! 🎉");
                correct = true;
            } else if (guess > secret) {
                System.out.println("Higher.");
                int[] range = narrowRange(minV, maxV, guess, secret);
                // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2
            // out of bounds for length 2
                minV = range[1];
                maxV = range[2];
            } else if (guess < secret) {
                System.out.println("Lower.");
                int[] range = narrowRange(minV, maxV, guess, secret);
                // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2
            // out of bounds for length 2
                minV = range[1];
                maxV = range[2];
            }
        }
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 8 out
        // of bounds for length 8
        if (guesses[guesses[1]] != secret) {
            System.out.printf("Out of attempts! Secret was %d.%n", secret);
        }

    // You made 8 guesses; average guess value: Exception in thread "main"
    // java.util.IllegalFormatConversionException: f != java.lang.Integer
    int avg = (int) averageGuess(guesses);
    System.out.printf("You made %d guesses; average guess value: %.1f%n", guesses[0], avg);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random(42);

        play(sc, rng);
    }
}
