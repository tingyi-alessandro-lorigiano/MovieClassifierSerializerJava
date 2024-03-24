package a3;

public class BadRatingException extends Exception{
	String message;
	public BadRatingException(String message) {
		super(message+" Rating ");
	}
}
