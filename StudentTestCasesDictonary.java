/**
 * ----------------------------------------------------------------------
 * File: DictionaryBuilderStudentTests.java
 * Author: Student
 * Course: CMSC204 - Computer Science II
 * Project: DictionaryBuilder
 * Year: 2025
 *
 * Description:
 *     Student-written JUnit 5 test suite for DictionaryBuilder.
 *     Covers edge cases, punctuation handling, case insensitivity,
 *     frequency tracking, removal, and error conditions.
 * ----------------------------------------------------------------------
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test suite for {@link DictionaryBuilder}.
 *
 * <p>Tests are organized into the following categories:
 * <ol>
 *   <li><strong>Constructor</strong> – verifies initial state of a freshly created instance.</li>
 *   <li><strong>addWord – basic</strong> – single insertions, duplicate insertions, counter updates.</li>
 *   <li><strong>addWord – case insensitivity</strong> – mixed-case inputs all map to the same entry.</li>
 *   <li><strong>addWord – punctuation stripping</strong> – trailing and embedded punctuation is removed.</li>
 *   <li><strong>getFrequency</strong> – zero returns for missing words, correct counts after repeated adds.</li>
 *   <li><strong>removeWord</strong> – successful removal, counter decrements, exception on missing word.</li>
 *   <li><strong>getAllWords</strong> – sorted output, empty-list case, no duplicates for repeated inserts.</li>
 *   <li><strong>Stats / load factor</strong> – initial zero, positive after insertions.</li>
 *   <li><strong>Stress</strong> – a set of 15 distinct words all added and retrieved correctly.</li>
 * </ol>
 * </p>
 *
 * <p>Each test method is independent: {@link #setUp()} creates a fresh
 * {@link DictionaryBuilder} with an initial capacity of 20 before every test.</p>
 */
public class StudentTestCasesDictonary {

    /**
     * The {@link DictionaryBuilder} under test.
     *
     * <p>Re-initialized before each test by {@link #setUp()} to ensure test isolation.</p>
     */
    private DictionaryBuilder db;

    /**
     * Creates a fresh {@link DictionaryBuilder} with an estimated capacity of 20
     * before each test method runs.
     *
     * <p>Using a capacity of 20 keeps the table small enough to expose collision
     * behavior while being large enough for a handful of test entries without
     * immediate rehashing.</p>
     */
    @BeforeEach
    public void setUp() {
        db = new DictionaryBuilder(20);
    }

    // -----------------------------------------------------------------------
    // Constructor tests
    // -----------------------------------------------------------------------

    /**
     * Verifies that the constructor returns a non-null instance.
     *
     * <p>A null result would indicate a construction failure unrelated to
     * any specific method under test.</p>
     */
    @Test
    public void testConstructor_notNull() {
        assertNotNull(db, "DictionaryBuilder should not be null after construction.");
    }

    /**
     * Verifies that a newly constructed dictionary contains no words.
     *
     * <p>{@link DictionaryBuilder#getAllWords()} must return an empty list
     * when no words have been added.</p>
     */
    @Test
    public void testConstructor_emptyDictionaryHasNoWords() {
        assertTrue(db.getAllWords().isEmpty(), "New dictionary should have no words.");
    }

    /**
     * Verifies that {@link DictionaryBuilder#getTotalWords()} returns 0
     * immediately after construction.
     */
    @Test
    public void testConstructor_totalWordsStartsAtZero() {
        assertEquals(0, db.getTotalWords(), "Total words should start at 0.");
    }

    /**
     * Verifies that {@link DictionaryBuilder#getUniqueWords()} returns 0
     * immediately after construction.
     */
    @Test
    public void testConstructor_uniqueWordsStartsAtZero() {
        assertEquals(0, db.getUniqueWords(), "Unique words should start at 0.");
    }

    // -----------------------------------------------------------------------
    // addWord – basic behavior
    // -----------------------------------------------------------------------

    /**
     * Verifies that the frequency of a newly added word is exactly 1.
     */
    @Test
    public void testAddWord_singleWord_frequencyIsOne() {
        db.addWord("hello");
        assertEquals(1, db.getFrequency("hello"));
    }

    /**
     * Verifies that adding the same word twice sets its frequency to 2.
     */
    @Test
    public void testAddWord_sameWordTwice_frequencyIsTwo() {
        db.addWord("hello");
        db.addWord("hello");
        assertEquals(2, db.getFrequency("hello"));
    }

    /**
     * Verifies that {@link DictionaryBuilder#getTotalWords()} counts every insertion,
     * including duplicates.
     *
     * <p>Adding "hello" twice and "world" once should yield a total of 3.</p>
     */
    @Test
    public void testAddWord_incrementsTotalWords() {
        db.addWord("hello");
        db.addWord("world");
        db.addWord("hello");
        assertEquals(3, db.getTotalWords());
    }

