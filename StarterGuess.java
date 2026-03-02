
// Code that students will get ** must be fixed by Kinsey**
import java.util.*;

public class StarterGuess {
    // syntax error
    public static int parseInt(Scanner sc, String prompt) {
        // print the prompt

        // store the result of the user

        return result;

    }

    /**
     * prob another logic error
     */
    public static int[] narrowRange(int minV, int maxV, int guess, int secret) {
        // check the guess against the secret to determine the new range using
        // conditionals
        // keep track of the minV and maxV values
        // return minV and maxV as an array of two integers
        return new int[] { minV, maxV };
    }

    /**
     * Average of guesses;
     */
    public static double averageGuess(List<Integer> guesses) {
        int sum = 0L;

        // iterate through the guesses and add each guess to sum
        for (int g : guesses)
            sum += g;

        // logic error on line 40, it doesnt do proper casting
        // return (int) sum / guesses.size();

        // return the average as a double
    }

    public static void play(Scanner sc, Random rng) {
        int minV = 1;
        int maxV = 100;

        // store the secret number to be guessed between minV and maxV inclusive

        int rounds = 8;
        int[] guesses = new int[rounds];

        // indent error and you need a loop to allow multiple attempts
        System.out.printf("Attempt %d/8 — range is [%d, %d]%n", attempt, minV, maxV);
        int guess = parseInt(sc, "Your guess: ");

        guesses[guesses.length - 1] = guess;

        if (guess == secret) {
            System.out.println("Correct! 🎉");
            break;
        } else if (guess < secret) {
            System.out.println("Higher.");
        } else {
            System.out.println("Lower.");
        }

        // update the minV and maxV based on the guess and secret number
        int[] range = narrowRange(minV, maxV, guess, secret);

        // update the minV and maxV variables to the new values from the range array

        // check if the user has run out of attempts and reveal the secret number

        // calculate and display the average guess value and print out the result

    }

    void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random(42); // deterministic default
        play(sc, rng);
    }
}