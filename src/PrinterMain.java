

import Printers.IMachine;
import Printers.PaperTray;
import Printers.Printer;
import Printers.ColorCartridge;
import Printers.BlackAndWhiteCartridge;


public class PrinterMain {
	public static void main(String[] args){
		
		IMachine myPrinter=null;
		IMachine yourPrinter = null;
		try{
		 myPrinter = new Printer<ColorCartridge>("MyPrinter",
					true,new PaperTray[] {new PaperTray(100,PaperTray.PAPER_SIZE_A4)},
					new ColorCartridge());
			((Printer)myPrinter).print("Hello World",10,PaperTray.PAPER_SIZE_A4);
			((Printer)myPrinter).outputPages();
			
		yourPrinter = new Printer<BlackAndWhiteCartridge>("YourPrinter",
				Printer.DEFAULT_POWER_STATE,
				new PaperTray[] {new PaperTray(100,PaperTray.PAPER_SIZE_A4)},
				new BlackAndWhiteCartridge());
		
		yourPrinter.turnOn();
		((Printer)yourPrinter).print("I am black and white",10,PaperTray.PAPER_SIZE_A4);
		((Printer)yourPrinter).outputPage(8);
		//((Printer)yourPrinter).outputPage(8);
		((Printer)yourPrinter).outputPages();
		
		}
		catch(Exception e){
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			System.out.println("-------begin StackTrace-----");
			e.printStackTrace();
			System.out.println("-----end StackTrace-----");
		}
		finally{
			myPrinter.turnOff();
		}
		
		
	}
}
