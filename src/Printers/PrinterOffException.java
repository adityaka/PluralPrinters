package Printers;

public class PrinterOffException extends Exception{
	
	public PrinterOffException(){
		super("Printer is Off");
	}

}
