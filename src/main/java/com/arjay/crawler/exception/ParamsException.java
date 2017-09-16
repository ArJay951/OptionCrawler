package com.arjay.crawler.exception;

import com.arjay.crawler.config.ParamsConfig;

public class ParamsException extends RuntimeException {

	private static final long serialVersionUID = 8626317548355316528L;

	public ParamsException() {
		super();
	}

	public ParamsException(String s) {
		super(s);
		ParamsConfig.printHelp();
	}

	public ParamsException(String s, Throwable throwable) {
		super(s, throwable);
		ParamsConfig.printHelp();
	}

	public ParamsException(Throwable throwable) {
		super(throwable);
		ParamsConfig.printHelp();
	}
}
