package tn.enis.publication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.publication.entities.Publication;
import tn.enis.publication.repository.PublicationRepository;

@Service
public class PublicationServiceImpl implements IpublicationService {
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication getById(Long id) {
		return publicationRepository.findById(id).get();
	}

	@Override
	public Publication add(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public void delete(Long id) {
		publicationRepository.deleteById(id);

	}

	@Override
	public Publication update(Publication publication) {
		return publicationRepository.save(publication);

	}

}
