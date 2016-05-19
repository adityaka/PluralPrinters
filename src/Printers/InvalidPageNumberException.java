package Printers;

public class InvalidPageNumberException extends Exception {
	public InvalidPageNumberException(){
	
		super("Inavalid page number, Page doesn't exist");
	}
}
