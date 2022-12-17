package com.publication.api;

import java.net.URI;
import java.util.List;

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

import com.publication.entity.Role;
import com.publication.repository.RoleRepositroy;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Role")
public class RoleController {
	
	   @Autowired
       private RoleRepositroy roleRepositroy;
	   @PostMapping("/save")
       public ResponseEntity<Role> getUser(@RequestBody Role role) {
           URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/role").toUriString());
           return ResponseEntity.created(uri).body(roleRepositroy.save(role));
       }
       @DeleteMapping("/delete/{role-id}")
       @ResponseBody
       public void removeRole(@PathVariable("role-id") long id) {

           roleRepositroy.deleteById(id);
       }
       

       @PutMapping("/modify-role")
       @ResponseBody
       public Role modifyRole(@RequestBody Role role) {
           return roleRepositroy.save(role);
       }
       @GetMapping("/retrieve-all-role")
       @ResponseBody
       public List<Role> getPub() {
           List<Role> list = roleRepositroy.findAll();
           return list;
       }

}
