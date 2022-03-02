package fr.dawan.SamaTravel;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;


import fr.dawan.SamaTravel.entities.BeanConfiguration;
import fr.dawan.SamaTravel.repositories.AppUserRepository;
import fr.dawan.SamaTravel.service.IAppUserService;
import fr.dawan.SamaTravel.service.IUserService;
import fr.dawan.SamaTravel.entities.AppUser;

@SpringBootApplication
public class SamaTravelApplication {
	

	
	@Bean
	public ModelMapper modelMapper() {
	return new ModelMapper();
	
}
//	@Bean 
//	public BCryptPasswordEncoder getBCPE() {
//		return new BCryptPasswordEncoder();
//	}


	public static void main(String[] args) {
		SpringApplication.run(SamaTravelApplication.class, args); 

		
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		context.close();
		


		
		
	}

}
