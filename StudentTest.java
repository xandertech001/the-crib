import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Comprehensive JUnit tests for the Spotify simulation project.
 * Covers GenericLinkedList, Song, Playlist, User, SpotifyManager, and all exceptions.
 */
public class StudentTest {

    // ======================== SETUP ========================

    private GenericLinkedList<String> list;
    private Playlist playlist;
    private User user;
    private SpotifyManager manager;

    @Before
    public void setUp() {
        list = new GenericLinkedList<>();
        playlist = new Playlist("My Playlist");
        user = new User("testUser", "pass123");
        manager = new SpotifyManager();
    }

    // ======================== SONG TESTS ========================

    /** Tests that Song stores and returns title correctly. */
    @Test
    public void testSongGetTitle() {
        Song s = new Song("Bohemian Rhapsody", "Queen");
        assertEquals("Bohemian Rhapsody", s.getTitle());
    }

    /** Tests that Song stores and returns artist correctly. */
    @Test
    public void testSongGetArtist() {
        Song s = new Song("Bohemian Rhapsody", "Queen");
        assertEquals("Queen", s.getArtist());
    }

    /** Tests that Song toString produces "Title - Artist" format. */
    @Test
    public void testSongToString() {
        Song s = new Song("Bohemian Rhapsody", "Queen");
        assertEquals("Bohemian Rhapsody - Queen", s.toString());
    }

    /** Tests that two Songs with same title and artist are equal. */
    @Test
    public void testSongEquals() {
        Song a = new Song("Hello", "Adele");
        Song b = new Song("Hello", "Adele");
        assertEquals(a, b);
    }

    /** Tests that Songs with different titles are not equal. */
    @Test
    public void testSongNotEqual() {
        Song a = new Song("Hello", "Adele");
        Song b = new Song("Hello", "Lionel Richie");
        assertNotEquals(a, b);
    }

    /** Tests Song setter for title. */
    @Test
    public void testSongSetTitle() {
        Song s = new Song("Old Title", "Artist");
        s.setTitle("New Title");
        assertEquals("New Title", s.getTitle());
    }

    /** Tests Song setter for artist. */
    @Test
    public void testSongSetArtist() {
        Song s = new Song("Title", "Old Artist");
        s.setArtist("New Artist");
        assertEquals("New Artist", s.getArtist());
    }

    // ======================== GENERIC LINKED LIST TESTS ========================

    /** Tests that a new list is empty. */
    @Test
    public void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    /** Tests addFirst places element at index 0. */
    @Test
    public void testAddFirstSingleElement() {
        list.addFirst("Alpha");
        assertEquals("Alpha", list.get(0));
        assertEquals(1, list.size());
    }

    /** Tests addFirst with multiple elements preserves order. */
    @Test
    public void testAddFirstMultiple() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    /** Tests addLast places element at end. */
    @Test
    public void testAddLastSingleElement() {
        list.addLast("Omega");
        assertEquals("Omega", list.get(0));
    }

    /** Tests addLast with multiple elements preserves order. */
    @Test
    public void testAddLastMultiple() {
        list.addLast("X");
        list.addLast("Y");
        list.addLast("Z");
        assertEquals("Z", list.get(2));
        assertEquals(3, list.size());
    }

    /** Tests getFirst returns the first element. */
    @Test
    public void testGetFirst() {
        list.addLast("First");
        list.addLast("Second");
        assertEquals("First", list.getFirst());
    }

    /** Tests getLast returns the last element. */
    @Test
    public void testGetLast() {
        list.addLast("First");
        list.addLast("Last");
        assertEquals("Last", list.getLast());
    }

    /** Tests getFirst throws on empty list. */
    @Test(expected = NoSuchElementException.class)
    public void testGetFirstEmptyThrows() {
        list.getFirst();
    }

    /** Tests getLast throws on empty list. */
    @Test(expected = NoSuchElementException.class)
    public void testGetLastEmptyThrows() {
        list.getLast();
    }

