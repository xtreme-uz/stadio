package uz.xtreme.stadio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.xtreme.stadio.domain.Category;
import uz.xtreme.stadio.domain.User;
import uz.xtreme.stadio.repository.CategoryRepository;
import uz.xtreme.stadio.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class StadioApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(StadioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (userRepository.findByUsername("admin").isEmpty()) {
			User user = new User();
			user.setPassword("12345678");
			user.setUsername("admin");
			user.setEmail("info@xtreme.io");
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setPhoneNumbers(List.of("+998991234567"));
			userRepository.save(user);
		}

		if (categoryRepository.findById("mini_football_field").isEmpty()) {
			Category category = new Category();
			category.setSlug("mini_football_field");
			category.setName("Mini football field");
			categoryRepository.save(category);
		}
	}
}
