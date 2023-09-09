package org.yadavvi;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionary = new FixedDictionary();
        UI ui = new ConsoleUI(System.in, System.out);

        ConsoleGame game = new ConsoleGame();

        game.play(dictionary, ui);
    }

}