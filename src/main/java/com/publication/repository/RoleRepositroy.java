package com.publication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.publication.entity.Role;

@Repository
public interface RoleRepositroy  extends JpaRepository<Role,Long>{

	Role findByName(String name);
	
	
}
