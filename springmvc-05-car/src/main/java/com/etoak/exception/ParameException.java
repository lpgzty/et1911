package com.etoak.exception;
/**
 * 自定义异常
 * @author LPG
 *
 */
public class ParameException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public ParameException(String message) {
		super(message);
	}
}
