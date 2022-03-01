package fr.dawan.SamaTravel.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Ici on va créer une classe qui va permettre de factorisé toutes infos relative au JWT
 * comme par exemple la façon dont sera contruit le token (sur quelles infos on veut le génerer)
 * Cela permet également de récupérer les JWT existant, date d'expi
 * 
 */

@Service
public class JwtUtil {

	// TODO Pour modifier si on veut l'accès par email

	private String SECRET_KEY = "secret";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	// Cette méthode permet de décrypter le les claims dans le token c'est sur elle
	// qu'on va pouvoir par exemple récupérer expiration
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	
	// Permet de venir vérifier l'état du token, si toujours ok?
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	// Cette classe permet de générer ke token sur la base de l'objet
	// UserDetails(Spring Securiy)
	// Une fois personne authentifié on crée un token
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());// Create token passe une Map de "claims" pour la gestion
																// des roles etc
	}

	// Permet de custom le token
	// Le sbject est la personne qui a été authentifié succesfully
	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	
	// Ici on verfie le token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
