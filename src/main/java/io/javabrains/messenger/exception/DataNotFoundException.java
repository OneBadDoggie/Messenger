package io.javabrains.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1569344338878268730L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
