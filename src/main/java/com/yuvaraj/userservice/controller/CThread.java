package com.yuvaraj.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CThread extends Thread {
	private String threadName;
	private Integer time;
    private static final Logger logger = LoggerFactory.getLogger(CThread.class);

    CThread(String name, Integer time) {
        threadName = name;
        this.time = time;
    }

    public void run() {
    	logger.info(threadName + " is running.");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        	logger.info(threadName + " interrupted.");
        }
        logger.info(threadName + " has finished.");
    }
}
