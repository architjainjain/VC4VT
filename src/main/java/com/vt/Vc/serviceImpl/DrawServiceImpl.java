package com.vt.Vc.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.enumerate.DrawStatus;
import com.vt.Vc.model.Bid;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.DrawRepository;
import com.vt.Vc.service.BidService;
import com.vt.Vc.service.DrawService;

@Service
public class DrawServiceImpl implements DrawService {

	@Autowired
	private DrawRepository drawRepository;

	@Autowired
	private BidService bidService;

	final static Logger logger = LoggerFactory.getLogger(DrawServiceImpl.class);

	private Predicate<Draw> getDrawStatusFilter(DrawStatus status) {
		Predicate<Draw> filter = (Draw d) -> {
			return d.getStatus().equals(status);
		};

		return filter;
	}

	@Override
	public Draw StartDraw(Group group, double initialamount) {

		List<Draw> DrawList = drawRepository.findDrawByGroup(group);
		Optional<Draw> runningDraw = DrawList.parallelStream().filter(getDrawStatusFilter(DrawStatus.RUNNING))
				.findAny();
		if (!runningDraw.isPresent()) {
			logger.info("No Draw is running...starting a new draw");
			Draw newDraw = Draw.builder().drawNumber(group.getNumberofDrawDone() + 1).group(group).startAmount(initialamount)
					.status(DrawStatus.RUNNING).build();
			drawRepository.save(newDraw);
			bidService.StartBid(newDraw.getStartAmount(), null, group, newDraw);
			runningDraw = Optional.of(newDraw);

		} else {
			logger.info("Draw Already running: " + runningDraw.get());
		}

		return runningDraw.get();
	}

	@Override
	public Draw CompleteDraw(Group group) {
		List<Draw> DrawList = drawRepository.findDrawByGroup(group);
		Optional<Draw> runningDraw = DrawList.parallelStream().filter(getDrawStatusFilter(DrawStatus.RUNNING))
				.findAny();
		Draw currentDraw=null;
		if (runningDraw.isPresent()) {
				Bid currentBid=bidService.closeBidding(runningDraw.get());
				currentDraw=currentBid.getDraw();
				currentDraw.setEndAmount(currentBid.getBidAmount());
				currentDraw.setMember(currentBid.getBidder());
				currentDraw.setStatus(DrawStatus.COMPLETED);
				drawRepository.save(currentDraw);
		} else {
			logger.info("No draw is running to complete");
		}

		return currentDraw;
	}

	@Override
	public void putBid(Draw draw, Member member, double amount) {
		bidService.PutBid(amount, member, draw);
		
	}

	@Override
	public Draw getCurrentDraw(Group group) {
		List<Draw> DrawList = drawRepository.findDrawByGroup(group);
		Optional<Draw> runningDraw = DrawList.parallelStream().filter(getDrawStatusFilter(DrawStatus.RUNNING))
				.findAny();
		return runningDraw.get();
	}

}
