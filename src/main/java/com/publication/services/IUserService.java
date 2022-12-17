package com.publication.services;

import java.util.List;

import com.publication.entity.Role;
import com.publication.entity.User;

public interface IUserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
	

}
