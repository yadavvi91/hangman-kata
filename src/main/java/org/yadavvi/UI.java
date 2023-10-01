package org.yadavvi;

public interface UI {
    void showNextGuessPrompt();

    char getGuess();

    void showAlreadyGuessed(char guess);

    void showYouWon();

    void showGuesses(String guesses);

    void showGallows(int errorCount);
}
