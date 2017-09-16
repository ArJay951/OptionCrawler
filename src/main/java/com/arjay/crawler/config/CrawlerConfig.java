package com.arjay.crawler.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.arjay.crawler.parser", "com.arjay.crawler.crawler" })
public class CrawlerConfig {

}
