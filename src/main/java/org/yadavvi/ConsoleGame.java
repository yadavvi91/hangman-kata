package org.yadavvi;

public class ConsoleGame implements Game {

    private final UI ui;
    private final Dictionary dictionary;

    public ConsoleGame(UI ui, Dictionary dictionary) {
        this.ui = ui;
        this.dictionary = dictionary;
    }

    private String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    private String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    @Override
    public void play() {
        String word = dictionary.selectWord();
        String matched = word;
        String lettersUsed = "";
        String guesses = repeat("_ ", word.length());
        int badGuessCount = 0;
        while (areBadGuessesValid(badGuessCount) && !isMatched(word, matched)) {
            ui.showGallows(badGuessCount);
            ui.showGuesses(guesses);
            ui.showNextGuessPrompt();
            char guess = ui.getGuess();

            if (isAlreadyGuessed(lettersUsed, guess)) {
                ui.showAlreadyGuessed(guesses);
            } else if (isAlreadyGuessed(matched, guess)) {
                lettersUsed += guess;
                guesses = getNewGuesses(word, guesses, guess);
                matched = matched.replace(guess, '_');
            } else {
                lettersUsed += guess;
                badGuessCount++;
                if (badGuessCount == 6) {
                    ui.showGallows(badGuessCount);
                    break;
                }
            }
            if (isMatched(word, matched)) {
                ui.showGallows(badGuessCount);
                ui.showGuesses(guesses);
                ui.showYouWon();
            }
        }
    }

    private String getNewGuesses(String word, String guesses, char guess) {
        String newGuesses = "";
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == guess) {
                newGuesses += guess + " ";
            } else {
                newGuesses += mid(guesses, i * 2, 2);
            }
        }
        return newGuesses;
    }

    private boolean areBadGuessesValid(int badGuessCount) {
        return badGuessCount < 6;
    }

    private boolean isAlreadyGuessed(String lettersUsed, char guess) {
        return lettersUsed.indexOf(guess) >= 0;
    }

    private boolean isMatched(String word, String matched) {
        return matched.equals(repeat("_", word.length()));
    }
}
