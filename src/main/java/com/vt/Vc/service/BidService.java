package com.vt.Vc.service;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;

@Service
public interface BidService {
	
	public void PutBid(double amount, Member member, Group group, Draw draw);
	
	public void StartBid(double amount, Member member, Group group, Draw draw);
	
	public void closeBidding();

}
