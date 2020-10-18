package tn.enis.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.membre.entities.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

}