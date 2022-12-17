package com.publication.services;

import java.util.List;

import com.publication.entity.Publication;

public interface IPublicationService {
	
	 Publication addPublication(Publication p);
	 
	 void deletePublication(Long id);
	 
	 Publication updatePublication(Publication t);
	 
	 List<Publication> retrieveAllPublication();
	 
	 Publication retrievePublication(Long id);
}
