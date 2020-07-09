package kr.co.ca;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	
	// 보통은 프로젝트 안에 /src/main/webapp/resources/upload 이렇게 만든다.
	private String uploadPath = "C:" + File.separator+"upload";
	
	// RestController 가 아니기 때문에...@ResponseBody 를 붙여야한다.
	@ResponseBody
	@RequestMapping(value = "/uploadajax", 
					method = RequestMethod.POST,
					produces ="text/plain;charset=UTF-8")
	// 한글 깨짐 현상시...produces ="text/plain;charset=UTF-8" 를 붙여주면 괜찬아짐.
	
	public String uploadajax(MultipartHttpServletRequest request) throws Exception {
		
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String saveFileName = Utils.saveFile(originalName, file, uploadPath);
		
		return saveFileName;
	}
	
	
	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
		
	
	
		
	}
}
