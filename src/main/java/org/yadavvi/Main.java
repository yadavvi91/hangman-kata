package org.yadavvi;

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

    private static void showGallows(int errorCount) {
        switch (errorCount) {
            case 0:
                System.out.println("    +--------------+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 1:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 2:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |           +-----+");
                System.out.println("    |            |   |");
                System.out.println("    |            |   |");
                System.out.println("    |            |   |");
                System.out.println("    |           +-----+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 3:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |           +-----+");
                System.out.println("    |          / |   |");
                System.out.println("    |         /  |   |");
                System.out.println("    |        *   |   |");
                System.out.println("    |           +-----+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 4:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |           +-----+");
                System.out.println("    |          / |   | \\");
                System.out.println("    |         /  |   |  \\");
                System.out.println("    |        *   |   |   *");
                System.out.println("    |           +-----+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 5:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |           +-----+");
                System.out.println("    |          / |   | \\");
                System.out.println("    |         /  |   |  \\");
                System.out.println("    |        *   |   |   *");
                System.out.println("    |           +-----+");
                System.out.println("    |          /");
                System.out.println("    |         /");
                System.out.println("    |         |");
                System.out.println("    |         |");
                System.out.println("    |        -+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                break;

            case 6:
                System.out.println("    +--------------+");
                System.out.println("    |             (*)");
                System.out.println("    |              |");
                System.out.println("    |           +-----+");
                System.out.println("    |          / |   | \\");
                System.out.println("    |         /  |   |  \\");
                System.out.println("    |        *   |   |   *");
                System.out.println("    |           +-----+");
                System.out.println("    |          /       \\");
                System.out.println("    |         /         \\");
                System.out.println("    |         |          |");
                System.out.println("    |         |          |");
                System.out.println("    |        -+          +-");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    +----------------------------+");
                System.out.println("");
                System.out.println("              YOU'VE BEEN HUNG");
                break;
        }
    }

    public static void main(String[] args) {
        String word = selectWord();
        String matched = word;
        String lettersUsed = "";
        String guesses = repeat("_ ", word.length());
        int badGuessCount = 0;
        while (badGuessCount < 6 && !matched.equals(repeat("_", word.length()))) {
            showGallows(badGuessCount);
            System.out.println("Guesses: " + guesses);

            System.out.println("Your guess? ");
            char guess = new Scanner(System.in).nextLine().charAt(0);
            if (lettersUsed.indexOf(guess) >= 0) {
                System.out.println("You've already guessed '" + guesses + "', try another letter.");
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
                        showGallows(badGuessCount);
                        break;
                    }
                }
            }
            if (matched.equals(repeat("_", word.length()))) {
                showGallows(badGuessCount);
                System.out.println("Guesses: " + guesses);
                System.out.println("YOU WON!");
            }
        }
    }
}