package a3;

public class MissingFieldsException extends Exception{
	String message;

	public MissingFieldsException(String message) {
		super(message + "Missing Field(s)");
	}
}
