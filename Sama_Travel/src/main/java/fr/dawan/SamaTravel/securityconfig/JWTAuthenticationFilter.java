package fr.dawan.SamaTravel.securityconfig;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.SamaTravel.entities.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Cette classe va intervenir lors du processus d'authentifcation. Il vérifie que password + username match et génére un JWT si positif
 */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authentificationManager) {
		this.authenticationManager = authentificationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		AppUser appUser = null;
		try {

			// TODO voir comment utiliser un DTO ici
			appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("L50 -- **************************************");
		System.out.println("username    " + appUser.getUsername() );
		System.out.println("password    " +  appUser.getPassword());
		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		
		//TODO Pourquoi le cast??
		User springUser = (User) authResult.getPrincipal();
		
		
		// Construction du token
		String jwt = Jwts.builder().setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles", springUser.getAuthorities()).compact();
		
		
		// Renvoie le token
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwt);
	}

}
