import java.util.ListIterator;

/**
 * Represents a playlist containing a list of songs with navigation support.
 */
public class Playlist {
    private String name;
    private GenericLinkedList<Song> songs;
    private int currentIndex;

    /**
     * Constructs a Playlist with the given name.
     * @param name the playlist name
     */
    public Playlist(String name) {
        this.name = name;
        this.songs = new GenericLinkedList<>();
        this.currentIndex = -1;
    }

    /** @return the name of this playlist */
    public String getName() { return name; }

    /**
     * Adds a song to the end of the playlist.
     * @param song the song to add
     * @return true if added successfully
     */
    public boolean addSong(Song song) {
        songs.addLast(song);
        if (currentIndex == -1) {
            currentIndex = 0;
        }
        return true;
    }

    /**
     * Removes the given song from the playlist.
     * @param song the song to remove
     * @return true if removed
     */
    public boolean removeSong(Song song) {
        int removeIdx = -1;
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(song)) { removeIdx = i; break; }
        }
        if (removeIdx == -1) return false;
        songs.remove(removeIdx);
        if (songs.isEmpty()) currentIndex = -1;
        else if (currentIndex >= songs.size()) currentIndex = songs.size() - 1;
        return true;
    }

    /**
     * Returns the currently selected song.
     * @return the current song, or null if the playlist is empty
     */
    public Song getCurrentSong() {
        if (currentIndex < 0 || songs.isEmpty()) return null;
        return songs.get(currentIndex);
    }

    /**
     * Advances to the next song and returns it.
     * @return the next song, or null if at the end
     */
    public Song nextSong() {
        if (songs.isEmpty()) return null;
        if (currentIndex < songs.size() - 1) currentIndex++;
        return songs.get(currentIndex);
    }

    /**
     * Moves to the previous song and returns it.
     * @return the previous song, or null if already at the beginning
     */
    public Song previousSong() {
        if (songs.isEmpty() || currentIndex <= 0) return null;
        currentIndex--;
        return songs.get(currentIndex);
    }

    /**
     * Returns the number of songs in the playlist.
     * @return song count
     */
    public int getSize() { return songs.size(); }

    /**
     * Returns true if the playlist has no songs.
     * @return true if empty
     */
    public boolean isEmpty() { return songs.isEmpty(); }

    /**
     * Returns a shallow copy of the song list.
     * @return the GenericLinkedList of songs
     */
    public GenericLinkedList<Song> getSongs() { return songs; }

}