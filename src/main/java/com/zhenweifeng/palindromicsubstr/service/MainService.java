package com.zhenweifeng.palindromicsubstr.service;

import com.zhenweifeng.palindromicsubstr.entity.Record;

public interface MainService {
	public Record savePalindrome(String term);
	
	public Record findPalindrome(String term);
}
