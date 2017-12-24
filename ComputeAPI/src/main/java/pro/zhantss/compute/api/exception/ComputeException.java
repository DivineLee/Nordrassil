package pro.zhantss.compute.api.exception;

public class ComputeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7026068657039015475L;

	public ComputeException() {
		super();
	}
	
	public ComputeException(String message) {
		super(message);
	}
	
	public ComputeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ComputeException(Throwable cause) {
        super(cause);
    }
	
}
