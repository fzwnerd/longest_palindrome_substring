package com.zhenweifeng.palindromicsubstr.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhenweifeng.palindromicsubstr.entity.Record;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	Record findByInput(Session session, String term) {

		Query<Record> query = session.createQuery("from Record "
				+ "where input=:inputStr", Record.class);
		query.setParameter("inputStr", term);
		List<Record> records = query.getResultList();
		if (records.isEmpty()) {
			return null;
		}
		return records.get(0);
	}

	@Override
	public Record savePalindrome(String term) {
		Session session = entityManager.unwrap(Session.class);
		
		// if already inserted before, no need to do another insertion
		Record record = findByInput(session, term);
		if (record != null) return record;
		
		record = new Record(term, longestPalindrome(term));
		session.save(record);
		return record;
	}

	@Override
	public Record findPalindrome(String term) {
		Session session = entityManager.unwrap(Session.class);
		return findByInput(session, term);
	}
	
	String longestPalindrome(String s) {
        // starting from each index in the string
        // expand around it and find the longest palindrome
        
        if (s == null || s.isEmpty()) return "";
        
        // [current longest length, left index, right index]
        int[] record = {0, 0, 0};
        
        for (int i = 0; i < s.length(); i++) {
            int[] res1 =  findPalin(s, i, i);
            if (res1[0] > record[0]) record = res1;
            int[] res2 = findPalin(s, i, i + 1);
            if (res2[0] > record[0]) record = res2;
        }
        
        return s.substring(record[1], record[2] + 1);
    }
    
    int[] findPalin(String s, int left, int right) {
        if (left > right || right >= s.length()) 
            return new int[]{0, 0, 0};
        
        int len = 0;
        
        while (left >= 0 && right < s.length()
              && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }
        
        return new int[]{len, left + 1, right - 1};
    }

}
