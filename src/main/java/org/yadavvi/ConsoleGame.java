package org.yadavvi;

public class ConsoleGame implements Game {

    private String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    private String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    @Override
    public void play(Dictionary dictionary, UI ui) {
        String word = dictionary.selectWord();
        String matched = word;
        String lettersUsed = "";
        String guesses = new ConsoleGame().repeat("_ ", word.length());
        int badGuessCount = 0;
        while (badGuessCount < 6 && !matched.equals(new ConsoleGame().repeat("_", word.length()))) {
            ui.showGallows(badGuessCount);
            ui.showGuesses(guesses);
            ui.showNextGuessPrompt();
            char guess = ui.getGuess();

            if (lettersUsed.indexOf(guess) >= 0) {
                ui.showAlreadyGuessed(guesses);
            } else {
                lettersUsed += guess;
                if (matched.indexOf(guess) >= 0) {
                    String newGuesses = "";
                    for (int i = 0; i < word.length(); ++i) {
                        if (word.charAt(i) == guess) {
                            newGuesses += guess + " ";
                        } else {
                            newGuesses += new ConsoleGame().mid(guesses, i * 2, 2);
                        }
                    }
                    guesses = newGuesses;
                    matched = matched.replace(guess, '_');
                } else {
                    ++badGuessCount;
                    if (badGuessCount == 6) {
                        ui.showGallows(badGuessCount);
                        break;
                    }
                }
            }
            if (matched.equals(new ConsoleGame().repeat("_", word.length()))) {
                ui.showGallows(badGuessCount);
                ui.showGuesses(guesses);
                ui.showYouWon();
            }
        }
    }
}