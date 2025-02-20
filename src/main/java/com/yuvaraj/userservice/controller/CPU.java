package com.yuvaraj.userservice.controller;

import java.util.Date;


public class CPU implements Runnable {

	public static int a = 1;
	public static void main(Integer n) {
		CPU runnable = new CPU();
		for(int i=0; i < n; i++) {
	        Thread thread = new Thread(runnable);
	        thread.start();	
		}
	}

	@Override
	public void run() {
		Date d = new Date();
		int b = a++;
		System.out.println(b + " Thread is running : " + d.toString());

		long x = Long.MAX_VALUE, z = Long.MAX_VALUE;

		for (long i = 1; i < x; i++)
			z = (long) (Math.sqrt(x - i));
		d = new Date();
		
		System.out.println(b + " Thread stopped : " + d.toString() + " " + z);
	}

}
