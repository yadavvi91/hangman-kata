package org.yadavvi;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

class ConsoleGameTest {

    @Test
    void test_correctWord() {
        String str = "m\ne\na\nt\nb\na\nl\nl\n";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        UI ui = new ConsoleUI(in, out);
        Dictionary dictionary = new FixedDictionary();
        Game game = new ConsoleGame(ui, dictionary);

        // test that when the string input is `meatball`, the output is the thing printed.
        game.play();

        System.out.println(outputStream.toString(StandardCharsets.UTF_8));
    }
}