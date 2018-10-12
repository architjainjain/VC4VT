package com.vt.Vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vt.Vc.service.DrawService;

@Controller
public class DrawController {
	
	
	@Autowired
	private DrawService drawService;

}
