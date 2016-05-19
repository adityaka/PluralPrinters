package Printers;

public class OutOfPaperException extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public OutOfPaperException(){
	  super("Tray Out of Paper");
  }
}
