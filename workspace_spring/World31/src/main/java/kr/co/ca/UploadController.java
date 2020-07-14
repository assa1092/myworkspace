package kr.co.ca;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import kr.co.utils.Utils;



@Controller
public class UploadController {
	
	private String uploadPath = "C:" + File.separator + "upload";
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request, Model model) throws Exception{
		// <input type="file" name="file">
		// uploadform.jsp에서 form 태그의 이름을 file로 했음.
		// getFile을 통해 파일을 받는다.
		MultipartFile file = request.getFile("file");	
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
		// 한글이 깨져서 나오면 web.xml에서 filter로 입력해야한다.
		
		String originalName =file.getOriginalFilename();
		
		// 원본 파일이름과 파일을 가지고가서 
		// 원본파일이름에 임의의 id를 부여해서 파일이름이 겹치지않게
		// 새로 만들어서 가지고 온다.
		String fileName = Utils.saveFile(originalName, file, uploadPath);
		
		// 다시 jsp파일에 값을 넘겨준다.
		model.addAttribute("fileName", fileName);
		
		// 자주 쓰니까...메서드 처리한다...
		// kr.co.utils/Utils.java 안에 메서드 만듬...
//		String newName = Utils.makeNewName(originalName);	//// 원본파일이름에 임의의 id를 부여해서 파일이름이 겹치지않게....만들어야한다.
//		
//		File target = new File("C:"+File.separator + "upload", newName);
//		// File target = new File("C:"+File.separator + "upload", Utils.makeNewName(file.getOriginalFilename()));
//		// FileCopyUtils.copy(in, out)	
//		FileCopyUtils.copy(file.getBytes(), target);
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public void uploadform() {
		
	}

}
