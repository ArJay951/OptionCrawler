package com.arjay.crawler.exception;

public class CrawlerException extends RuntimeException {

	private static final long serialVersionUID = 8626317548355316528L;

	public CrawlerException() {
		super();
	}

	public CrawlerException(String s) {
		super(s);
	}

	public CrawlerException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public CrawlerException(Throwable throwable) {
		super(throwable);
	}
}
