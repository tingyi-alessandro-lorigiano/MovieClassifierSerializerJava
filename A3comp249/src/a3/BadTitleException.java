package a3;

public class BadTitleException extends Exception{
	String message;
	public BadTitleException(String message) {
		super(message +" Title ");
	}

}
