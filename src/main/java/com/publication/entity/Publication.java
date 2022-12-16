package com.publication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publication {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String titre;
	    private String description;
	    private Date date;
	    
	    @ManyToOne(cascade= CascadeType.PERSIST)
	    private User user_publi;
	    
	    
	    @OneToMany(mappedBy="user_publi",cascade=CascadeType.ALL )
	    private List<Publication> publications = new ArrayList<>();

}
