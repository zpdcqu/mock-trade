package com.pdongzheng.mocktrade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.pdongzheng.mocktrade.mapper")
public class MocktradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MocktradeApplication.class, args);
	}

}
