/**
 * Represents a Spotify user with a username, password, and a list of playlists.
 */
public class User {
    private String username;
    private String password;
    private GenericLinkedList<Playlist> playlists;

    /**
     * Constructs a User with the given username and password.
     * @param username the user's login name
     * @param password the user's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.playlists = new GenericLinkedList<>();
    }

    /** @return the username */
    public String getUsername() { return username; }

    /** @return the password */
    public String getPassword() { return password; }

    /**
     * Adds a playlist to this user's playlist collection.
     * @param playlist the playlist to add
     */
    public void addPlaylist(Playlist playlist) {
        playlists.addLast(playlist);
    }

    /**
     * Returns the number of playlists this user has.
     * @return playlist count
     */
    public int getPlaylistCount() { return playlists.size(); }

    /**
     * Returns the list of playlists belonging to this user.
     * @return GenericLinkedList of playlists
     */
    public GenericLinkedList<Playlist> getPlaylists() { return playlists; }
}
