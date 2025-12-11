import java.util.InputMismatchException;

public class CustomInputMismatchException extends Exception {

	// Default constructor
	public CustomInputMismatchException() {
		super("Invalid input! Please enter a valid value.");
	}

	// Constructor with custom message
	public CustomInputMismatchException(String message) {
		super(message);
	}

	// Constructor with message and cause
	public CustomInputMismatchException(String message, Throwable cause) {
		super(message, cause);
	}
}