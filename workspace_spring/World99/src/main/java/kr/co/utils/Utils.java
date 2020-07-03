package kr.co.utils;

import java.io.UnsupportedEncodingException;

public class Utils {
	
	// 어디서든 써야 하므로 static로 선언...
	public static String toKor(String msg) {
		
		try {
			// 한글 인코딩....
			return new String (msg.getBytes("8859_1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
