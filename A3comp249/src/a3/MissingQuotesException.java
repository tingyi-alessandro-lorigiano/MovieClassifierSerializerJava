package a3;

public class MissingQuotesException extends Exception{
	String message;

	public MissingQuotesException(String message) {
		super(message + "Missing Quotes");
	}
}
