package com.vt.Vc.service;

import org.springframework.stereotype.Service;

import com.vt.Vc.model.Group;

@Service
public interface DrawService {
	
	public void StartDraw(Group group);
	
	public void CompleteDraw(Group group);
	

}
