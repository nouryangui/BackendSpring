package tn.enis.membre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.enis.membre.entities.Member;

@Service
public interface IMemberService {
	public List<Member> findAll();

}
