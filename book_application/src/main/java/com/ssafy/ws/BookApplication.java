package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.ws.model.dao"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.ws.model.dao")
@SpringBootApplication
@EnableSwagger2
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
