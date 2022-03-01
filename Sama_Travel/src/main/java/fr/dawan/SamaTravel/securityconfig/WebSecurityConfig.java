package fr.dawan.SamaTravel.securityconfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Cette annotation permet de restreindre la config avant la méthode													// POST
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO configure authentication manager
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO configure web security
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
