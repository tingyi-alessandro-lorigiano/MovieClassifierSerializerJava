package a3;

public class BadScoreException extends Exception{
	String message;
	public BadScoreException(String message) {
		super(message + " Score ");
	}
}
