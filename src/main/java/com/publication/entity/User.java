package com.publication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String prenom;
	    private String telephone;
	    private String email;
	    private String username;
	    private String password;
	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    private Collection<Role> roles = new ArrayList<>();
	    
	    
	    

}
