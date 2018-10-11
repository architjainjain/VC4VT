package com.vt.Vc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.enumerate.BidStatus;
import com.vt.Vc.model.Bid;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.BidRepository;
import com.vt.Vc.service.BidService;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bidRepository;
	

	@Override
	public void PutBid(double amount, Member member, Group group, Draw draw) {

	}

	@Override
	public void StartBid(double amount, Member member, Group group, Draw draw) {
		Bid StartBid=Bid.builder().bidAmount(amount).bidder(member).draw(draw).status(BidStatus.INITIAL).build();
		bidRepository.findAll();
		//mem.findAll();
		List<Bid> b=bidRepository.findByDrawId(11L);//findByStatus(BidStatus.INITIAL.getValue());
		b.stream().forEach((p)->System.out.println(p));
		
		b=bidRepository.findByStatus(BidStatus.INITIAL);
		
		//System.out.println(b.getBidder());
	}

	

	@Override
	public void closeBidding() {
		// TODO Auto-generated method stub

	}

}
