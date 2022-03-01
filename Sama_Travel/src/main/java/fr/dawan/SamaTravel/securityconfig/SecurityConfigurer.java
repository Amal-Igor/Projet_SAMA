package fr.dawan.SamaTravel.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.dawan.SamaTravel.service.AppUserService;
import fr.dawan.SamaTravel.service.AppUserDetailsService;



@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
//	@Bean 
//	public BCryptPasswordEncoder getBCPE() {
//		return new BCryptPasswordEncoder();
//	}
	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	//TODO: 2 - implementer la classe User
	@Autowired
	private AppUserDetailsService myUserDetailsService;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll() //Ici on peut ajouter les routes sur lesquels aucune authentification n'est due
		.anyRequest().authenticated();
	}




	
	
//	//TODO Verifier la façon dont la ocnfiguration de sécurité vérifie le header --> JWT AuthFilter
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
//		
//		http.authorizeRequests().anyRequest().authenticated();
//		
//		http.addFilterBefore(new JWTAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
//		}

}
