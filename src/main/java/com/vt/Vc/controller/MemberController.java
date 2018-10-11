package com.vt.Vc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vt.Vc.model.Member;
import com.vt.Vc.repository.GroupRepository;
import com.vt.Vc.repository.MemberRepository;
import com.vt.Vc.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	MemberRepository memberreposritory;
	
	@Autowired
	GroupRepository grouprepository;
	
	@GetMapping(value="/member")
	public String getAllMembers(Model model) {
		
		
		model.addAttribute("members", memberservice.getAllMembers());
		return "listmembers";
		
	}
	
	@RequestMapping("/")  
    public String index(){
        return"index";  
    }  
	
	@RequestMapping("/member/add")  
    public String addMember(){  
        return"addmember";  
    } 
	
	@RequestMapping("/member/delete")  
    public String deleteMember(){  
        return "deletemember";  
    }
	
	
	@GetMapping(value="/member/{id}")
	public String getMember(@PathVariable Long id, Model model) {
		Optional<Member> member=memberservice.getMemberDetails(id);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
			
		}
		return "memberProfile";
		 
	}
	

}
