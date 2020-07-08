package kr.co.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	public static String saveFile(String originalName, MultipartFile file)throws Exception {
		String newName = Utils.makeNewName(originalName);	
		// 원본파일이름에 임의의 id를 부여해서 
		// 파일이름이 겹치지않게....만들어야한다.
		
		File target = new File("C:"+File.separator + "upload", newName);
		// File target = new File("C:"+File.separator + "upload", Utils.makeNewName(file.getOriginalFilename()));
		// FileCopyUtils.copy(in, out)	
		FileCopyUtils.copy(file.getBytes(), target);
		
		return newName;
	}
	
	
	// 원본파일이름에 임의의 id를 부여해서 파일이름이 겹치지않게....만들어야한다.
	public static String makeNewName(String originalName) {
		UUID uid = UUID.randomUUID();	//파일 이름이 겹치지 않게 랜덤으로 이름 부여... 
		
		String newName = uid.toString()+"_"+originalName;	//	xxxx_originalName
		
		return newName;
	}
	
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
