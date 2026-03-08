/**
 * Thrown when a requested user cannot be found in the system.
 */
public class UserNotFoundException extends RuntimeException {
    /** @param message description of the error */
    public UserNotFoundException(String message) { super(message); }
}

/**
 * Thrown when the data file contains improperly formatted user entries.
 */
class InvalidUserFormatException extends Exception {
    /** @param message description of the format error */
    public InvalidUserFormatException(String message) { super(message); }
}

/**
 * Thrown when a user provides an incorrect password during login.
 */
class InvalidPasswordException extends RuntimeException {
    /** @param message description of the error */
    public InvalidPasswordException(String message) { super(message); }
}
