package kr.co.ca;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.service.BoardService;
import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	
	private String uploadPath = "C:" + File.separator+"upload";
	
	@Inject
	private BoardService bService;
	
	
	@ResponseBody
	@RequestMapping(value = "/uploadajax", 
					method = RequestMethod.POST,
					produces = "text/plain;charset=UTF-8")
	public String uploadajax(MultipartHttpServletRequest request) throws Exception {
		
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String saveFileName = Utils.saveFile(originalName, file, uploadPath);
		
		return saveFileName ;
	}
	
	
	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
		
	}
}
