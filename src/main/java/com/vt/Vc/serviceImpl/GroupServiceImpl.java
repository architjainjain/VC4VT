package com.vt.Vc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.enumerate.groupStatus;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.DrawRepository;
import com.vt.Vc.repository.GroupRepository;
import com.vt.Vc.service.DrawService;
import com.vt.Vc.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private DrawService drawService;

	@Override
	public void AddMember() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMember() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroup() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Draw performDraw(Group group) {
		Draw currentDraw=drawService.StartDraw(group,1000);
		group.setStatus(groupStatus.DRAWUNDERPROCESS);
		groupRepository.save(group);
		return currentDraw;
		
	}
	
	@Override
	public void UpdateBid(Group group, Member member, double amount) {
		
		Draw currentDarw=drawService.getCurrentDraw(group);
		drawService.putBid(currentDarw, member, amount);
		
	}
	
	@Override
	public void completeDraw(Group group) {
		Draw currentDraw=drawService.CompleteDraw(group);
		group.setNumberofDrawDone(currentDraw.getDrawNumber());
		group.setStatus(groupStatus.RUNNING);
		groupRepository.save(group);
	}

}
