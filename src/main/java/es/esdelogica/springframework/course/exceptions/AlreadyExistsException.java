package es.esdelogica.springframework.course.exceptions;

public class AlreadyExistsException extends Exception {

	private static final long serialVersionUID = -7153727310739372761L;

	public AlreadyExistsException() {
		super("Element already exists.");
	}
}
