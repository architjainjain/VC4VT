package com.vt.Vc.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.enumerate.BidStatus;
import com.vt.Vc.enumerate.DrawStatus;
import com.vt.Vc.model.Bid;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.BidRepository;
import com.vt.Vc.repository.DrawRepository;
import com.vt.Vc.repository.GroupRepository;
import com.vt.Vc.service.BidService;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bidRepository;

	@Autowired
	private DrawRepository drawrepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	

	final static Logger logger = LoggerFactory.getLogger(BidServiceImpl.class);

	private Predicate<Bid> getPredicateFilter(BidStatus bidStatus){
		Predicate<Bid> Filter= (Bid b)->{
			return b.getStatus().equals(bidStatus);
			};
			
			return Filter;
	}
	private boolean isvalidBid(double amount, Bid previousBid) {
		if (previousBid.getBidAmount() <= amount) {
			logger.info("Invalid BId: "+ previousBid.getBidAmount()+"is less than current bid:"+amount);
			return false;
		}
		logger.info("Valid BId: "+ previousBid.getBidAmount()+"is higher than current bid:"+amount);
		return true;
	}

	@Override
	public void PutBid(double amount, Member member, Draw draw) {
		
		
		if (drawrepository.findById(draw.getDrawID()).get().getStatus().equals(DrawStatus.RUNNING)) {
			logger.info("Draw is running, checking to put bid");
			
			//check if the user is valid to put the bid or not??
			
			List<Bid> bidlist = bidRepository.findByDrawId(draw);
			System.out.println(bidlist);
			if (bidlist.size() == 1) {
				logger.info("only initial bid is find");
				// only initial bid is present
				Bid initialBid = bidlist.get(0);
				if (isvalidBid(amount, initialBid)) {
					if (initialBid.getStatus().equals(BidStatus.INITIAL)) {
						logger.info("Changing status of initial bid");
						initialBid.setStatus(BidStatus.INITIALSARKARI);
						bidRepository.save(initialBid);
						logger.info("Adding new bid");
						
					Bid newBid=	Bid.builder()
						.bidAmount(amount)
						.bidder(member)
						.draw(draw)
						.status(BidStatus.CURRENT).build();
					bidRepository.save(newBid);
					logger.info("New Bid stored..Successfully");
					}

				}
				
			} else if (bidlist.size() > 1) {
				// current and intermediate bids are also present
				
				logger.info("More bids are present");
				Bid currentBid=bidlist.stream().filter(getPredicateFilter(BidStatus.CURRENT)).findAny().get();
				if(isvalidBid(amount, currentBid)) {
					logger.info("Changing current bid to intermediate");
					currentBid.setStatus(BidStatus.INTERMIDIATE);
					bidRepository.save(currentBid);
					logger.info("Adding new Bid");
					Bid newBid=Bid.builder()
					.bidAmount(amount)
					.bidder(member)
					.draw(draw)
					.status(BidStatus.CURRENT).build();
					bidRepository.save(newBid);
					
					logger.info("New Bid stored..Successfully");
				}

			}

		}
	}

	@Override
	public String StartBid(double amount, Member member, Group group, Draw draw) {

		if (bidRepository.getBidForTheGroupByStatus(draw, BidStatus.INITIAL).stream().count() == 0) {
			
			
			logger.info("Starting.....Bid for the group" + group.getGroupName() + "with" + "Draw number:"
					+ draw.getDrawNumber() + "For which intial bid is:" + amount);
			
			
			Bid StartBid = Bid.builder().bidAmount(amount).bidder(member).draw(draw).status(BidStatus.INITIAL).build();
			bidRepository.save(StartBid);
			logger.info("Bid Started");

		} else {
			logger.info("Bid already Started");
			return "Bid is already in progress";
		}
		return "Bid Started";
	}

	@Override
	public Bid closeBidding(Draw draw) {
		
		List<Bid> bidList=bidRepository.findByDrawId(draw);
		Optional<Bid> currentBid=bidList.parallelStream().filter(getPredicateFilter(BidStatus.CURRENT)).findAny();
		logger.info("Closing the bidding for: "+currentBid);
		if(currentBid.isPresent()) {
			currentBid.get().setStatus(BidStatus.FINAL);
			bidRepository.save(currentBid.get());
		}
		else {
			logger.info("need of the lucky system here");
			//get a random member from the available member
			//this.PutBid(currentBid.get().getBidAmount()-1, , draw);
		}
		
		
		return currentBid.get();
		
		
		
	}

}
