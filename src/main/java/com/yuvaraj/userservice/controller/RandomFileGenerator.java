package com.yuvaraj.userservice.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class RandomFileGenerator extends Thread {
	private String threadName;
    private final String DIRECTORY = "random_files";
    private final SecureRandom RANDOM = new SecureRandom();
    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private int TEXT_LENGTH = 5;
	
    RandomFileGenerator(String name, int TEXT_LENGTH) {
        threadName = name;
		this.TEXT_LENGTH = TEXT_LENGTH;
    }
	
    public void run() {
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
			String randomFileNameText = generateRandomText(10);
            String fileName = DIRECTORY + "/f_" + randomFileNameText + ".txt";
            String randomText = generateRandomText(TEXT_LENGTH);
            writeToFile(fileName, randomText);
            System.out.println("Created: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateRandomText(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    private void writeToFile(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_8)) {
            writer.write(content);
        }
    }
}
