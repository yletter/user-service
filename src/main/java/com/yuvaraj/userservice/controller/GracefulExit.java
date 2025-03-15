package com.yuvaraj.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GracefulExit extends Thread {
	private String threadName;
	private Integer code;
    private static final Logger logger = LoggerFactory.getLogger(GracefulExit.class);

    GracefulExit(String name, Integer code) {
        threadName = name;
        this.code = code;
    }

    public void run() {
    	logger.info(threadName + " is running.");
        try {
            Thread.sleep(1000);
			System.exit(code);
        } catch (InterruptedException e) {
        	logger.info(threadName + " interrupted.");
        }
        logger.info(threadName + " has finished.");
    }
}
