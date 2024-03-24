package a3;

public class ExcessFieldsException extends Exception{
	String message;
	public ExcessFieldsException(String message) {
		super(message + "Excess Field(s)");
	}
}
