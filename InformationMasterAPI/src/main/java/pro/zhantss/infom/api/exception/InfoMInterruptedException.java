package pro.zhantss.infom.api.exception;

public class InfoMInterruptedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1735467442742672783L;
	
	public InfoMInterruptedException() {
		super();
	}
	
	public InfoMInterruptedException(String message) {
		super(message);
	}
	
	public InfoMInterruptedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InfoMInterruptedException(Throwable cause) {
        super(cause);
    }
	
}
