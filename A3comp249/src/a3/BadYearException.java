package a3;

public class BadYearException extends Exception {
	String message;
	public BadYearException(String message) {
		super(message + " Year ");
	}
}
