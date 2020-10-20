package tn.enis.publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.publication.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
