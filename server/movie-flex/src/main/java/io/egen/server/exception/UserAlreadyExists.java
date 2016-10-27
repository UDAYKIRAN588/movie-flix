package io.egen.server.exception;

public class UserAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8431088742507335338L;
	
	public UserAlreadyExists (String message) {
		super(message);
	}
	

}
