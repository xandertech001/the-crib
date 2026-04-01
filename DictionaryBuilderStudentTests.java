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

public class DictionaryBuilderStudentTests {

    private DictionaryBuilder db;

    @BeforeEach
    public void setUp() {
        db = new DictionaryBuilder(20);
    }

    // -----------------------------------------------------------------------
    // Constructor tests
    // -----------------------------------------------------------------------

    @Test
    public void testConstructor_notNull() {
        assertNotNull(db, "DictionaryBuilder should not be null after construction.");
    }

    @Test
    public void testConstructor_emptyDictionaryHasNoWords() {
        assertTrue(db.getAllWords().isEmpty(), "New dictionary should have no words.");
    }

    @Test
    public void testConstructor_totalWordsStartsAtZero() {
        assertEquals(0, db.getTotalWords(), "Total words should start at 0.");
    }

    @Test
    public void testConstructor_uniqueWordsStartsAtZero() {
        assertEquals(0, db.getUniqueWords(), "Unique words should start at 0.");
    }

    // -----------------------------------------------------------------------
    // addWord – basic behavior
    // -----------------------------------------------------------------------

    @Test
    public void testAddWord_singleWord_frequencyIsOne() {
        db.addWord("hello");
        assertEquals(1, db.getFrequency("hello"));
    }

    @Test
    public void testAddWord_sameWordTwice_frequencyIsTwo() {
        db.addWord("hello");
        db.addWord("hello");
        assertEquals(2, db.getFrequency("hello"));
    }

    @Test
    public void testAddWord_incrementsTotalWords() {
        db.addWord("hello");
        db.addWord("world");
        db.addWord("hello");
        assertEquals(3, db.getTotalWords());
    }

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

    @Test
    public void testAddWord_upperCaseCountsAsSameWord() {
        db.addWord("Apple");
        db.addWord("apple");
        db.addWord("APPLE");
        assertEquals(3, db.getFrequency("apple"));
    }

    @Test
    public void testAddWord_mixedCaseOnlyOneUniqueEntry() {
        db.addWord("Java");
        db.addWord("JAVA");
        assertEquals(1, db.getUniqueWords());
    }

    // -----------------------------------------------------------------------
    // addWord – punctuation stripping
    // -----------------------------------------------------------------------

    @Test
    public void testAddWord_trailingPeriodStripped() {
        db.addWord("end.");
        assertEquals(1, db.getFrequency("end"));
    }

    @Test
    public void testAddWord_trailingCommaStripped() {
        db.addWord("first,");
        assertEquals(1, db.getFrequency("first"));
    }

    @Test
    public void testAddWord_exclamationStripped() {
        db.addWord("wow!");
        assertEquals(1, db.getFrequency("wow"));
    }

    @Test
    public void testAddWord_questionMarkStripped() {
        db.addWord("really?");
        assertEquals(1, db.getFrequency("really"));
    }

    @Test
    public void testAddWord_punctuationAndCaseCombined() {
        db.addWord("Apple!");
        db.addWord("apple.");
        db.addWord("APPLE,");
        assertEquals(3, db.getFrequency("apple"));
        assertEquals(1, db.getUniqueWords());
    }

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

    @Test
    public void testGetFrequency_wordNotPresent_returnsZero() {
        assertEquals(0, db.getFrequency("nothere"));
    }

    @Test
    public void testGetFrequency_afterManyInsertions() {
        for (int i = 0; i < 10; i++) {
            db.addWord("repeat");
        }
        assertEquals(10, db.getFrequency("repeat"));
    }

    @Test
    public void testGetFrequency_isCaseInsensitive() {
        db.addWord("Sun");
        assertEquals(1, db.getFrequency("SUN"));
        assertEquals(1, db.getFrequency("sun"));
    }

    // -----------------------------------------------------------------------
    // removeWord
    // -----------------------------------------------------------------------

    @Test
    public void testRemoveWord_removesEntry() throws Exception {
        db.addWord("mango");
        db.removeWord("mango");
        assertEquals(0, db.getFrequency("mango"));
    }

    @Test
    public void testRemoveWord_decreasesUniqueCount() throws Exception {
        db.addWord("mango");
        db.addWord("papaya");
        db.removeWord("mango");
        assertEquals(1, db.getUniqueWords());
    }

    @Test
    public void testRemoveWord_removeFrequencySubtractedFromTotal() throws Exception {
        db.addWord("mango");
        db.addWord("mango");
        db.addWord("mango");
        // totalWords = 3
        db.removeWord("mango");
        // all 3 occurrences should be removed
        assertEquals(0, db.getTotalWords());
    }

    @Test
    public void testRemoveWord_notPresent_throwsException() {
        assertThrows(DictionaryEntryNotFoundException.class, () -> db.removeWord("ghost"));
    }

    @Test
    public void testRemoveWord_emptyDictionary_throwsException() {
        assertThrows(DictionaryEntryNotFoundException.class, () -> db.removeWord("anything"));
    }

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

    @Test
    public void testGetAllWords_returnsSortedOrder() {
        db.addWord("cherry");
        db.addWord("apple");
        db.addWord("banana");
        List<String> result = db.getAllWords();
        assertEquals(List.of("apple", "banana", "cherry"), result);
    }

    @Test
    public void testGetAllWords_emptyDictionary_returnsEmptyList() {
        List<String> result = db.getAllWords();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

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
    // stats / load factor
    // -----------------------------------------------------------------------

    @Test
    public void testGetLoadFactor_initiallyZero() {
        assertEquals(0.0, db.getLoadFactor(), 0.0001);
    }

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
