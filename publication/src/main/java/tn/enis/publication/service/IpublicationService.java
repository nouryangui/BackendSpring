package tn.enis.publication.service;

import java.util.List;
import tn.enis.publication.entities.Publication;

public interface IpublicationService {
	public List<Publication> findAll();

	public Publication getById(Long id);

	public Publication add(Publication publication);

	public void delete(Long id);

	public Publication update(Publication publication);

}