    /** Tests contains returns true for existing element. */
    @Test
    public void testContainsTrue() {
        list.addLast("Mango");
        assertTrue(list.contains("Mango"));
    }

    /** Tests contains returns false for missing element. */
    @Test
    public void testContainsFalse() {
        list.addLast("Mango");
        assertFalse(list.contains("Papaya"));
    }

    /** Tests clear empties the list. */
    @Test
    public void testClear() {
        list.addLast("A");
        list.addLast("B");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    /** Tests remove by index from the middle. */
    @Test
    public void testRemoveByIndex() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.remove(1); // removes "B"
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    /** Tests remove by index throws for out-of-bounds. */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexOutOfBounds() {
        list.addLast("A");
        list.remove(5);
    }

    /** Tests remove by element returns true when found. */
    @Test
    public void testRemoveByElementFound() {
        list.addLast("Dog");
        list.addLast("Cat");
        assertTrue(list.remove("Dog"));
        assertEquals(1, list.size());
        assertFalse(list.contains("Dog"));
    }

    /** Tests remove by element returns false when not found. */
    @Test
    public void testRemoveByElementNotFound() {
        list.addLast("Dog");
        assertFalse(list.remove("Fish"));
    }

    /** Tests removeFirst removes and returns the head. */
    @Test
    public void testRemoveFirst() {
        list.addLast("First");
        list.addLast("Second");
        assertEquals("First", list.removeFirst());
        assertEquals(1, list.size());
    }

    /** Tests removeLast removes and returns the tail. */
    @Test
    public void testRemoveLast() {
        list.addLast("First");
        list.addLast("Last");
        assertEquals("Last", list.removeLast());
        assertEquals(1, list.size());
    }

    /** Tests removeFirst throws on empty list. */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstEmptyThrows() {
        list.removeFirst();
    }

    /** Tests removeLast throws on empty list. */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastEmptyThrows() {
        list.removeLast();
    }

    /** Tests toArray returns elements in list order. */
    @Test
    public void testToArray() {
        list.addLast("One");
        list.addLast("Two");
        list.addLast("Three");
        Object[] arr = list.toArray();
        assertEquals(3, arr.length);
        assertEquals("One", arr[0]);
        assertEquals("Three", arr[2]);
    }

    // ======================== ITERATOR TESTS ========================

    /** Tests iterator hasNext is false on empty list. */
    @Test
    public void testIteratorEmptyList() {
        ListIterator<String> it = list.iterator();
        assertFalse(it.hasNext());
    }

    /** Tests iterator returns elements in order. */
    @Test
    public void testIteratorForwardTraversal() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        ListIterator<String> it = list.iterator();
        assertEquals("A", it.next());
        assertEquals("B", it.next());
        assertEquals("C", it.next());
        assertFalse(it.hasNext());
    }

