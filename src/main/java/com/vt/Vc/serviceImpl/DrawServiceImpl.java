package com.vt.Vc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.Vc.model.Group;
import com.vt.Vc.repository.DrawRepository;
import com.vt.Vc.service.DrawService;

@Service
public class DrawServiceImpl implements DrawService {

	@Autowired
	private DrawRepository drawRepository;
	
	@Override
	public void StartDraw(Group group) {
		
drawRepository.findAll();
	}

	@Override
	public void CompleteDraw(Group group) {
		// TODO Auto-generated method stub

	}

}
