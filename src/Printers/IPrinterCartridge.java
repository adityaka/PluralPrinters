package Printers;

public interface IPrinterCartridge {
	void addInk(int inkLevel);
	int getInkLevel();
	void reduceInk(int inkLevel) throws OutOfInkException;
	String[] getColors();
	
}
