package Printers;

public class ColorCartridge implements IPrinterCartridge {
	
	private PrinterCartridge cartridge; 
	
	public ColorCartridge(){
		cartridge = new PrinterCartridge(100, new String[]{"Red","Green","Blue"});
	}
	
	
	@Override
	public void addInk(int inkLevel) {
		cartridge.addInk(inkLevel);

	}

	@Override
	public int getInkLevel() {
		
		return cartridge.getInkLevel();
	}

	@Override
	public void reduceInk(int inkLevel) throws OutOfInkException {
		
		cartridge.reduceInk(inkLevel);

	}

	@Override
	public String[] getColors() {
		
		return cartridge.getColors();
	}

}
