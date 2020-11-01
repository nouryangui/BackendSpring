package tn.enis.member.service;

import java.util.List;

import tn.enis.member.bean.PublicationBean;
import tn.enis.member.common.ServerException;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Teacher;

public interface IMemberService {
	List<Member> findAll() throws ServerException;

	Member getById(Long id);

	List<Teacher> findByGrade(String grade);

	Member add(Member member);

	void affectMemberToPublication(Long idauteur, Long idpub);

	List<PublicationBean> findPublicationByMember(Long idMember);

}
