package io.egen.server.exception;

public class DataAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9042613560228312077L;
	
	public DataAlreadyExists (String message) {
		super(message);
	}

}
