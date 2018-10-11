package com.vt.Vc.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.MemberRepository;
import com.vt.Vc.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;



	@Override
	public List<Member> getAllMembers() {
		List<Member> memberlist=memberRepository.findAll();
		return memberlist;
	}



	@Override
	public Optional<Member> getMemberDetails(@NotNull Long id) {
		
		Optional<Member> member=memberRepository.findById(id);
//		if(member.isPresent()) {
//			member.get().getGroups().parallelStream()
//		}
		return member;
	}



	@Override
	public int AddMembers(List<Member> memberList) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Group> getMemberGroups(Long memberID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
