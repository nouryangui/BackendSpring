package tn.enis.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.member.common.ServerException;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Student;
import tn.enis.member.service.IMemberService;

@RestController
public class MemberController {
	@Autowired
	IMemberService memberService;

	@GetMapping("/members")
	public List<Member> findAll() throws ServerException {
		return memberService.findAll();
	}
	@PostMapping(value = "/students")
	public Member addMembre(@RequestBody Student student) {
		return memberService.add(student);
	}

}
