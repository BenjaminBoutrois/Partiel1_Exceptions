package eu.ensup.partielspringbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan

public class PartielspringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartielspringbootwebApplication.class, args);
	}

}
