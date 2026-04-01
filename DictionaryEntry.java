/**
 * Represents a single entry in the dictionary.
 * Stores the word (key) and how many times it has been inserted (frequency).
 */
public class DictionaryEntry {

    /** The word stored in this entry (always lowercase, no punctuation). */
    private final String word;

    /** The number of times this word has been added. */
    private int frequency;

    /**
     * Constructs a new DictionaryEntry with the given word and a frequency of 1.
     *
     * @param word the word to store (should already be normalized)
     */
    public DictionaryEntry(String word) {
        this.word = word;
        this.frequency = 1;
    }

    /**
     * Returns the word stored in this entry.
     *
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the frequency (occurrence count) of this word.
     *
     * @return frequency count
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Increments the frequency count by 1.
     */
    public void incrementFrequency() {
        frequency++;
    }

    /**
     * Two DictionaryEntry objects are equal if their words are equal.
     *
     * @param obj the object to compare to
     * @return true if the words match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DictionaryEntry)) return false;
        DictionaryEntry other = (DictionaryEntry) obj;
        return this.word.equals(other.word);
    }

    /**
     * Returns the hash code of the stored word.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return word.hashCode();
    }

    /**
     * Returns a string representation of this entry.
     *
     * @return word and frequency as a string
     */
    @Override
    public String toString() {
        return word + " (" + frequency + ")";
    }
}
