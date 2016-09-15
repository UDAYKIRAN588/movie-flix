package io.egen.server.exception;

public class EntityNotFoundException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4290971227553019024L;
	
	public EntityNotFoundException (String message) {
		super(message);
	}

}
