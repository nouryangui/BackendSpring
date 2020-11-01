package tn.enis.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.member.bean.PublicationBean;
import tn.enis.member.common.Constants;
import tn.enis.member.common.Constants.EntitiesNames;
import tn.enis.member.common.ServerException;
import tn.enis.member.dao.MemberPublicationRepository;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.dao.TeacherRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.MemberPublication;
import tn.enis.member.entities.PublicationMemberId;
import tn.enis.member.entities.Teacher;
import tn.enis.member.proxy.PublicationProxy;

@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {
	private final MemberRepository memberRepository;
	private final TeacherRepository teacherRepository;
	private final MemberPublicationRepository memberPublicationRepository;
	private final PublicationProxy publicationProxy;

	public MemberServiceImpl(MemberRepository memberRepository, TeacherRepository teacherRepository,
			MemberPublicationRepository memberPublicationRepository, PublicationProxy publicationProxy) {
		super();
		this.memberRepository = memberRepository;
		this.teacherRepository = teacherRepository;
		this.memberPublicationRepository = memberPublicationRepository;
		this.publicationProxy = publicationProxy;
	}

	@Override
	public List<Member> findAll() throws ServerException {

		try {
			List<Member> members = new ArrayList<>(memberRepository.findAll());
			if (!members.isEmpty()) {
				log.info("members loaded successfully");
			} else {
				log.info("members have not been loaded");
			}
			return members;

		} catch (ServerException e) {

			throw new ServerException(Constants.ErrorMessages.loading(EntitiesNames.MEMBERS));
		}

	}

	@Override
	public Member getById(Long id) {
		try {
			Member member = memberRepository.findById(id).get();
			if (member == null) {
				throw new ServerException(Constants.ErrorMessages.searching(Constants.EntitiesNames.MEMBERS));
			}
			log.info("findOneMember : user with id={} loaded successfully", id);
			return member;
		} catch (ServerException e) {
			throw new ServerException(Constants.ErrorMessages.loading(EntitiesNames.MEMBERS));

		}
	}

	@Override
	public List<Teacher> findByGrade(String grade) {

		try {
			List<Teacher> teacher = teacherRepository.findByGrade(grade);
			if (teacher == null) {
				throw new ServerException(Constants.ErrorMessages.searching(Constants.EntitiesNames.MEMBERS));
			}
			log.info("findTeachers : user with grade={} loaded successfully", grade);
			return teacher;

		} catch (ServerException e) {
			throw new ServerException(Constants.ErrorMessages.searching(EntitiesNames.MEMBERS));
		}
	}

	@Override
	public Member add(Member member) {
		try {
			Member memberEntity = memberRepository.findByCin(member.getCin());
			if (memberEntity != null) {
				throw new ServerException("Cin already exist");
			}
			memberEntity = memberRepository.findByEmail(member.getEmail());
			if (memberEntity != null) {
				throw new ServerException("email already exist");
			}
			log.info("Member with id= {} saved successfully", member.getId());
			return memberRepository.save(member);
		} catch (ServerException e) {
			log.error(e.getMessage());
//			throw new ServerException(Constants.ErrorMessages.saving(EntitiesNames.MEMBERS));
		}
		return null;
	}

	@Override
	public void affectMemberToPublication(Long idMember, Long idPulication) {
		Member member = memberRepository.findById(idMember).get();
		MemberPublication memberPublication = new MemberPublication();
		memberPublication.setMember(member);
		memberPublication.setId(new PublicationMemberId(idMember, idPulication));
		memberPublicationRepository.save(memberPublication);

	}

	@Override
	public List<PublicationBean> findPublicationByMember(Long idMember) {
		List<PublicationBean> publications = new ArrayList<PublicationBean>();
		List<MemberPublication> membersPublication = memberPublicationRepository.findMemberPublicationId(idMember);
		membersPublication.forEach(s -> {
			publications.add(publicationProxy.recupererUnePublication(s.getId().getPulicationId()));

		});

		return publications;
	}

}
