package se.slut_projekt_Lexicon.slut_projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SlutProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlutProjektApplication.class, args);
	}
@Bean
	public java.util.Scanner sc(){
	return new java.util.Scanner(System.in);
}
}
