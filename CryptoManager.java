/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches.
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption is a
 * method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph)
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher.
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text based on the
	 * letters of a keyword. It works as below: Choose a keyword (e.g., KEY). Repeat
	 * the keyword to match the length of the plaintext. Each letter in the
	 * plaintext is shifted by the position of the corresponding letter in the
	 * keyword (A = 0, B = 1, ..., Z = 25).
	 */

	public static String vigenereEncryption(String plainText, String key) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder encrypted = new StringBuilder();
		for (int i = 0; i < plainText.length(); i++) {
			char plainChar = plainText.charAt(i);
			char keyChar = key.charAt(i % key.length());

			int shifted = ((plainChar - LOWER_RANGE) + (keyChar - LOWER_RANGE)) % RANGE + LOWER_RANGE;
			encrypted.append((char) shifted);
		}
		return encrypted.toString();
	}

	// Vigenere Decryption
	public static String vigenereDecryption(String encryptedText, String key) {
		if (!isStringInBounds(encryptedText)) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder decrypted = new StringBuilder();
		for (int i = 0; i < encryptedText.length(); i++) {
			char encChar = encryptedText.charAt(i);
			char keyChar = key.charAt(i % key.length());

			int shifted = ((encChar - LOWER_RANGE) - (keyChar - LOWER_RANGE) + RANGE) % RANGE + LOWER_RANGE;
			decrypted.append((char) shifted);
		}
		return decrypted.toString();
	}

	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one. It works
	 * as follows: A matrix (8X8 in our case) is built using a keyword Plaintext is
	 * split into letter pairs (e.g., ME ET YO UR). Encryption rules depend on the
	 * positions of the letters in the matrix: Same row: replace each letter with
	 * the one to its right. Same column: replace each with the one below.
	 * Rectangle: replace each letter with the one in its own row but in the column
	 * of the other letter in the pair.
	 */

	public static String playfairEncryption(String plainText, String key) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}

		char[][] matrix = generatePlayfairMatrix(key);
		StringBuilder result = new StringBuilder();

		String prepared = preparePlayfairText(plainText);
		for (int i = 0; i < prepared.length(); i += 2) {
			char a = prepared.charAt(i);
			char b = prepared.charAt(i + 1);
			int[] posA = findPosition(matrix, a);
			int[] posB = findPosition(matrix, b);

			if (posA[0] == posB[0]) { // same row
				result.append(matrix[posA[0]][(posA[1] + 1) % 8]);
				result.append(matrix[posB[0]][(posB[1] + 1) % 8]);
			} else if (posA[1] == posB[1]) { // same column
				result.append(matrix[(posA[0] + 1) % 8][posA[1]]);
				result.append(matrix[(posB[0] + 1) % 8][posB[1]]);
			} else { // rectangle rule
				result.append(matrix[posA[0]][posB[1]]);
				result.append(matrix[posB[0]][posA[1]]);
			}
		}

		return result.toString();
	}

	private static char[][] generatePlayfairMatrix(String key) {
		StringBuilder used = new StringBuilder();
		for (char c : key.toCharArray()) {
			if (used.indexOf(String.valueOf(c)) == -1 && ALPHABET64.indexOf(c) != -1)
				used.append(c);
		}
		for (char c : ALPHABET64.toCharArray()) {
			if (used.indexOf(String.valueOf(c)) == -1)
				used.append(c);
		}

		char[][] matrix = new char[8][8];
		int index = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				matrix[i][j] = used.charAt(index++);
			}
		}
		return matrix;
	}

	private static int[] findPosition(char[][] matrix, char c) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (matrix[i][j] == c)
					return new int[] { i, j };
			}
		}
		return null;
	}

	private static String preparePlayfairText(String text) {
		StringBuilder sb = new StringBuilder(text);
		if (sb.length() % 2 != 0)
			sb.append('X');
		return sb.toString();
	}

	// Playfair decryption
	public static String playfairDecryption(String encryptedText, String key) {
		if (!isStringInBounds(encryptedText) || encryptedText.length() % 2 != 0) {
			return "Invalid encrypted text length."; // Should be an even length
		}

		char[][] matrix = generatePlayfairMatrix(key);
		StringBuilder result = new StringBuilder();

		// The encrypted text is already prepared in pairs for decryption
		for (int i = 0; i < encryptedText.length(); i += 2) {
			char a = encryptedText.charAt(i);
			char b = encryptedText.charAt(i + 1);
			int[] posA = findPosition(matrix, a);
			int[] posB = findPosition(matrix, b);

			if (posA == null || posB == null) {
				// Handle error: characters not found in matrix
				return "Error: Character not found in matrix.";
			}

			if (posA[0] == posB[0]) {
				result.append(matrix[posA[0]][(posA[1] - 1 + 8) % 8]);
				result.append(matrix[posB[0]][(posB[1] - 1 + 8) % 8]);
			} else if (posA[1] == posB[1]) {
				result.append(matrix[(posA[0] - 1 + 8) % 8][posA[1]]);
				result.append(matrix[(posB[0] - 1 + 8) % 8][posB[1]]);
			} else {
				result.append(matrix[posA[0]][posB[1]]);
				result.append(matrix[posB[0]][posA[1]]);
			}
		}

		return result.toString();
	}

	/**
	 * Caesar Cipher is a simple substitution cipher that replaces each letter in a
	 * message with a letter some fixed number of positions down the alphabet. For
	 * example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and
	 * so on.
	 */

	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder encrypted = new StringBuilder();
		for (int i = 0; i < plainText.length(); i++) {
			int shifted = ((plainText.charAt(i) - LOWER_RANGE + key) % RANGE) + LOWER_RANGE;
			encrypted.append((char) shifted);
		}
		return encrypted.toString();
	}

	// Caesar Decryption
	public static String caesarDecryption(String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) {
			return "The selected string is not in bounds, Try again.";
		}

		StringBuilder decrypted = new StringBuilder();
		for (int i = 0; i < encryptedText.length(); i++) {
			int shifted = ((encryptedText.charAt(i) - LOWER_RANGE - key + RANGE) % RANGE) + LOWER_RANGE;
			decrypted.append((char) shifted);
		}
		return decrypted.toString();
	}

}
