package com.publication.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publication.entity.Role;
import com.publication.entity.User;
import com.publication.repository.RoleRepositroy;
import com.publication.repository.UserRepository;
import com.publication.services.IUserService;


@Service
public class UserService  implements  IUserService{
        
	
	    @Autowired 
	    private  UserRepository userRepo;
	    
	    @Autowired 
	    private RoleRepositroy roleRepo;
	
	
	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		
		 User user = userRepo.findByUsername(username);
		 Role role = roleRepo.findByName(roleName);
		 user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		
        return userRepo.findByUsername(username);

	}

	@Override
	public List<User> getUsers() {
      //log.info("Fetching All users ");
		return  userRepo.findAll();
	}

}
