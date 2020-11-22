package tn.enis.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.member.bean.PublicationBean;
import tn.enis.member.bean.ToolBean;
import tn.enis.member.dao.MemberPublicationRepository;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.dao.MemberToolRepository;
import tn.enis.member.dao.StudentRepository;
import tn.enis.member.dao.TeacherRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.MemberPublication;
import tn.enis.member.entities.MemberTool;
import tn.enis.member.entities.PublicationMemberId;
import tn.enis.member.entities.Student;
import tn.enis.member.entities.Teacher;
import tn.enis.member.entities.ToolMemberId;
import tn.enis.member.proxy.PublicationProxy;
import tn.enis.member.proxy.ToolProxy;

@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {
	private final MemberRepository memberRepository;
	private final TeacherRepository teacherRepository;
	private final MemberPublicationRepository memberPublicationRepository;
	private final PublicationProxy publicationProxy;
	private final StudentRepository studentRepository;
	private final MemberToolRepository memberToolRepository;
	private final ToolProxy toolProxy;

	public MemberServiceImpl(MemberRepository memberRepository, TeacherRepository teacherRepository,
			StudentRepository studentRepository, MemberPublicationRepository memberPublicationRepository,
			PublicationProxy publicationProxy, MemberToolRepository memberToolRepository, ToolProxy toolProxy) {
		super();
		this.memberRepository = memberRepository;
		this.teacherRepository = teacherRepository;
		this.memberPublicationRepository = memberPublicationRepository;
		this.publicationProxy = publicationProxy;
		this.studentRepository = studentRepository;
		this.memberToolRepository = memberToolRepository;
		this.toolProxy = toolProxy;
	}

	@Override
	public List<Member> findAll() {

		List<Member> members = new ArrayList<>(memberRepository.findAll());

		return members;

	}

	@Override
	public Member getById(Long id) {

		Member member = memberRepository.findById(id).get();

		return member;

	}

	@Override
	public Member add(Member member) {

		return memberRepository.save(member);

	}

	@Override
	public void delete(Long id) {

		memberRepository.deleteById(id);
		log.info("deleteOneMember:Member with id = {} deleted successfully", id);

	}

	@Override
	public Member update(Member member) {

		return memberRepository.save(member);
	}

	public List<Teacher> findAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public List<Student> findAllStudents() {

		return studentRepository.findAll();
	}

	public Student affectTeacher(Long idTeacher, Long idStudent) {

		Student student = (Student) memberRepository.findById(idStudent).get();
		Teacher teacher = (Teacher) memberRepository.findById(idTeacher).get();
		student.setTeacher(teacher);
		return memberRepository.save(student);

	}

	@Override
	public List<Teacher> findByGrade(String grade) {

		List<Teacher> teacher = teacherRepository.findByGrade(grade);

		return teacher;

	}

	@Override
	public List<Teacher> findByEtablissement(String etablissement) {
		List<Teacher> teacher = teacherRepository.findByEtablissement(etablissement);

		return teacher;
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

	@Override
	public void affectMemberToTool(Long idMember, Long idTool) {
		Member member = memberRepository.findById(idMember).get();
		MemberTool memberTool = new MemberTool();
		memberTool.setMember(member);
		memberTool.setToolMemberId(new ToolMemberId(idMember, idTool));
		memberToolRepository.save(memberTool);

	}

	@Override
	public List<ToolBean> findToolByMember(Long idMember) {
		List<ToolBean> tools = new ArrayList<ToolBean>();
		List<MemberTool> membersToolId = memberToolRepository.findMemberToolId(idMember);
		membersToolId.forEach(s -> {
			tools.add(toolProxy.findToolById(s.getToolMemberId().getToolId()));

		});

		return tools;
	}

}
