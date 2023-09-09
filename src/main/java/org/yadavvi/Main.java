package org.yadavvi;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static String selectWord() {
        return "meatball";
    }

    private static String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    private static String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    private static void showGallows(int errorCount, PrintStream out) {
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

    public static void main(String[] args) {
        InputStream in = System.in;
        PrintStream out = System.out;

        String word = selectWord();

        String matched = word;
        String lettersUsed = "";
        String guesses = repeat("_ ", word.length());
        int badGuessCount = 0;
        while (badGuessCount < 6 && !matched.equals(repeat("_", word.length()))) {
            showGallows(badGuessCount, out);
            showGuesses(guesses, out);
            showNextGuessPrompt(out);
            char guess = getGuess(in);

            if (lettersUsed.indexOf(guess) >= 0) {
                showAlreadyGuessed(guesses, out);
            } else {
                lettersUsed += guess;
                if (matched.indexOf(guess) >= 0) {
                    String newGuesses = "";
                    for (int i = 0; i < word.length(); ++i) {
                        if (word.charAt(i) == guess) {
                            newGuesses += guess + " ";
                        } else {
                            newGuesses += mid(guesses, i*2, 2);
                        }
                    }
                    guesses = newGuesses;
                    matched = matched.replace(guess, '_');
                } else {
                    ++badGuessCount;
                    if (badGuessCount == 6) {
                        showGallows(badGuessCount, out);
                        break;
                    }
                }
            }
            if (matched.equals(repeat("_", word.length()))) {
                showGallows(badGuessCount, out);
                showGuesses(guesses, out);
                showYouWon(out);
            }
        }
    }

    private static void showYouWon(PrintStream out) {
        out.println("YOU WON!");
    }

    private static void showAlreadyGuessed(String guesses, PrintStream out) {
        out.println("You've already guessed '" + guesses + "', try another letter.");
    }

    private static char getGuess(InputStream in) {
        return new Scanner(in).nextLine().charAt(0);
    }

    private static void showNextGuessPrompt(PrintStream out) {
        out.println("Your guess? ");
    }

    private static void showGuesses(String guesses, PrintStream out) {
        out.println("Guesses: " + guesses);
    }
}