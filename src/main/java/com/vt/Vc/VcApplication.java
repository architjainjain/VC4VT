package com.vt.Vc;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vt.Vc.enumerate.BidStatus;
import com.vt.Vc.enumerate.DrawStatus;
import com.vt.Vc.enumerate.MemberStatus;
import com.vt.Vc.enumerate.groupStatus;
import com.vt.Vc.model.Bid;
import com.vt.Vc.model.Draw;
import com.vt.Vc.model.Group;
import com.vt.Vc.model.Member;
import com.vt.Vc.repository.BidRepository;
import com.vt.Vc.repository.DrawRepository;
import com.vt.Vc.repository.GroupRepository;
import com.vt.Vc.repository.MemberRepository;
import com.vt.Vc.service.BidService;
import com.vt.Vc.serviceImpl.BidServiceImpl;

@SpringBootApplication
@EntityScan(basePackages="com.vt.Vc.*")
@ComponentScan("com.vt.Vc.*")
@EnableJpaRepositories
public class VcApplication implements CommandLineRunner{

	@Autowired
	MemberRepository memberreposritory;
	
	@Autowired
	GroupRepository grouprepo;
	
	@Autowired
	BidRepository bidrepo;
	
	@Autowired
	DrawRepository drawrepo;
	
	@Autowired
	BidService bidService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(VcApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
			
		List<Member> ls= new ArrayList<>();
			Member m1= Member.builder().memberName("A1").membermobile("1231").memberStatus(MemberStatus.NEW).build();
			Member m2= Member.builder().memberName("A2").membermobile("1232").memberStatus(MemberStatus.NEW).build();
			Member m3= Member.builder().memberName("A3").membermobile("1233").memberStatus(MemberStatus.NEW).build();
			Member m4= Member.builder().memberName("A4").membermobile("1234").memberStatus(MemberStatus.NEW).build();
			Member m5=Member.builder().memberName("A5").membermobile("1235").memberStatus(MemberStatus.NEW).build();
			Member m6=Member.builder().memberName("A6").membermobile("1236").memberStatus(MemberStatus.NEW).build();
			Member m7=Member.builder().memberName("A7").membermobile("1237").memberStatus(MemberStatus.NEW).build();
			Member m8= Member.builder().memberName("A8").membermobile("1238").memberStatus(MemberStatus.NEW).build();
		ls.add(m1);
		ls.add(m2);
		ls.add(m3);
		ls.add(m4);
		ls.add(m5);
		ls.add(m6);
		ls.add(m6);
		ls.add(m7);
		memberreposritory.saveAll(ls);
		
		
		Set<Member> ms= new HashSet<>();
		ms.add(m3);
		ms.add(m4);
		ms.add(m5);
		Group g1= Group.builder().
					groupName("First Group").
					description("Sample 1").
					interesetRate(1).
					groupStartDate(LocalDate.now()).
					groupEndDate(null).
					noOfMembers(12).
					status(groupStatus.NEW).memberslist(ms).build();
					
		grouprepo.save(g1);
		
		//ms.clear();
		ms.add(m7);
		ms.add(m6);
		Group g2=Group.builder().
				groupName("Second Group").
				description("Sample 2").
				interesetRate(2).
				groupStartDate(LocalDate.now()).
				groupEndDate(null).
				noOfMembers(12).
				status(groupStatus.NEW).memberslist(ms).build();
		grouprepo.save(g2);
		
		/*DrawId*/
		Draw d1= Draw.builder().drawDate(LocalDate.now()).group(g1).member(m3).status(DrawStatus.RUNNING).build();
		drawrepo.save(d1);
		
		Draw d2= Draw.builder().drawDate(LocalDate.now()).group(g2).member(m3).status(DrawStatus.RUNNING).build();
		drawrepo.save(d2);
		/* bidding */		
		bidService.StartBid(100, m3, g1, d1);
		
		bidService.StartBid(100, m7, g2, d2);
		
		bidService.StartBid(100, m3, g1, d1);
		
		bidService.PutBid(99, m3, g1, d1);
		bidService.PutBid(98, m3, g1, d1);
		
		bidService.PutBid(90, m7, g2, d2);
		
		bidService.closeBidding(d1);
		
		
		bidService.closeBidding(d2);
		
		bidService.StartBid(100, m6, g1, d1);
		//bidService.PutBid(500, m2, g1, d1);
		
		//bidrepo.findAll();
		
		
		
	}
	
	
}
