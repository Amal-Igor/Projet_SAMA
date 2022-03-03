package fr.dawan.SamaTravel.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private IAppUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		// //Granted authority
		AppUser user = userService.findByUsername(username);
		if (user == null) {
			System.out.println("User Null -- AppUserDetails Impl");
		}
		// les rôles pour Spring Security sont des objets d'une Collection de type
		// GrantedAuthority
		
		

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getName()));
		});
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

//	private Set<SimpleGrantedAuthority> getAuthority(AppUser user) {
//		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//		user.getRoles().forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//		});
//		return authorities;
//	}
//	
//	private Collection<SimpleGrantedAuthority> getAuthority(AppUser user) {
//		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        });
//        return authorities;
//    }
}
