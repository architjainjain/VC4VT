package com.vt.Vc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;

@Service
public interface BidService {
	
	@Transactional
	public void PutBid(double amount, Member member, Group group, Draw draw);
	
	public String StartBid(double amount, Member member, Group group, Draw draw);
	
	public void closeBidding(Draw draw);

}
