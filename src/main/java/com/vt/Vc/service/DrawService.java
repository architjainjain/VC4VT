package com.vt.Vc.service;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;

@Service
public interface DrawService {
	
	public Draw StartDraw(Group group,double initialamount);
	
	public Draw CompleteDraw(Group group);

	public void putBid(Draw currentDarw, Member member, double amount);

	public Draw getCurrentDraw(Group group);
	

}
