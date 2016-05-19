package Printers;

public class OutOfInkException extends Exception{
	public OutOfInkException(){
		super("Cartridge out of ink");
	}

}
