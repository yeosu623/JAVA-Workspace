package com.pinforyou.project;

import com.pinforyou.project.apple.AppleJwtUtils;
import com.pinforyou.project.apple.AppleTokenPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.pinforyou.project.apple")
@ComponentScan(basePackages = "com.pinforyou.project.apple")
public class AppleLoginTest7Application  {	// implements CommandLineRunner

/*	private final AppleJwtUtils appleJwtUtils;

	public AppleLoginTest7Application(AppleJwtUtils appleJwtUtils) {
		this.appleJwtUtils = appleJwtUtils;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(AppleLoginTest7Application.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		appleJwtUtils.printToken();
	}*/

	/*@Bean
	public CommandLineRunner run(AppleTokenPrinter appleTokenPrinter) {
		return args -> {
			// AppleTokenPrinter 클래스를 사용하여 토큰을 출력
			appleTokenPrinter.printToken();
		};
	}*/

}