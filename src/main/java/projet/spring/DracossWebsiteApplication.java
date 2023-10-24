package projet.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "projet.spring")
public class DracossWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DracossWebsiteApplication.class, args);
	}

}

