package com.vt.Vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.Vc.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	

}
