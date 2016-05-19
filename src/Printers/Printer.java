package Printers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer<CartridgeType extends IPrinterCartridge> implements IMachine {
	
	public static String DEFAULT_PRINTER_NAME = "Default Name";
	public static boolean DEFAULT_POWER_STATE = false;
	
	private Machine machine;
	private PaperTray[] trays; 
	private CartridgeType cartridge;
	//private List<Page> pageList;
	private Map<Integer,Page> pageMap;
	private Integer pageNumber = 1;
	
	
	public Printer(String printerName, boolean isOn, 
			PaperTray[] trays, CartridgeType cartridge){
		
		this.machine = new Machine(printerName,isOn);
		this.trays = trays;
		this.cartridge = cartridge;
		//this.pageList = new ArrayList<Page>();
		pageMap = new HashMap<Integer,Page>();
			
	}
	
	
	/*
	 * We cannot have the default constructors since we need the damn CartridgeType 
	 * We may want to go factory methods for printer constructions if we go generics
	 * on printers 
	 * 
	 * public Printer() throws InvalidPaperSizeException, Exception{
		InitializePrinter(Printer.DEFAULT_PRINTER_NAME, 
				Printer.DEFAULT_POWER_STATE, new PaperTray[]{ 
						new PaperTray(100,PaperTray.PAPER_SIZE_A4),
				});
	}
	public Printer(String printerName)throws InvalidPaperSizeException, Exception{
		
	}
	
	public Printer (String printerName, boolean isOn){
		
	}
	
	public Printer (String printerName,
			boolean isOn, PaperTray[] paperTrays,CartridgeType cartridge)
			throws InvalidPaperSizeException,Exception{
		
	}*/
	
	
	
	@Override
	public void turnOn(){
		System.out.println("Warming up the printer engine");
		machine.turnOn();
	}
	
	@Override
	public void turnOff(){
		System.out.println("Flushing all print jobs");
		machine.turnOff();
	}
	public String getPrinterName(){
		return machine.getMachineName();
	}
	
	public void  print(String text, int numberOfCopies, int paperSize) 
	throws PrinterOffException,OutOfPaperException, 
	OutOfInkException,IllegalArgumentException,
	PaperTrayNotFoundException{
		
		if(numberOfCopies < 0){
			throw new IllegalArgumentException("Number Of copies can't be less than 0");
		}
		if(!isOn()){
			System.out.println(isOn());
			System.out.println(machine.getMachineName());
			throw new PrinterOffException();
			
		}
	
		else if(cartridge.getInkLevel() <= 0){
			throw new OutOfInkException();
		}
		else{
			
			PaperTray t = null; 
			for (PaperTray iter : trays){
				if (iter.getPaperSize() == paperSize){
					t = iter;
				}
			}
			
			if (t == null)
			{
				throw new PaperTrayNotFoundException();
			}
			
			if ( t.getPaperCount() <=0){
				throw new OutOfPaperException();
			}
			
			//TODO: We should review later if we need a LowOnPaperException
			if(numberOfCopies > t.getPaperCount()){
				throw new OutOfPaperException();
			}
			
			for(int i = 0; i < numberOfCopies; i++){
			//	pageList.add(new Page(text));
				pageMap.put(pageNumber, new Page(text));
				pageNumber++;
				t.consumePaper(1); // < we should never have outofpaper here 
			}
			
			
		}
	}

	public void outputPages(){
		for(Integer currentPage : pageMap.keySet()){
			System.out.println(currentPage.toString() + " " + pageMap.get(currentPage).getText());
			pageNumber--;
		}
	}
	
	public void outputPage(int pageNumber) throws InvalidPageNumberException{
		if (pageMap.keySet().contains(pageNumber)){
			System.out.println(pageMap.get(pageNumber).getText());
			pageMap.remove(pageNumber);
		}else{
			throw new InvalidPageNumberException();
		}
	}
	public void printColors(){
			
		 for(String color : cartridge.getColors()){
			 System.out.println(color);
				
		}
	}
	
	@Override
	public boolean isOn() {
		
		return machine.isOn();
	}
}
