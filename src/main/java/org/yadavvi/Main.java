package org.yadavvi;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {

    private static String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    private static String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    public static void main(String[] args) {
        InputStream in = System.in;
        PrintStream out = System.out;

        FixedDictionary fixedDictionary = new FixedDictionary();
        ConsoleUI consoleUi = new ConsoleUI();

        String word = fixedDictionary.selectWord();
        String matched = word;
        String lettersUsed = "";
        String guesses = repeat("_ ", word.length());
        int badGuessCount = 0;
        while (badGuessCount < 6 && !matched.equals(repeat("_", word.length()))) {
            consoleUi.showGallows(badGuessCount, out);
            consoleUi.showGuesses(guesses, out);
            consoleUi.showNextGuessPrompt(out);
            char guess = consoleUi.getGuess(in);

            if (lettersUsed.indexOf(guess) >= 0) {
                consoleUi.showAlreadyGuessed(guesses, out);
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
                        consoleUi.showGallows(badGuessCount, out);
                        break;
                    }
                }
            }
            if (matched.equals(repeat("_", word.length()))) {
                consoleUi.showGallows(badGuessCount, out);
                consoleUi.showGuesses(guesses, out);
                consoleUi.showYouWon(out);
            }
        }
    }

}