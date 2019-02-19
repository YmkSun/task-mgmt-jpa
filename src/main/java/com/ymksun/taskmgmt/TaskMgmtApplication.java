package com.ymksun.taskmgmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskMgmtApplication {

	private static final Logger logger = LogManager.getLogger(TaskMgmtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskMgmtApplication.class, args);
		logger.info("Applaction Started...");
	}

}
