//package fr.dawan.SamaTravel.service.implementation;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import fr.dawan.SamaTravel.entities.AppUser;
//import fr.dawan.SamaTravel.service.IUserService;
//
//public class UserDetailsImpl implements UserDetailsService {
//
//	@Autowired
//	IUserService userSerice;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		AppUser user = userSerice.findUserByUserName(username);
//
//		// On vérifie que le User qui essaie de se logger existe via userName
//		if (user == null) {
//			throw new UsernameNotFoundException(username);
//		}
//
//		// TODO Verifier la procédure Authorities JWT
//		// Les authorités dans spring security sont une collection de type
//		// GrantedAuthority(fournit par Spring Security) // Récupérer dans le JWT
//		// Authorization Fitler
//		Collection<GrantedAuthority> authorities = new ArrayList();
//		user.getRoles().forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//		});
//
//		// On va renvoyer une User i.e classe fournit dans Spring Security
//		return new User(user.getUsername(), user.getPassword(), authorities);
//	}
//
//}
