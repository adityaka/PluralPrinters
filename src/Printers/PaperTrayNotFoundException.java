package Printers;

public class PaperTrayNotFoundException extends Exception {
	public PaperTrayNotFoundException(){
		super("The tray with specified Papersize is not available");
	}
}
