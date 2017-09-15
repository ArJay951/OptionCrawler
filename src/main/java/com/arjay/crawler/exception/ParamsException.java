package com.arjay.crawler.exception;

public class ParamsException extends RuntimeException {

	private static final long serialVersionUID = 8626317548355316528L;

	public ParamsException() {
		super();
	}

	public ParamsException(String s) {
		super(s);
	}

	public ParamsException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public ParamsException(Throwable throwable) {
		super(throwable);
	}
}
