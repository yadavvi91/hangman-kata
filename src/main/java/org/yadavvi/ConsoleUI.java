package org.yadavvi;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private final InputStream in;
    private final PrintStream out;
    private Scanner scanner;

    public ConsoleUI(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
    }

    @Override
    public void showNextGuessPrompt() {
        out.println("Your guess? ");
    }

    @Override
    public char getGuess() {
        return scanner.nextLine().charAt(0);
    }

    @Override
    public void showAlreadyGuessed(String guesses) {
        out.println("You've already guessed '" + guesses + "', try another letter.");
    }

    @Override
    public void showYouWon() {
        out.println("YOU WON!");
    }

    @Override
    public void showGuesses(String guesses) {
        out.println("Guesses: " + guesses);
    }

    @Override
    public void showGallows(int errorCount) {
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
