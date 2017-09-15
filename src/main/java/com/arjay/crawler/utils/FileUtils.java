package com.arjay.crawler.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	private static Logger log = LoggerFactory.getLogger(FileUtils.class);

	public static void writeFile(Path pathTo, byte[] data) {
		try {
			Files.write(pathTo, data, new OpenOption[] { StandardOpenOption.CREATE, StandardOpenOption.WRITE });
		} catch (IOException e) {
			log.info("寫檔失敗:{}", e.getMessage());
		}
	}
}
