package com.majjel.majjel.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.majjel.majjel.user.User;
import com.majjel.majjel.user.UserRepository;

@Configuration
public class InitDatabase {

	private static final Logger log = LoggerFactory.getLogger(InitDatabase.class);

	@Bean
	public CommandLineRunner InitDatabase(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new User("user1", "user1@email.com", "$2a$10$lNVNnZpHrS5R2KbXNdgMa.Gv4F969fwkMO9Ky4RZXGn81BJDhuVhe")));
			log.info("Preloading " + repository.save(new User("user2", "user2@email.com", "$2a$10$lNVNnZpHrS5R2KbXNdgMa.Gv4F969fwkMO9Ky4RZXGn81BJDhuVhe")));
		};
	}

}
