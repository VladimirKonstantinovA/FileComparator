package com.example.filecomparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;

@SpringBootApplication
public class FilecomparatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilecomparatorApplication.class, args);
        mainClass.start(System.getProperty("user.dir"), true);
    }

}
