package KimYeongHan.SpringLecture4Servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringLecture4ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLecture4ServletApplication.class, args);
	}

}
