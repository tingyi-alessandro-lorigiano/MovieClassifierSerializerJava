package a3;

public class BadNameException extends Exception {
	String message;
	public BadNameException(String message) {
		super(message + " Name ");
	}
}
