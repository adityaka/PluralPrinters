package Printers;

public class PaperTray {
	public static final int PAPER_SIZE_A4 = 1;
	public static final int PAPER_SIZE_B3 = 2;
	public static final int PAPER_SIZE_B4 = 3;
	
	private int paperSize;
	private int paperLeft;
	public PaperTray(int paperCount, int paperSize)throws InvalidPaperSizeException{
		
		paperLeft = paperCount;
		switch(paperSize){
			case PaperTray.PAPER_SIZE_A4 : {
				
			}
			case PaperTray.PAPER_SIZE_B3 : {
			
			}
			case PaperTray.PAPER_SIZE_B4 :{
				this.paperSize = paperSize;
				break;
			}
			default: {
			throw new InvalidPaperSizeException();
			}
		
		}
	
	}
	
	public int getPaperCount(){
		return paperLeft;
	}
	
	public void loadPaper(int paperCount){
		paperLeft+=paperCount;
	}
	
	public void consumePaper(int paperCount)throws OutOfPaperException{
		if(paperCount > paperLeft){
			throw new OutOfPaperException();
		}
		else{
			paperLeft -= paperCount;
		}
	}
	
	public int getPaperSize(){
		return paperSize;
	}
}
