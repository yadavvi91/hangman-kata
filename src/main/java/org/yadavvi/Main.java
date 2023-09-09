package org.yadavvi;

public class Main {

    private static String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    private static String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new FixedDictionary();
        UI ui = new ConsoleUI(System.in, System.out);

        String word = dictionary.selectWord();
        String matched = word;
        String lettersUsed = "";
        String guesses = repeat("_ ", word.length());
        int badGuessCount = 0;
        while (badGuessCount < 6 && !matched.equals(repeat("_", word.length()))) {
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
                            newGuesses += mid(guesses, i*2, 2);
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
            if (matched.equals(repeat("_", word.length()))) {
                ui.showGallows(badGuessCount);
                ui.showGuesses(guesses);
                ui.showYouWon();
            }
        }
    }

}