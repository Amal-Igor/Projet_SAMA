package fr.dawan.SamaTravel.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
//	@Bean 
//	public BCryptPasswordEncoder getBCPE() {
//		return new BCryptPasswordEncoder();
//	}


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	//TODO: 2 - implementer la classe User
//	@Autowired
//	private AppUserDetailsService myUserDetailsService;
//	
	@Autowired
	private UserDetailsService myUserDetailsService;
	
	//TODO Rédfinir : une qui prend en parametre AuthBuilder
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// On desactive les sessions
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login/**", "/register/**", "/account/**").permitAll(); //Ici on peut ajouter les routes sur lesquels aucune authentification n'est due
		
		
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
		
		
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		
		http.addFilterBefore(new JWTAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
		
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
