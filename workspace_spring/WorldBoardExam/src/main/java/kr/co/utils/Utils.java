package kr.co.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	
	
	// 폴더 유무 확인후 생성
	public static String makeDir(String uploadPath) {
		// 날짜를 이용해서 디렉토리 생성
		String[] paths = Utils.makeDirName();
		
		File f = new File(uploadPath + paths[2] );	// C://upload/2020/07/09 
		if(f.exists()) {	// 폴더가 있으면 그냥 리턴;
			return paths[2];	// datePath 
		}
		
		for(String path : paths) {		
			// 2020 확인후 07 확인후 09 확인한다...
			File dirPath = new File(uploadPath + path);
			if(! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
		return paths[2];	
		// datePate 를 넘겨주어서 이 안에 업로드 파일을 넣는다.
	}
	
	
	// 날짜를 이용해서 디렉토리 생성...
	public static String[] makeDirName() {
		// c://upload/2020/07/09
		// 날짜 정보를 가지고 와서..
		int[] arr = Utils.getDateInfo();
		
		String yearPath = File.separator + arr[0];	//	/2020
//		String monthPath = File.separator+arr[1];	// 이러면  C://upload/7 이렇게 나온다...
//		String monthPath = yearPath + File.separator + arr[1];		// C://upload/2020/7		arr[1]은 07이 아니고 7
//		String datePate = monthPath + File.separator + arr[2];		// C://upload/2020/7/9
		
		// String.format("%02d", arr[1])
		String monthPath = yearPath + File.separator + String.format("%02d", arr[1]);	// C://upload/2020/07
		String datePath = monthPath + File.separator + String.format("%02d", arr[2]);	// C://upload/2020/07/09
		
		String[] paths = {yearPath, monthPath, datePath};
		
		return paths;
	}
	
	
	
	// 날짜 관리
	public static int[] getDateInfo() {
		// 날짜를 이용한 폴더 관리...
		Calendar cal = Calendar.getInstance(); // new Calendar();이렇게해서 객체를 못 만든다.
				
		int year = cal.get(Calendar.YEAR);		// static 으로 잡혀있어서 객체로 접근해야한다...
		int month = cal.get(Calendar.MONTH)+1;	// 월은..0~11까지만 표현이 되어서 +1 해야한다...
		int date = cal.get(Calendar.DATE);		// day는 통상적으로 요일을 의미한다.
		
		// 3개를 가지고 가야하니...배열로...
		int[] arr = {year, month, date};
		
		return arr;
	} 
	
	public static String saveFile(String originalName, MultipartFile file, String uploadPath)throws Exception {
		String newName = Utils.makeNewName(originalName);	
		// 원본파일이름에 임의의 id를 부여해서 
		// 파일이름이 겹치지않게....만들어야한다.
		
		String datePath = Utils.makeDir(uploadPath);	//dataPath에는 2020/07/09 만 있다..앞에 Path가 없다...
		
		// uploadPath + dataPath  C:/upload/2020/07/09 까지 만들어진것...
		File target = new File(uploadPath + datePath, newName);
		// File target = new File("C:"+File.separator + "upload", Utils.makeNewName(file.getOriginalFilename()));
		
		// 파일 업로드...
		// FileCopyUtils.copy(in, out)	
		FileCopyUtils.copy(file.getBytes(), target);
		
		// 이미지화일 여부 확인
		boolean isimgFile = isImg(originalName);
		
		if (isimgFile) {	// 이미지화일이면 썸네일 만듬
			
			return  makeThumbnail(uploadPath, datePath, newName);
		} else {	// 이미지화일이 아닐 경우. \만 / 로 바꾼다.
			String beforeChangeName = datePath + File.separator + newName;	// 구분자가 역슬러시로 되어있다.
			
			return  beforeChangeName.replace(File.separatorChar, '/');		// 구분자를 슬러시로 바꾸어서 리턴...
		}
		

	}
	
	// 썸네일 만들기
	// 원본 파일을 알아야 썸네일로 만든다.
	public static String makeThumbnail(String uploadPath, 
										String datePath, 
										String newName) throws IOException {	
		// 원본 파일 객체.
		File f1 = new File(uploadPath + datePath, newName);
		
		// 더블 버퍼링 기법...
		BufferedImage sourceImg = ImageIO.read(f1);
		// 원본 이미지를 Scalr.Mode.FIT_EXACT 가로세로 100 크기로 맞추겠다.
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,100);
		
		// 썸네일 파일의 이름은 원본파일이름에서 가져온다... 원본이름에 s_를 붙인다...
		String thumbnailName = uploadPath + datePath + File.separator + "s_" + newName;
		
		File newFile = new File(thumbnailName);		// 썸네일 파일 객체 생성
		
		// 확장자format 가져오기. .toUpperCase();로 확장자를 대문자로... 
		int idx = newName.lastIndexOf(".");
		String format = newName.substring(idx+1).toUpperCase();
		
		// 썸네일이미지(destImg)를 format의 형태로 
		// newFile이라는 이름으로 저장...
		ImageIO.write(destImg, format, newFile);	
			
		// File.separator 는 ""감싸줘있고.
		// File.separatorChar는 ''감싸고 있다...자료형이 다르다
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		// 지금은 C:\\upload\2020\07\09\s_dghkdgjkjgjklfjdlgkkkl_aaa.jpg		역슬러시를 슬러시로 바꾸어주어야한다.
		// C:/upload/2020/07/09/s_dghkdgjkjgjklfjdlgkkkl_aaa.jpg
		
	}
	
	// 썸네일...관련...확장자 이름 으로 이미지 화일 여부 확인
	public static boolean isImg(String filename) {
		int idx = filename.lastIndexOf(".");	// 파일이름에서 제일 마지막  .의 인덱스...
		String format = filename.substring(idx+1);			// idx는 .까지 idx+1 . 다음 확장자
		
		
		
		/* 
		Map<String, MediaType> map = new HashMap<String, MediaType>();			// org.springframework.http.MediaType;;
		map.put("JPG", MediaType.IMAGE_JPEG);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);
		
		// 들어온 파일이름의 확장자을 대문자로...
		// 그리고 확장자가 JPG, JPEG, PNG, GIF 아니면...이미지 파일이 아닌걸로 간주....
		MediaType mType = map.get(format.toUpperCase());
		
		*/
		
		// 위에서 처럼 처리했었는데...
		// 메소드 처리했음....getMediaType()
		MediaType mType = getMediaType(format);
		
		if (mType != null) {
			return true;
		} else {
			return false;
		}
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


	public static MediaType getMediaType(String format) {
		
		Map<String, MediaType> map = new HashMap<String, MediaType>();			// org.springframework.http.MediaType;;
		map.put("JPG", MediaType.IMAGE_JPEG);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);
		
		// 소문자, 대문자를 대문자로 통일하여 값을 뽑는다.
		// 들어온 파일이름의 확장자을 대문자로...
		// 그리고 확장자가 JPG, JPEG, PNG, GIF 아니면...이미지 파일이 아닌걸로 간주....
		MediaType mType = map.get(format.toUpperCase());
		
		return mType;
	}
}
