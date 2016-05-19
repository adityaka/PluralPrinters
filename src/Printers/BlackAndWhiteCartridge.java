package Printers;

public class BlackAndWhiteCartridge implements IPrinterCartridge {

	private PrinterCartridge cartridge; 
	
	 public BlackAndWhiteCartridge() {
		cartridge = new PrinterCartridge(100,new String[]{"Black","White"});
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
