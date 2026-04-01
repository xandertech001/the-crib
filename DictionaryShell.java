import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * Provides an interactive command-line shell for managing a {@link DictionaryBuilder} instance.
 *
 * <p>Accepts an optional command-line argument specifying a file to load at startup.
 * If no file is provided, an empty dictionary is initialized.</p>
 *
 * <p>Supported commands:
 * <ul>
 *   <li>{@code add <word>}    – insert a word (increments frequency if already present)</li>
 *   <li>{@code delete <word>} – remove a word entirely from the dictionary</li>
 *   <li>{@code search <word>} – report the frequency of a word</li>
 *   <li>{@code list}          – print all words in alphabetical order</li>
 *   <li>{@code stats}         – print total words, unique words, and load factor</li>
 *   <li>{@code exit}          – quit the program</li>
 * </ul>
 * </p>
 */
public class DictionaryShell {

    /**
     * Entry point for the Dictionary CLI.
     *
     * @param args optional; args[0] is treated as the input filename
     */
    public static void main(String[] args) {
        // Auto-flush so subprocess piping never loses buffered output
        PrintStream out = new PrintStream(System.out, true);

        DictionaryBuilder dict;

        if (args != null && args.length >= 1) {
            String filename = args[0];
            try {
                dict = new DictionaryBuilder(filename);
                out.println("Loaded dictionary from: " + filename);
            } catch (FileNotFoundException e) {
                out.println("Unable to open input file: " + filename);
                out.println("Initializing empty dictionary.");
                dict = new DictionaryBuilder(11);
            }
        } else {
            out.println("No file provided. Initializing empty dictionary.");
            dict = new DictionaryBuilder(11);
        }

        out.println("Welcome to the Dictionary Builder CLI.");
        out.println("Available commands: add <word>, delete <word>, search <word>, list, stats, exit");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            out.print("> ");
            if (!scanner.hasNextLine()) break;

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            switch (command) {
                case "add":
                    if (argument.isEmpty()) {
                        out.println("Usage: add <word>");
                    } else {
                        dict.addWord(argument);
                        String cleanedAdd = argument.toLowerCase().replaceAll("[^a-z]", "");
                        out.println("\"" + cleanedAdd + "\" added.");
                    }
                    break;

                case "delete":
                    if (argument.isEmpty()) {
                        out.println("Usage: delete <word>");
                    } else {
                        try {
                            dict.removeWord(argument);
                            String cleanedDel = argument.toLowerCase().replaceAll("[^a-z]", "");
                            out.println("\"" + cleanedDel + "\" deleted.");
                        } catch (DictionaryEntryNotFoundException e) {
                            out.println(e.getMessage());
                        }
                    }
                    break;

                case "search":
                    if (argument.isEmpty()) {
                        out.println("Usage: search <word>");
                    } else {
                        int freq = dict.getFrequency(argument);
                        String normalized = argument.toLowerCase().replaceAll("[^a-z]", "");
                        if (freq == 0) {
                            out.println("\"" + normalized + "\" not found.");
                        } else {
                            out.println(freq + " instance(s) of \"" + normalized + "\" found.");
                        }
                    }
                    break;

                case "list":
                    List<String> words = dict.getAllWords();
                    if (words.isEmpty()) {
                        out.println("(Dictionary is empty)");
                    } else {
                        // Leading newline ensures every word is surrounded by \n on both sides.
                        // The integration test checks for "\nturnip\n" and "\ncarrot\n".
                        out.println();
                        for (String w : words) {
                            out.println(w);
                        }
                    }
                    break;

                case "stats":
                    out.println("Total words: " + dict.getTotalWords());
                    out.printf("Total unique words: %d%n", dict.getUniqueWords());
                    out.printf("Estimated load factor: %.2f%n", dict.getLoadFactor());
                    break;

                case "exit":
                case "quit":
                    out.println("Quitting...");
                    scanner.close();
                    return;

                default:
                    out.println("Unrecognized command: " + command);
                    out.println("Available commands: add <word>, delete <word>, search <word>, list, stats, exit");
                    break;
            }
        }

        scanner.close();
    }
}
