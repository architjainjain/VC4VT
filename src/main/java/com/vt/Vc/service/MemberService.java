package com.vt.Vc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;

@Service
public interface MemberService {
	
	
	
	public List<Member> getAllMembers();

	public Optional<Member> getMemberDetails(Long id);
	
	public int AddMembers(List<Member> memberList);
	
	public List<Group> getMemberGroups(Long memberID);

}
