import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A utility class that converts Morse code to English using a MorseCodeTree.
 */
public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Converts a Morse code string to English. Letters are separated by spaces,
	 * words are separated by ' / '.
	 * 
	 * @param code the Morse code string to convert
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		StringBuilder result = new StringBuilder();

		String[] words = code.split(" / ");

		for (String word : words) {
			String[] letters = word.split(" ");
			for (String letter : letters) {
				result.append(tree.fetch(letter));
			}
			result.append(" ");
		}
		return result.toString().trim();
	}

	/**
	 * Converts a file of Morse code to English.
	 * 
	 * @param file the file containing Morse code
	 * @return the English translation
	 * @throws FileNotFoundException if the file is not found
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		StringBuilder content = new StringBuilder();

		while (scanner.hasNextLine()) {
			content.append(scanner.nextLine()).append(" ");
		}

		scanner.close();

		return convertToEnglish(content.toString().trim());
	}

	/**
	 * Returns a space-separated string of the tree contents in LNR order.
	 * 
	 * @return the tree contents as a string
	 */
	public static String printTree() {
		return String.join(" ", tree.toArrayList());
	}
}