package tn.enis.member.service;

import java.util.List;
import tn.enis.member.common.ServerException;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Teacher;

public interface IMemberService {
	public List<Member> findAll() throws ServerException;
	public Member getById(Long id);
	public List<Teacher> findByGrade(String grade);
	public Member add(Member member);
}
