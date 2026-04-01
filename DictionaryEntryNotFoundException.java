/**
 * Exception thrown when a word is not found in the dictionary.
 * Used by DictionaryBuilder.removeWord() when the target word does not exist.
 */
public class DictionaryEntryNotFoundException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message describing which word was not found
     */
    public DictionaryEntryNotFoundException(String message) {
        super(message);
    }
}
