package com.publication.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.publication.entity.Publication;

@Repository
public interface IPublicationRepository extends JpaRepository<Publication,Long> {
	
	 Publication findFirstByOrderByIdDesc();

	 @Query("select count(p) from Publication p")
	 Long countPublicationById();
	Optional<Publication> findPublicationByLastModifiedDateIsNotNull();

}


