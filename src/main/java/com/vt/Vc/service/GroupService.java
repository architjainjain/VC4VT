package com.vt.Vc.service;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;

@Service
public interface GroupService {
	
	public void AddMember();
	
	public void removeMember();
	
	public void updateGroup();
	
	public Draw performDraw(Group group);

	public void completeDraw(Group group);

	public void UpdateBid(Group group, Member member, double amount);

}
