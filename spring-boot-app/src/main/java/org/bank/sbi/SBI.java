package org.bank.sbi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBI implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SBI.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Line Runner Invoked");
    }
}

/*
        CommandLineRunner commandLineRunner = (System.out::println);
        commandLineRunner.run(args);
*/