    /**
     * Verifies that {@link DictionaryBuilder#getUniqueWords()} only increments
     * the first time a word is inserted, not on subsequent duplicates.
     *
     * <p>After adding "hello" twice and "world" once, uniqueWords must be 2.</p>
     */
    @Test
    public void testAddWord_incrementsUniqueWordsOnlyForNewWords() {
        db.addWord("hello");
        db.addWord("hello");
        db.addWord("world");
        assertEquals(2, db.getUniqueWords());
    }

    // -----------------------------------------------------------------------
    // addWord – case insensitivity
    // -----------------------------------------------------------------------

    /**
     * Verifies that "Apple", "apple", and "APPLE" are all treated as the
     * same word, accumulating a combined frequency of 3.
     */
    @Test
    public void testAddWord_upperCaseCountsAsSameWord() {
        db.addWord("Apple");
        db.addWord("apple");
        db.addWord("APPLE");
        assertEquals(3, db.getFrequency("apple"));
    }

    /**
     * Verifies that "Java" and "JAVA" produce exactly one unique entry.
     */
    @Test
    public void testAddWord_mixedCaseOnlyOneUniqueEntry() {
        db.addWord("Java");
        db.addWord("JAVA");
        assertEquals(1, db.getUniqueWords());
    }

    // -----------------------------------------------------------------------
    // addWord – punctuation stripping
    // -----------------------------------------------------------------------

    /**
     * Verifies that a trailing period is stripped so "end." stores as "end".
     */
    @Test
    public void testAddWord_trailingPeriodStripped() {
        db.addWord("end.");
        assertEquals(1, db.getFrequency("end"));
    }

    /**
     * Verifies that a trailing comma is stripped so "first," stores as "first".
     */
    @Test
    public void testAddWord_trailingCommaStripped() {
        db.addWord("first,");
        assertEquals(1, db.getFrequency("first"));
    }

    /**
     * Verifies that a trailing exclamation mark is stripped so "wow!" stores as "wow".
     */
    @Test
    public void testAddWord_exclamationStripped() {
        db.addWord("wow!");
        assertEquals(1, db.getFrequency("wow"));
    }

    /**
     * Verifies that a trailing question mark is stripped so "really?" stores as "really".
     */
    @Test
    public void testAddWord_questionMarkStripped() {
        db.addWord("really?");
        assertEquals(1, db.getFrequency("really"));
    }

    /**
     * Verifies that punctuation stripping and case-folding work together correctly.
     *
     * <p>"Apple!", "apple.", and "APPLE," should all normalize to "apple" and
     * accumulate a frequency of 3 with a unique count of 1.</p>
     */
    @Test
    public void testAddWord_punctuationAndCaseCombined() {
        db.addWord("Apple!");
        db.addWord("apple.");
        db.addWord("APPLE,");
        assertEquals(3, db.getFrequency("apple"));
        assertEquals(1, db.getUniqueWords());
    }

    /**
     * Verifies that tokens that are entirely non-alphabetic (e.g., "!!!" or "123")
     * are silently ignored and do not affect any counters.
     */
    @Test
    public void testAddWord_purelyNonAlphabeticIsIgnored() {
        db.addWord("!!!");
        db.addWord("123");
        assertEquals(0, db.getUniqueWords());
        assertEquals(0, db.getTotalWords());
    }

    // -----------------------------------------------------------------------
    // getFrequency
    // -----------------------------------------------------------------------

    /**
     * Verifies that {@link DictionaryBuilder#getFrequency(String)} returns 0
     * for a word that was never added.
     */
    @Test
    public void testGetFrequency_wordNotPresent_returnsZero() {
        assertEquals(0, db.getFrequency("nothere"));
    }

    /**
     * Verifies that the frequency correctly reaches 10 after 10 insertions
     * of the same word.
     */
    @Test
    public void testGetFrequency_afterManyInsertions() {
        for (int i = 0; i < 10; i++) {
            db.addWord("repeat");
        }
        assertEquals(10, db.getFrequency("repeat"));
    }

    /**
     * Verifies that {@link DictionaryBuilder#getFrequency(String)} is
     * case-insensitive: "SUN" and "sun" should return the same count as the
     * original lowercase insertion.
     */
    @Test
    public void testGetFrequency_isCaseInsensitive() {
        db.addWord("Sun");
        assertEquals(1, db.getFrequency("SUN"));
        assertEquals(1, db.getFrequency("sun"));
    }

    // -----------------------------------------------------------------------
    // removeWord
    // -----------------------------------------------------------------------

    /**
     * Verifies that after removing "mango", its frequency drops to 0.
     *
     * @throws Exception if {@link DictionaryEntryNotFoundException} is thrown unexpectedly
     */
    @Test
    public void testRemoveWord_removesEntry() throws Exception {
        db.addWord("mango");
        db.removeWord("mango");
        assertEquals(0, db.getFrequency("mango"));
    }

    /**
     * Verifies that removing one of two words decrements the unique count to 1.
     *
     * @throws Exception if {@link DictionaryEntryNotFoundException} is thrown unexpectedly
     */
    @Test
    public void testRemoveWord_decreasesUniqueCount() throws Exception {
        db.addWord("mango");
        db.addWord("papaya");
        db.removeWord("mango");
        assertEquals(1, db.getUniqueWords());
    }

