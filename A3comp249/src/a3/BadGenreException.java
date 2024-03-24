package a3;

public class BadGenreException extends Exception{
	String message;
	public BadGenreException(String message) {
		super(message+" Genre ");
	}
}
