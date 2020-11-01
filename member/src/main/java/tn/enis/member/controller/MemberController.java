package tn.enis.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.member.common.ServerException;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Student;
import tn.enis.member.service.IMemberService;

@RestController
@RequestMapping("/api/members")

public class MemberController {
	@Autowired
	IMemberService memberService;

	@GetMapping()
	public List<Member> findAll() throws ServerException {
		return memberService.findAll();
	}

	@PostMapping(value = "/students")
	public Member addMembre(@RequestBody Student student) {
		return memberService.add(student);
	}

	@GetMapping("/fullmember/{id}")
	public Member findAFullMember(@PathVariable(name = "id") Long id) {
		Member member = memberService.getById(id);
		member.setPublications(memberService.findPublicationByMember(id));
		return member;
	}
	@PostMapping("/publications/{idMember}/{idPublication}")
	public void affectMemberToPublication(@PathVariable Long idMember,@PathVariable Long idPublication)
	{
		memberService.affectMemberToPublication(idMember, idPublication);
	}

}
