package com.example.vehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resource;
	private String fieldName;
	private Object FieldValue;
	
	public ResourceNotFoundException(String resource, String fieldName, Object fieldValue) {
		super(resource + "Not Found for:"+ fieldName +" and value: " +fieldValue);
		this.resource = resource;
		this.fieldName = fieldName;
		FieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResource() {
		return resource;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return FieldValue;
	}
	
}
