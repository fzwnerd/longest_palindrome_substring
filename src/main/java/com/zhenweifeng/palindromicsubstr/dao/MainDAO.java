package com.zhenweifeng.palindromicsubstr.dao;

import com.zhenweifeng.palindromicsubstr.entity.Record;

public interface MainDAO {
	public Record savePalindrome(String term);
	
	public Record findPalindrome(String term);
}
