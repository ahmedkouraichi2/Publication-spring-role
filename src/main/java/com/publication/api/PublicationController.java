package com.publication.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.publication.entity.Publication;
import com.publication.repository.IPublicationRepository;
import com.publication.servicesImp.PublicationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/publication")
public class PublicationController {
	
	   @Autowired
	    private PublicationService pubser;
	    @Autowired
	   private IPublicationRepository pubrep;
	    
	    
	    @PostMapping("add-pub")
	    @ResponseBody
	    public Publication addPublication (@RequestBody Publication p) {
	        Publication pu = pubser.addPublication(p);
	        return pu;
	    }
	    
	    /* delete    */
	    @DeleteMapping("/delete/{pub-id}")
	    @ResponseBody
	    public void removeChat(@PathVariable("pub-id") long pubId) {
	        pubser.deletePublication(pubId);
	    }
	    
	    @PutMapping("/modify-pub")
	    @ResponseBody
	    public Publication modifyChat(@RequestBody Publication pub) {
	        return pubser.updatePublication(pub);
	    }
	    
	    @GetMapping("/retrieve-all-pub")
	    @ResponseBody
	    public List<Publication> getPub() {
	        List<Publication> list = pubser.retrieveAllPublication();
	        return list;
	        
	    }
	    
	    @GetMapping("/retrieve-pub/{pub-id}")
	    @ResponseBody
	    public Publication retrievePub(@PathVariable("pub-id") Long id) {
	        return pubser.retrievePublication(id);
	    }

	
	    @GetMapping("/retrieve-lastPub")
	    @ResponseBody
	    public Publication retrieveLastPub() {
	        return pubrep.findFirstByOrderByIdDesc();
	    }

	    @GetMapping("/CountPublication")
	    @ResponseBody
	    public Long  countPub() {
	        return pubrep.countPublicationById();
	    }

	    @GetMapping("/retrieve-all-pubWithLastModifiedDateExists")
	    
	    @ResponseBody
	    public Optional<Publication> getPubLastModifiedDateExists() {
	        Optional<Publication> list = Optional.ofNullable(pubrep.findPublicationByLastModifiedDateIsNotNull().orElse(null));
	        return list;
	    }
	    
	    
	    

}
