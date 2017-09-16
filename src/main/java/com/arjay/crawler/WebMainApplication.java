package com.arjay.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
public class WebMainApplication {

	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(10);
		executor.setCorePoolSize(5);
		executor.setKeepAliveSeconds(30);
		return executor;
	}
=======

@SpringBootApplication
public class WebMainApplication {
>>>>>>> branch 'master' of https://github.com/ArJay951/OptionCrawler.git

	public static void main(String[] args) {
		SpringApplication.run(WebMainApplication.class);
	}
}
