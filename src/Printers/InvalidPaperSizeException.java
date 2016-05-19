package Printers;

public class InvalidPaperSizeException extends Exception{
	public InvalidPaperSizeException(){
		super("Invalid Paper Size for the Tray");
	}
}
