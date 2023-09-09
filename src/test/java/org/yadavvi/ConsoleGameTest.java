package org.yadavvi;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleGameTest {

    private String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    private String getCorrectWordString() throws IOException {
        return readFile("src/test/resources/correct_word.txt");
    }

    private String getIncorrectWordString() throws IOException {
        return readFile("src/test/resources/incorrect_word.txt");
    }

    @Test
    void test_correctWord() throws IOException {
        String str = "m\ne\na\nt\nb\na\nl\nl\n";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        UI ui = new ConsoleUI(in, out);
        Dictionary dictionary = new FixedDictionary();
        Game game = new ConsoleGame(ui, dictionary);

        // test that when the string input is `meatball`, the output is the thing printed.
        game.play();

        String actualResponse = outputStream.toString(StandardCharsets.UTF_8);
        String expectedResponse = getCorrectWordString();

        // System.out.println(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void test_incorrectWord() throws IOException {
        String str = "m\ns\no\np\nb\nj\nl\nl\ni\nk\n";
        InputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        UI ui = new ConsoleUI(in, out);
        Dictionary dictionary = new FixedDictionary();
        Game game = new ConsoleGame(ui, dictionary);

        // test that when the string input is `meatball`, the output is the thing printed.
        game.play();

        String actualResponse = outputStream.toString(StandardCharsets.UTF_8);
        String expectedResponse = getIncorrectWordString();

        // System.out.println(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }


}