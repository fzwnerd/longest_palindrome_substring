package com.zhenweifeng.palindromicsubstr.rest;

import java.io.Console;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhenweifeng.palindromicsubstr.entity.Record;
import com.zhenweifeng.palindromicsubstr.exception.RecordNotFoundException;
import com.zhenweifeng.palindromicsubstr.service.MainService;

@RestController
@RequestMapping("/api/palindrome")
public class MainController {
	
	@Autowired
	private MainService mainService;

	@PostMapping
	public Record savePalindrome(@RequestParam String term) {
		return mainService.savePalindrome(term);
	}
	
	@GetMapping
	public String findPalindrome(@RequestParam String term) {
		Record record = mainService.findPalindrome(term);
		if (record == null) {
			throw new RecordNotFoundException("input not found");
		}
		return record.getAnswer();
	}
}
