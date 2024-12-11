package com.manager.users;

import com.manager.users.entity.UserModel;
import com.manager.users.entity.repository.UserRepository;
import com.manager.users.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersApplication {

	@Resource
	private UserService userService;

	private void testFunc() {
		UserModel model = new UserModel();
		final long id = model.getId();
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			Stream.of("John Wick", "Julie Smith", "Jennifer Lopez", "Helen Adams", "Rachel Beta").forEach(nameAndSurname -> {
				String[] splittedNameAndSurname = nameAndSurname.split("\\s+");

				UserModel user = UserModel.builder()
						.name(splittedNameAndSurname[0])
						.surname(splittedNameAndSurname[1])
						.email(splittedNameAndSurname[0] + splittedNameAndSurname[1] + "@gmail.com")
						.build();
				userService.create(user);
			});
			userService.findAll().forEach(System.out::println);
		};
	}
}
