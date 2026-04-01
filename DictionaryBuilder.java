import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class DictionaryBuilder {

	private static class Entry {
		String word;
		int frequency;

		Entry(String word) {
			this.word = word;
			this.frequency = 1;
		}
	}

	private static class Node {
		Entry entry;
		Node next;

		Node(Entry e) {
			this.entry = e;
		}
	}

	private static class MyLinkedList {
		Node head;
		int size;

		Entry find(String word) {
			Node cur = head;
			while (cur != null) {
				if (cur.entry.word.equals(word))
					return cur.entry;
				cur = cur.next;
			}
			return null;
		}

		boolean add(String word) {
			Entry e = find(word);
			if (e != null) {
				e.frequency++;
				return false;
			}
			Node n = new Node(new Entry(word));
			n.next = head;
			head = n;
			size++;
			return true;
		}

		int remove(String word) {
			if (head == null)
				return 0;

			if (head.entry.word.equals(word)) {
				int freq = head.entry.frequency;
				head = head.next;
				size--;
				return freq;
			}

			Node cur = head;
			while (cur.next != null) {
				if (cur.next.entry.word.equals(word)) {
					int freq = cur.next.entry.frequency;
					cur.next = cur.next.next;
					size--;
					return freq;
				}
				cur = cur.next;
			}
			return 0;
		}

		int count(String word) {
			Entry e = find(word);
			return e == null ? 0 : e.frequency;
		}

		void collectWords(List<String> out) {
			Node cur = head;
			while (cur != null) {
				out.add(cur.entry.word);
				cur = cur.next;
			}
		}
	}

	private final MyLinkedList[] table;
	private int totalWords;
	private int uniqueWords;

	public DictionaryBuilder(int estimatedEntries) {
		int raw = (int) Math.ceil(estimatedEntries / 0.6);
		int size = nextPrime4k3(Math.max(raw, 7));
		table = new MyLinkedList[size];
		for (int i = 0; i < size; i++)
			table[i] = new MyLinkedList();
	}

	public DictionaryBuilder(String filename) throws FileNotFoundException {
		File file = new File(filename);
		if (!file.exists())
			throw new FileNotFoundException("File not found: " + filename);

		long fileSize = file.length();
		int raw = (int) Math.ceil(fileSize / 60.0);
		int size = nextPrime4k3(Math.max(raw, 7));

		table = new MyLinkedList[size];
		for (int i = 0; i < size; i++)
			table[i] = new MyLinkedList();

		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			String w = clean(sc.next());
			if (!w.isEmpty())
				addWord(w);
		}
		sc.close();
	}

	public void addWord(String word) {
		String w = clean(word);
		if (w.isEmpty())
			return;

		int idx = hash(w);

		if (table[idx].add(w))
			uniqueWords++;

		totalWords++;
	}

	public int getFrequency(String word) {
		String w = clean(word);
		if (w.isEmpty())
			return 0;
		return table[hash(w)].count(w);
	}

	public void removeWord(String word) throws DictionaryEntryNotFoundException {
		String w = clean(word);
		int idx = hash(w);

		int removed = table[idx].remove(w);
		if (removed == 0) {
			throw new DictionaryEntryNotFoundException("\"" + w + "\" not found in dictionary.");
		}

		totalWords -= removed;
		uniqueWords--;
	}

	public List<String> getAllWords() {
		List<String> words = new ArrayList<>();
		for (MyLinkedList bucket : table)
			bucket.collectWords(words);
		Collections.sort(words);
		return words;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public int getUniqueWords() {
		return uniqueWords;
	}

	public double getLoadFactor() {
		return (double) uniqueWords / table.length;
	}

	public int getTableSize() {
		return table.length;
	}

	private String clean(String word) {
		if (word == null)
			return "";
		return word.toLowerCase().replaceAll("[^a-z]", "");
	}

	private int hash(String word) {
		int h = 0;
		for (int i = 0; i < word.length(); i++) {
			h = (31 * h + word.charAt(i)) % table.length;
		}
		return Math.abs(h);
	}

	private int nextPrime4k3(int n) {
		int c = Math.max(n, 3);
		while (!(isPrime(c) && c % 4 == 3))
			c++;
		return c;
	}

	private boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
}