    /** Tests iterator backward traversal after going forward. */
    @Test
    public void testIteratorBackwardTraversal() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        ListIterator<String> it = list.iterator();
        it.next(); it.next(); it.next(); // advance to end
        assertEquals("C", it.previous());
        assertEquals("B", it.previous());
        assertEquals("A", it.previous());
        assertFalse(it.hasPrevious());
    }

    /** Tests iterator remove on the last next() result. */
    @Test
    public void testIteratorRemove() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        ListIterator<String> it = list.iterator();
        it.next(); // returns "A"
        it.next(); // returns "B"
        it.remove(); // removes "B"
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));
    }

    /** Tests iterator remove throws IllegalStateException if called twice. */
    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveCalledTwiceThrows() {
        list.addLast("A");
        ListIterator<String> it = list.iterator();
        it.next();
        it.remove();
        it.remove(); // should throw
    }

    /** Tests iterator set throws UnsupportedOperationException. */
    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorSetUnsupported() {
        list.addLast("A");
        ListIterator<String> it = list.iterator();
        it.next();
        it.set("B");
    }

    /** Tests iterator add throws UnsupportedOperationException. */
    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorAddUnsupported() {
        ListIterator<String> it = list.iterator();
        it.add("X");
    }

    // ======================== PLAYLIST TESTS ========================

    /** Tests playlist name is set correctly. */
    @Test
    public void testPlaylistGetName() {
        assertEquals("My Playlist", playlist.getName());
    }

    /** Tests new playlist is empty. */
    @Test
    public void testPlaylistIsEmptyInitially() {
        assertTrue(playlist.isEmpty());
        assertEquals(0, playlist.getSize());
    }

    /** Tests addSong increases size and sets currentSong. */
    @Test
    public void testPlaylistAddSong() {
        Song s = new Song("Shape of You", "Ed Sheeran");
        playlist.addSong(s);
        assertEquals(1, playlist.getSize());
        assertEquals(s, playlist.getCurrentSong());
    }

    /** Tests that currentSong is the first song added. */
    @Test
    public void testPlaylistCurrentSongIsFirst() {
        playlist.addSong(new Song("First", "Artist A"));
        playlist.addSong(new Song("Second", "Artist B"));
        assertEquals("First", playlist.getCurrentSong().getTitle());
    }

    /** Tests nextSong advances to the first song. */
    @Test
    public void testPlaylistNextSong() {
        playlist.addSong(new Song("Track 1", "Artist"));
        playlist.addSong(new Song("Track 2", "Artist"));
        assertEquals("Track 1", playlist.nextSong().getTitle());
        assertEquals("Track 2", playlist.nextSong().getTitle());
    }

    /** Tests nextSong returns null when at the end. */
    @Test
    public void testPlaylistNextSongAtEnd() {
        playlist.addSong(new Song("Only Song", "Artist"));
        playlist.nextSong(); // move to "Only Song"
        assertNull(playlist.nextSong()); // already at end
    }

    /** Tests previousSong returns null at the start. */
    @Test
    public void testPlaylistPreviousSongAtStart() {
        playlist.addSong(new Song("Song A", "Artist"));
        assertNull(playlist.previousSong());
    }

    /** Tests removeSong removes the correct song. */
    @Test
    public void testPlaylistRemoveSong() {
        Song s1 = new Song("Stay", "Kid LAROI");
        Song s2 = new Song("Blinding Lights", "The Weeknd");
        playlist.addSong(s1);
        playlist.addSong(s2);
        assertTrue(playlist.removeSong(s1));
        assertEquals(1, playlist.getSize());
        assertFalse(playlist.getSongs().contains(s1));
    }

    /** Tests removeSong returns false if song not in playlist. */
    @Test
    public void testPlaylistRemoveSongNotFound() {
        playlist.addSong(new Song("Present", "Artist"));
        assertFalse(playlist.removeSong(new Song("Absent", "Artist")));
    }

    /** Tests getSongs returns a non-null list. */
    @Test
    public void testPlaylistGetSongs() {
        playlist.addSong(new Song("Song", "Artist"));
        assertNotNull(playlist.getSongs());
        assertEquals(1, playlist.getSongs().size());
    }

    // ======================== USER TESTS ========================

    /** Tests User stores username correctly. */
    @Test
    public void testUserGetUsername() {
        assertEquals("testUser", user.getUsername());
    }

    /** Tests User stores password correctly. */
    @Test
    public void testUserGetPassword() {
        assertEquals("pass123", user.getPassword());
    }

    /** Tests addPlaylist and getPlaylistCount together. */
    @Test
    public void testUserAddPlaylistAndCount() {
        user.addPlaylist(new Playlist("Rock"));
        assertEquals(1, user.getPlaylistCount());
        user.addPlaylist(new Playlist("Jazz"));
        assertEquals(2, user.getPlaylistCount());
    }

    /** Tests getPlaylists returns the correct list. */
    @Test
    public void testUserGetPlaylists() {
        Playlist p = new Playlist("Country");
        user.addPlaylist(p);
        assertEquals("Country", user.getPlaylists().get(0).getName());
    }

    /** Tests new user starts with zero playlists. */
    @Test
    public void testUserInitialPlaylistCountIsZero() {
        assertEquals(0, user.getPlaylistCount());
    }

    // ======================== SPOTIFY MANAGER TESTS ========================

    /** Tests loadUsersFromFile correctly parses users, playlists, and songs. */
    @Test
    public void testManagerLoadFromFile() throws Exception {
        File temp = createTempFile(
            "# USER\nusername: john\npassword: pw\nplaylist: Favs\nsong: Imagine - John Lennon\n"
        );
        manager.loadUsersFromFile(temp.getAbsolutePath());
        assertEquals(1, manager.getUsers().size());
        User john = manager.findUser("john", "pw");
        assertEquals("john", john.getUsername());
        assertEquals(1, john.getPlaylistCount());
        assertEquals("Imagine", john.getPlaylists().get(0).getSongs().get(0).getTitle());
    }

    /** Tests loading multiple users from a file. */
    @Test
    public void testManagerLoadMultipleUsers() throws Exception {
        String data = "# USER\nusername: alice\npassword: abc\nplaylist: Chill\nsong: Yellow - Coldplay\n" +
                      "# USER\nusername: bob\npassword: xyz\nplaylist: Hype\nsong: Stronger - Kanye West\n";
        File temp = createTempFile(data);
        manager.loadUsersFromFile(temp.getAbsolutePath());
        assertEquals(2, manager.getUsers().size());
    }

    /** Tests findUser returns correct user for valid credentials. */
    @Test
    public void testFindUserValid() throws Exception {
        File temp = createTempFile("# USER\nusername: demo\npassword: DM\nplaylist: Pop\nsong: Hello - Adele\n");
        manager.loadUsersFromFile(temp.getAbsolutePath());
        User found = manager.findUser("demo", "DM");
        assertNotNull(found);
        assertEquals("demo", found.getUsername());
    }

    /** Tests findUser throws UserNotFoundException for unknown username. */
    @Test(expected = UserNotFoundException.class)
    public void testFindUserNotFound() throws Exception {
        File temp = createTempFile("# USER\nusername: demo\npassword: DM\nplaylist: Pop\nsong: Hello - Adele\n");
        manager.loadUsersFromFile(temp.getAbsolutePath());
        manager.findUser("ghost", "DM");
    }

    /** Tests findUser throws InvalidPasswordException for wrong password. */
    @Test(expected = InvalidPasswordException.class)
    public void testFindUserWrongPassword() throws Exception {
        File temp = createTempFile("# USER\nusername: demo\npassword: DM\nplaylist: Pop\nsong: Hello - Adele\n");
        manager.loadUsersFromFile(temp.getAbsolutePath());
        manager.findUser("demo", "WRONG");
    }

    /** Tests that a user with multiple playlists and songs is loaded correctly. */
    @Test
    public void testManagerMultiplePlaylistsPerUser() throws Exception {
        String data = "# USER\nusername: user1\npassword: pw1\n" +
                      "playlist: Rock\nsong: Stairway to Heaven - Led Zeppelin\nsong: Back in Black - AC/DC\n" +
                      "playlist: Pop\nsong: Shake It Off - Taylor Swift\n";
        File temp = createTempFile(data);
        manager.loadUsersFromFile(temp.getAbsolutePath());
        User u = manager.findUser("user1", "pw1");
        assertEquals(2, u.getPlaylistCount());
        assertEquals(2, u.getPlaylists().get(0).getSize());
        assertEquals(1, u.getPlaylists().get(1).getSize());
    }

    // ======================== HELPER ========================

    /** Creates a temporary file with the given content for testing file I/O. */
    private File createTempFile(String content) throws IOException {
        File f = File.createTempFile("spotifyTest", ".txt");
        f.deleteOnExit();
        try (BufferedWriter w = new BufferedWriter(new FileWriter(f))) {
            w.write(content);
        }
        return f;
    }
}
