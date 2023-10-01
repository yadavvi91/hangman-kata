package org.yadavvi;

public class ConsoleGame implements Game {

    private final UI ui;
    private final Dictionary dictionary;
    private final String word;
    private final Provider provider;
    private String matched;
    private String lettersUsed;
    private String guesses;
    private int badGuessCount;

    public ConsoleGame(UI ui, Dictionary dictionary) {
        this.ui = ui;
        this.dictionary = dictionary;
        this.provider = new AlreadyGuessedProvider(new CorrectGuessProvider(new BadGuessProvider()));

        word = this.dictionary.selectWord();
        matched = word;
        lettersUsed = "";
        guesses = repeat("_ ", word.length());
        badGuessCount = 0;
    }

    private String mid(String text, int start, int length) {
        return text.substring(start, start + length);
    }

    private String repeat(String text, int count) {
        return new String(new char[count]).replace("\0", text);
    }

    @Override
    public void play() {
        while (areBadGuessesValid() && !isAMatch(word, matched)) {
            ui.showGallows(badGuessCount);
            ui.showGuesses(guesses);
            ui.showNextGuessPrompt();
            char guess = ui.getGuess();

            provider.doSomething(guess);
        }
        // is word correctly guessed
        if (isAMatch(word, matched)) {
            ui.showGallows(badGuessCount);
            ui.showGuesses(guesses);
            ui.showYouWon();
        }
        // is word incorrectly guessed
        if (!areBadGuessesValid()) {
            ui.showGallows(badGuessCount);
        }
    }

    private String getNewGuesses(char guess) {
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

    private boolean areBadGuessesValid() {
        return badGuessCount < 6;
    }

    private boolean isAlreadyGuessed(char guess) {
        return lettersUsed.indexOf(guess) >= 0;
    }

    private boolean isGuessACharInWord(char guess) {
        return matched.indexOf(guess) >= 0;
    }

    private boolean isAMatch(String word, String matched) {
        return matched.equals(repeat("_", word.length()));
    }

    interface Provider {
        void doSomething(char guess);
    }

    class AlreadyGuessedProvider implements Provider {
        Provider next;

        AlreadyGuessedProvider(Provider next) {
            this.next = next;
        }

        @Override
        public void doSomething(char guess) {
            if (isAlreadyGuessed(guess)) {
                ui.showAlreadyGuessed(guess);
            } else {
                next.doSomething(guess);
            }
        }
    }

    class CorrectGuessProvider implements Provider {
        Provider next;

        CorrectGuessProvider(Provider next) {
            this.next = next;
        }

        @Override
        public void doSomething(char guess) {
            if (isGuessACharInWord(guess)) {
                lettersUsed += guess;
                guesses = getNewGuesses(guess);
                matched = matched.replace(guess, '_');
            } else {
                next.doSomething(guess);
            }
        }
    }

    class BadGuessProvider implements Provider {
        @Override
        public void doSomething(char guess) {
            lettersUsed += guess;
            badGuessCount++;
        }
    }
}
