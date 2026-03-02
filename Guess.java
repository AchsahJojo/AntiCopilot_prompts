import java.util.*;

public class Guess {
    // syntax error
    public static int parseInt(Scanner sc, String prompt) {
        // print the prompt
        // try to see if we can turn off the complier warnings and turn off the warnings
        // too
        System.out.println(prompt);
        // store the result of the user

        // ** logic error: should be nextInt instead of next
        int s = sc.nextInt();
        return s;

    }

    /**
     * prob another logic error
     */
    public static int[] narrowRange(int minV, int maxV, int guess, int secret) {
        // ** invert the minV and maxV to create a logic/runtime error

        if (guess < secret) {
            minV = Math.max(minV, guess + 1);
        } else if (guess > secret) {
            maxV = Math.min(maxV, guess - 1);
        }
        // switch here for logic error with min and maxV
        if (minV > maxV) {
            minV = maxV;
        }
        return new int[] { minV, maxV };
    }

    /**
     * Average of guesses;
     */
    public static double averageGuess(List<Integer> guesses) {
        // long sum = 0L;
        int sum = 0;
        for (int g : guesses)
            sum += g;
        // logic error on line 39, it doesnt do proper casting
        // return (int) sum / guesses.size();
        return sum / (double) guesses.size();
    }

    public static void play(Scanner sc, Random rng) {
        int minV = 1;
        int maxV = 100;
        // Exception in thread "main" java.lang.IllegalArgumentException: bound must be
        // positive
        // int secret = rng.nextInt(minV - maxV + 2) + minV; // inclusive
        int secret = rng.nextInt(maxV - minV + 1) + minV; // inclusive

        // *** need to use normal arrays and keep track of upper bound and lower bound
        List<Integer> guesses = new ArrayList<>();

        // logic error : ends at 7 and not 8 attempts
        for (int attempt = 1; attempt <= 8; attempt++) {
            // for (int attempt = 1; attempt < 8; attempt++) {
            System.out.printf("Attempt %d/8 — range is [%d, %d]%n", attempt, minV, maxV);
            int guess = parseInt(sc, "Your guess: ");
            guesses.add(guess);

            if (guess == secret) {
                System.out.println("Correct! 🎉");
                break;
            } else if (guess < secret) {
                System.out.println("Higher.");
            } else {
                System.out.println("Lower.");
            }

            // logic error wrong way to determon correct/high/low
            // if (guess >= secret) {
            // System.out.println("Higher.");
            // } else if (guess < secret) {
            // System.out.println("Lower");
            // } else {
            // System.out.println("correct!");
            // }

            int[] range = narrowRange(minV, maxV, guess, secret);

            // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2
            // out of bounds for length 2
            // minV = range[0];
            minV = range[0];
            // maxV = range[2];
            maxV = range[1];
        }

        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 8 out
        // of bounds for length 8
        // if (guesses.get(guesses.size()) != secret) {
        if (guesses.isEmpty() || guesses.get(guesses.size() - 1) != secret) {
            System.out.printf("Out of attempts! Secret was %d.%n", secret);
        }
        // You made 8 guesses; average guess value: Exception in thread "main"
        // java.util.IllegalFormatConversionException: f != java.lang.Integer
        // int avg = (int) averageGuess(guesses);
        double avg = averageGuess(guesses);
        System.out.printf("You made %d guesses; average guess value: %.1f%n", guesses.size(), avg);
    }

    void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random(42); // deterministic default
        play(sc, rng);
    }
}

// finish the plugin so that it incooperates the changes made in
// StarterGuess.java
// get a good draft for all the issues , arrayList to just arrays and more
// errors
// on each line