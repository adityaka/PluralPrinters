package Printers;

public class PrinterCartridge implements IPrinterCartridge {
	
	private int inkLevel;
	private String[] colors;
	public PrinterCartridge(int inkLevel,String[] colors){
		this.inkLevel = inkLevel; 
		this.colors = colors; 
	}
	@Override
	public void reduceInk(int inkLevel) throws OutOfInkException {
		if(inkLevel > this.inkLevel){
			throw new OutOfInkException();
		}
		else
		{
			this.inkLevel -= inkLevel;
		}
	}

	@Override
	public void addInk(int inkLevel) {
		this.inkLevel += inkLevel;
		
	}

	@Override
	public int getInkLevel() {
		return this.inkLevel;
	}

	@Override
	public String[] getColors() {
		return colors;
	}
	

}
