package mvc1.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan	// 서블릿 자동등록
@SpringBootApplication
public class Mvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mvc1Application.class, args);
	}

}
