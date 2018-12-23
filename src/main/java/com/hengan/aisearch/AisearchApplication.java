package com.hengan.aisearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.hengan.aisearch.db.mapper")
@EnableCaching
public class AisearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AisearchApplication.class, args);
	}

}

