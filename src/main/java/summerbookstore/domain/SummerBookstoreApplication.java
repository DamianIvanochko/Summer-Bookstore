package summerbookstore.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SummerBookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(SummerBookstoreApplication.class, args);
	}
}