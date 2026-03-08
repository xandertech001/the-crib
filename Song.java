/**
 * Represents a song with a title and artist name.
 */
public class Song {
    private String title;
    private String artist;

    /**
     * Constructs a Song with the given title and artist.
     * @param title  the song title
     * @param artist the artist name
     */
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /** @return the song title */
    public String getTitle() { return title; }

    /** @return the artist name */
    public String getArtist() { return artist; }

    /** @param title the new title */
    public void setTitle(String title) { this.title = title; }

    /** @param artist the new artist */
    public void setArtist(String artist) { this.artist = artist; }

    /**
     * Returns a string in "Title - Artist" format.
     * @return formatted string representation
     */
    @Override
    public String toString() {
        return title + " - " + artist;
    }

    /**
     * Two songs are equal if both title and artist match.
     * @param obj the object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song other = (Song) obj;
        return title.equals(other.title) && artist.equals(other.artist);
    }
}
