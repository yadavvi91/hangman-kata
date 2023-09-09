package org.yadavvi;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUI {

    void showNextGuessPrompt(PrintStream out) {
        out.println("Your guess? ");
    }

    char getGuess(InputStream in) {
        return new Scanner(in).nextLine().charAt(0);
    }

    void showAlreadyGuessed(String guesses, PrintStream out) {
        out.println("You've already guessed '" + guesses + "', try another letter.");
    }

    void showYouWon(PrintStream out) {
        out.println("YOU WON!");
    }

    void showGuesses(String guesses, PrintStream out) {
        out.println("Guesses: " + guesses);
    }

    public void showGallows(int errorCount, PrintStream out) {
        switch (errorCount) {
            case 0:
                out.println("    +--------------+");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 1:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 2:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |           +-----+");
                out.println("    |            |   |");
                out.println("    |            |   |");
                out.println("    |            |   |");
                out.println("    |           +-----+");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 3:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |           +-----+");
                out.println("    |          / |   |");
                out.println("    |         /  |   |");
                out.println("    |        *   |   |");
                out.println("    |           +-----+");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 4:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |           +-----+");
                out.println("    |          / |   | \\");
                out.println("    |         /  |   |  \\");
                out.println("    |        *   |   |   *");
                out.println("    |           +-----+");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 5:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |           +-----+");
                out.println("    |          / |   | \\");
                out.println("    |         /  |   |  \\");
                out.println("    |        *   |   |   *");
                out.println("    |           +-----+");
                out.println("    |          /");
                out.println("    |         /");
                out.println("    |         |");
                out.println("    |         |");
                out.println("    |        -+");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                break;

            case 6:
                out.println("    +--------------+");
                out.println("    |             (*)");
                out.println("    |              |");
                out.println("    |           +-----+");
                out.println("    |          / |   | \\");
                out.println("    |         /  |   |  \\");
                out.println("    |        *   |   |   *");
                out.println("    |           +-----+");
                out.println("    |          /       \\");
                out.println("    |         /         \\");
                out.println("    |         |          |");
                out.println("    |         |          |");
                out.println("    |        -+          +-");
                out.println("    |");
                out.println("    |");
                out.println("    +----------------------------+");
                out.println("");
                out.println("              YOU'VE BEEN HUNG");
                break;
        }
    }
}
