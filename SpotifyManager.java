import java.io.*;
import java.util.ListIterator;

/**
 * Manages a collection of users; responsible for loading user data from a file
 * and finding users by credentials.
 */
public class SpotifyManager {
	private GenericLinkedList<User> users;

	/** Constructs a SpotifyManager with an empty user list. */
	public SpotifyManager() {
		users = new GenericLinkedList<>();
	}

	/**
	 * Returns all loaded users.
	 * * @return GenericLinkedList of User objects
	 */
	public GenericLinkedList<User> getUsers() {
		return users;
	}

	/**
	 * Loads users and their playlists from a formatted text file. Expected format:
	 * lines starting with "# USER", "username:", "password:", "playlist:", and
	 * "song:".
	 *
	 * @param filename path to the data file
	 * @throws IOException                if the file cannot be read
	 * @throws InvalidUserFormatException if the file format is invalid
	 */
	public void loadUsersFromFile(String filename) throws IOException, InvalidUserFormatException {
		users = new GenericLinkedList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			User currentUser = null;
			Playlist currentPlaylist = null;
			String tempUsername = null;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty()) continue;

				if (line.equals("# USER")) {
					currentUser = null;
					currentPlaylist = null;
					tempUsername = null;
				} else if (line.startsWith("username: ")) {
					tempUsername = line.substring("username: ".length()).trim();
				} else if (line.startsWith("password: ")) {
					if (tempUsername == null) {
						throw new InvalidUserFormatException("Password found before username.");
					}
					String pwd = line.substring("password: ".length()).trim();
					// Create the user once we have both username and password
					currentUser = new User(tempUsername, pwd);
					users.addLast(currentUser);
				} else if (line.startsWith("playlist: ")) {
					if (currentUser == null) {
						throw new InvalidUserFormatException("Playlist found without a valid user.");
					}
					String pname = line.substring("playlist: ".length()).trim();
					currentPlaylist = new Playlist(pname);
					currentUser.addPlaylist(currentPlaylist);
				} else if (line.startsWith("song: ")) {
					if (currentPlaylist == null) {
						throw new InvalidUserFormatException("Song found without a playlist.");
					}
					String songStr = line.substring("song: ".length()).trim();
					String[] parts = songStr.split(" - ", 2);
					if (parts.length != 2) {
						throw new InvalidUserFormatException("Invalid song format: " + songStr);
					}
					currentPlaylist.addSong(new Song(parts[0].trim(), parts[1].trim()));
				}
			}
		}
	}

	/**
	 * Finds and returns a user matching the given username and password.
	 * * @param username the username to look up
	 * @param password the password to verify
	 * @return the matching User
	 * @throws UserNotFoundException    if no user with that username exists
	 * @throws InvalidPasswordException if the username is found but the password is
	 * wrong
	 */
	public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException {
		ListIterator<User> it = users.iterator();
		while (it.hasNext()) {
			User u = it.next();
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password)) {
					return u;
				}
				throw new InvalidPasswordException("Incorrect password for user: " + username);
			}
		}
		throw new UserNotFoundException("User not found: " + username);
	}
}