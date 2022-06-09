package com.educandoweb.course.services.exceptions;

/*Classe de tratamento de Excessão para não dar codigo 500 quando o erro é conhecido*/
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}

}
