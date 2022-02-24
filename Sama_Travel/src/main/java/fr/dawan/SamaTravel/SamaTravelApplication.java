package fr.dawan.SamaTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.dawan.SamaTravel.entities.BeanConfiguration;

@SpringBootApplication
public class SamaTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamaTravelApplication.class, args); 
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		context.close();
	}

}
