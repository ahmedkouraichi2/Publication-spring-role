package com.publication.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publication.entity.Publication;
import com.publication.repository.IPublicationRepository;
import com.publication.services.IPublicationService;


@Service 
public class PublicationService  implements IPublicationService { 

@Autowired 

private IPublicationRepository publicationRepository;

@Override
public Publication addPublication(Publication p) {
	
	return publicationRepository.save(p);
}

@Override
public void deletePublication(Long id) {
	publicationRepository.deleteById(id);
	
	
}

@Override
public Publication updatePublication(Publication t) {
      Publication pub = publicationRepository.findById(t.getId()).orElse(null);
      return publicationRepository.save(t);
}

@Override
public List<Publication> retrieveAllPublication() {
	// TODO Auto-generated method stub
	   return publicationRepository.findAll();
}

@Override
public Publication retrievePublication(Long id) {
	// TODO Auto-generated method stub
	 return publicationRepository.findById(id).get();
}
}
