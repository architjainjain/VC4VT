package com.vt.Vc;

import java.sql.Time;
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
			Member m1=new Member("A", "1234", null, null, null, MemberStatus.NEW);
			Member m2=new Member("b", "12345", null, null, null, MemberStatus.NEW);
			Member m3=new Member( "Ac", "12346", null, null, null, MemberStatus.NEW);
			Member m4=new Member( "Ad", "12344", null, null, null, MemberStatus.NEW);
			Member m5=new Member( "Ae", "12341", null, null, null, MemberStatus.NEW);
			Member m6=new Member( "Af", "12342", null, null, null, MemberStatus.NEW);
			Member m7=new Member( "Ag", "12343", null, null, null, MemberStatus.NEW);
			Member m8=new Member( "Ah", "12374", null, null, null, MemberStatus.NEW);
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
		Group g1=new Group("firstGroup", "sample group", 1, null, 12, null, 0, groupStatus.NEW, ms, null);
		grouprepo.save(g1);
		
		//ms.clear();
		ms.add(m7);
		ms.add(m6);
		Group g2=new Group("secondGroup", "sample group 2", 2, null, 12, null, 0, groupStatus.NEW, ms, null);
		grouprepo.save(g2);
		
		/*DrawId*/
		Draw d1= Draw.builder().drawDate(null).group(g1).member(m3).drawNumber(1).build();
		drawrepo.save(d1);
		
		
		/* bidding */
		Bid b1=Bid.builder().bidAmount(99).bidder(m3).draw(d1).status(BidStatus.INITIAL).build();
		bidrepo.save(b1);
		
		bidService.StartBid(100, m3, g1, d1);
		
		bidrepo.findAll();
		
		
		
	}
	
	
}
