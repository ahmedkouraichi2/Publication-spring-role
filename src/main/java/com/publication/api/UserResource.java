package com.publication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import com.publication.entity.RoleToUserForm;
import com.publication.entity.User;
import com.publication.repository.UserRepository;
import com.publication.servicesImp.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserResource {
	@Autowired
	 private  UserService userService;
	
	@Autowired
	UserRepository userRepo ;
	
	  @GetMapping("/users")
	    public ResponseEntity<List<User>> getUser() {
	        return ResponseEntity.ok().body(userService.getUsers());
	    }
	  
	  
	   @PostMapping("/save")
	    public ResponseEntity<User> getUser(@RequestBody User user) {
	        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
	        return ResponseEntity.created(uri).body(userService.saveUser(user));
	    }
	   
	   @PostMapping("/role/addtouser")
	    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
	        userService.addRoleToUser(form.getUsername(),form.getRoleName());
	        return ResponseEntity.ok().build();
	    }
	   
	    /***** update and delete**/
	   
	   @DeleteMapping("/delete/{user-id}")
	    @ResponseBody
	    public void removeUser(@PathVariable("user-id") long id) {
		   userRepo.deleteById(id);
	    }
	   
	   
	   @PutMapping("/modify-user")
	    @ResponseBody
	    public User modifyRole(@RequestBody User user) {
	        return userRepo.save(user);
	    }
	   
	   
	 //  @Secured("ROLE_ADMIN")
	    @GetMapping("/userspubnotnull")
	    public ResponseEntity<List<User>> getUserPubnotNull() {
	        return ResponseEntity.ok().body(userRepo.findUserByPublicationsNotNull());
	    }

	   
	   
	   
	    

}
