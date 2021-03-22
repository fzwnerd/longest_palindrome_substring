package com.zhenweifeng.palindromicsubstr.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String message) {
		super("record not found");
	}
}
