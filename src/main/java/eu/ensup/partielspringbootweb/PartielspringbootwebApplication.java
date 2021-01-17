package eu.ensup.partielspringbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="eu.ensup.partielspringbootweb.*")

public class PartielspringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartielspringbootwebApplication.class, args);
	}

}