    /**
     * Verifies that removing a word decrements {@link DictionaryBuilder#getTotalWords()}
     * by the word's full frequency (not just 1).
     *
     * <p>Adding "mango" three times gives a total of 3; after removal the total
     * must be 0 because all occurrences are removed at once.</p>
     *
     * @throws Exception if {@link DictionaryEntryNotFoundException} is thrown unexpectedly
     */
    @Test
    public void testRemoveWord_removeFrequencySubtractedFromTotal() throws Exception {
        db.addWord("mango");
        db.addWord("mango");
        db.addWord("mango");
        // totalWords = 3
        db.removeWord("mango");
        // All 3 occurrences should be removed at once
        assertEquals(0, db.getTotalWords());
    }

    /**
     * Verifies that attempting to remove a word that was never added throws
     * {@link DictionaryEntryNotFoundException}.
     */
    @Test
    public void testRemoveWord_notPresent_throwsException() {
        assertThrows(DictionaryEntryNotFoundException.class, () -> db.removeWord("ghost"));
    }

    /**
     * Verifies that removing from an empty dictionary throws
     * {@link DictionaryEntryNotFoundException} (not a NullPointerException or
     * silent no-op).
     */
    @Test
    public void testRemoveWord_emptyDictionary_throwsException() {
        assertThrows(DictionaryEntryNotFoundException.class, () -> db.removeWord("anything"));
    }

    /**
     * Verifies that after removal, the word no longer appears in
     * {@link DictionaryBuilder#getAllWords()} while other words are unaffected.
     *
     * @throws Exception if {@link DictionaryEntryNotFoundException} is thrown unexpectedly
     */
    @Test
    public void testRemoveWord_wordGoneFromGetAllWords() throws Exception {
        db.addWord("alpha");
        db.addWord("beta");
        db.removeWord("alpha");
        List<String> words = db.getAllWords();
        assertFalse(words.contains("alpha"), "Removed word should not appear in list.");
        assertTrue(words.contains("beta"), "Non-removed word should still appear.");
    }

    // -----------------------------------------------------------------------
    // getAllWords
    // -----------------------------------------------------------------------

    /**
     * Verifies that {@link DictionaryBuilder#getAllWords()} returns words in
     * ascending alphabetical order regardless of insertion order.
     */
    @Test
    public void testGetAllWords_returnsSortedOrder() {
        db.addWord("cherry");
        db.addWord("apple");
        db.addWord("banana");
        List<String> result = db.getAllWords();
        assertEquals(List.of("apple", "banana", "cherry"), result);
    }

    /**
     * Verifies that {@link DictionaryBuilder#getAllWords()} returns an empty,
     * non-null list when the dictionary has no entries.
     */
    @Test
    public void testGetAllWords_emptyDictionary_returnsEmptyList() {
        List<String> result = db.getAllWords();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    /**
     * Verifies that a word inserted multiple times still appears exactly once
     * in the list returned by {@link DictionaryBuilder#getAllWords()}.
     */
    @Test
    public void testGetAllWords_noDuplicateEntries() {
        db.addWord("rose");
        db.addWord("rose");
        db.addWord("rose");
        List<String> words = db.getAllWords();
        assertEquals(1, words.size(), "Only one entry for a repeated word.");
        assertEquals("rose", words.get(0));
    }

    // -----------------------------------------------------------------------
    // Stats / load factor
    // -----------------------------------------------------------------------

    /**
     * Verifies that the load factor is exactly 0.0 immediately after construction,
     * when no words have been added.
     */
    @Test
    public void testGetLoadFactor_initiallyZero() {
        assertEquals(0.0, db.getLoadFactor(), 0.0001);
    }

    /**
     * Verifies that the load factor becomes positive once words are added.
     *
     * <p>Adding two distinct words must increase the load factor above 0.</p>
     */
    @Test
    public void testGetLoadFactor_increasesWithWords() {
        db.addWord("alpha");
        db.addWord("beta");
        double lf = db.getLoadFactor();
        assertTrue(lf > 0.0, "Load factor should be positive after adding words.");
    }

    // -----------------------------------------------------------------------
    // Large-scale / stress test
    // -----------------------------------------------------------------------

    /**
     * Stress test: adds 15 distinct animal names and verifies that every one
     * is retrievable with frequency 1 and that the unique word count is correct.
     *
     * <p>This test exercises multiple hash buckets and confirms that there are no
     * insertion or retrieval errors under a moderate load.</p>
     */
    @Test
    public void testAddManyWords_allRetrievable() {
        String[] words = {"ant", "bear", "cat", "dog", "elk", "fox", "gnu", "hen",
                          "ibis", "jay", "kite", "lark", "mink", "newt", "owl"};
        for (String w : words) {
            db.addWord(w);
        }
        assertEquals(words.length, db.getUniqueWords());
        for (String w : words) {
            assertEquals(1, db.getFrequency(w), "Expected frequency 1 for: " + w);
        }
    }
}