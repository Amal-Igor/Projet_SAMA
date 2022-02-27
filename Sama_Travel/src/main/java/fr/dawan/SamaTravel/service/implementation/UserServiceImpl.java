package fr.dawan.SamaTravel.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.UserRole;
import fr.dawan.SamaTravel.repositories.IRoleRepository;
import fr.dawan.SamaTravel.repositories.IUserRepository;
import fr.dawan.SamaTravel.service.IUserService;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	IUserRepository userRepo;

	@Autowired
	IRoleRepository roleRepository;

	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepo.save(user);
	}

	@Override
	public UserRole saveRole(UserRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		
		UserRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepo.findByUsername(username);
		
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUserName(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void update(AppUser c) {
		//TODO update user
	}

}
