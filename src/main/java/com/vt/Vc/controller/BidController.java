package com.vt.Vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vt.Vc.service.BidService;

@Controller
public class BidController {
	
	@Autowired
	BidService bidService;

}
