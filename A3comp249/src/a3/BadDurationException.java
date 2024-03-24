package a3;

public class BadDurationException extends Exception {
	String message;
	public BadDurationException(String message) {
		super(message+" Duration ");
	}
}
