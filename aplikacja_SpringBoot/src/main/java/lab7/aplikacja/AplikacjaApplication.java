package lab7.aplikacja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"lab7.aplikacja.repositories"})
public class AplikacjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikacjaApplication.class, args);
	}
}
