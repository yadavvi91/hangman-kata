package org.yadavvi;

import java.io.InputStream;
import java.io.PrintStream;

public interface UI {
    void showNextGuessPrompt(PrintStream out);

    char getGuess(InputStream in);

    void showAlreadyGuessed(String guesses, PrintStream out);

    void showYouWon(PrintStream out);

    void showGuesses(String guesses, PrintStream out);

    void showGallows(int errorCount, PrintStream out);
}
