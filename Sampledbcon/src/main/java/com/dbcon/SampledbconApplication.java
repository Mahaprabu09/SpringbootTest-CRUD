package com.dbcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SampledbconApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampledbconApplication.class, args);
		System.out.println("Spring boot db test");
	}

}
