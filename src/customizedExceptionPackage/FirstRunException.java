package customizedExceptionPackage;


/**
 * A customized Exception Class to catch any error
 * happens at the very first run of the program
 * @author Yahya Almardeny
 * @version 02/12/2016
 */
public class FirstRunException extends Exception {


	private static final long serialVersionUID = 1L;

	
	/**
	 * the constructor with no parameter
	 */
	public FirstRunException() {
		
	}

	/**
	 * @param message
	 */
	public FirstRunException(String message) {
		super(message);
		
	}

	/**
	 * @param arg0
	 */
	public FirstRunException(Throwable arg0) {
		super(arg0);
		
	}

	/**
	 * @param message
	 * @param arg1
	 */
	public FirstRunException(String message, Throwable arg1) {
		super(message, arg1);
	
	}

	/**
	 * @param message
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public FirstRunException(String message, Throwable arg1, boolean arg2, boolean arg3) {
		super(message, arg1, arg2, arg3);
	}

}
