package com.zhenweifeng.palindromicsubstr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhenweifeng.palindromicsubstr.dao.MainDAO;
import com.zhenweifeng.palindromicsubstr.entity.Record;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mainDAO;

	@Override
	@Transactional
	public Record savePalindrome(String term) {
		return mainDAO.savePalindrome(term);
	}

	@Override
	@Transactional
	public Record findPalindrome(String term) {
		return mainDAO.findPalindrome(term);
	}

}
