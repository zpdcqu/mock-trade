package com.pdongzheng.mocktrade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.pdongzheng.mocktrade.mapper")
@EnableScheduling
public class MocktradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MocktradeApplication.class, args);
	}

}
