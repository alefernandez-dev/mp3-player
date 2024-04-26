package dev.alejandro.mp3player;

import dev.alejandro.mp3player.service.Mp3ManagerService;
import dev.alejandro.mp3player.service.Mp3ManagerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Mp3PlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mp3PlayerApplication.class, args);
	}

	@Bean
	Mp3ManagerService managerService(){
		return new Mp3ManagerServiceImpl();
	}

}
