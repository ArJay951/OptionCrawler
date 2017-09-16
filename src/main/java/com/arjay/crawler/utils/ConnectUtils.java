package com.arjay.crawler.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class ConnectUtils {
	//@formatter:off
	public static Connection getDefaultConnection(String url) {
		return Jsoup.connect(url)
				.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				.header("Accept-Encoding","gzip, deflate")
				.header("Accept-Language","zh-TW,zh;q=0.8,en-US;q=0.6,en;q=0.4")
				.header("Cache-Control","max-age=0")
				.header("Connection","keep-alive")
				.header("Content-Length","121")
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Cookie","ASPSESSIONIDCQDARDRA=IDPNGOOADDPJLIFCGCFKBGDD; AX-cookie-POOL_PORTAL=AGACBAKM; AX-cookie-POOL_PORTAL_web3=ADACBAKM")
				.header("Host","www.taifex.com.tw")
				.header("Upgrade-Insecure-Requests","1")
				.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
	} 
	//@formatter:on
}
