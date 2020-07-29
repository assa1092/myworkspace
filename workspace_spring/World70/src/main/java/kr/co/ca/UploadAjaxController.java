package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.service.BoardService;
import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	
	// 보통은 프로젝트 안에 /src/main/webapp/resources/upload 이렇게 만든다.
	private String uploadPath = "C:" + File.separator+"upload";
	
	@Inject
	private BoardService bService;
	
	@ResponseBody
	@RequestMapping(value = "/getAttach/{bno}", method = RequestMethod.GET)
	public List<String> getAttach(@PathVariable("bno") Integer bno){
		return bService.getAttach(bno);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile",method = RequestMethod.POST)
	public String deletefile(String filename) {
		
		// 시스템의 파일이름을 원래 이름으로 만들어야
		// /로 되어있는 것을 \로 변경
		filename.replace('/', File.separatorChar);		
		
		 
		// 이미지 파일이면 썸네일 파일까지 찾아서 지워야 하므로
		// 확장자를 알아내서 그 확장자로 파일 타입을 알아와야한다.
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx+1);
		MediaType mType = Utils.getMediaType(format);
		
		// mType != null => 이미지 파일이면...
		if (mType != null) {
			// 원래 이름 찾아오기
			String pre = filename.substring(0,12);
			String suf = filename.substring(14);
			
			String oriname = pre+suf;
			
			File oriFile = new File(uploadPath + oriname);
			oriFile.delete();
		}
		
		
		File f = new File(uploadPath + filename);
		f.delete();
//		String thname = filename.replace("s_", "");
//		File tf = new File(uploadPath + thname);
//		tf.delete();
		
		bService.deleteAttachByFileName(filename);
		
		
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayfile",method = RequestMethod.GET)
	// header 정보를 조작해야하기때문에.. 반환형이 ResponseEntity<byte[]>
	public ResponseEntity<byte[]> displayfile(String filename){
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			int idx = filename.lastIndexOf(".");
			//화일 이름 잘라내기
			String format = filename.substring(idx+1);
			//getMediaType 이미지 화일 여부 확인, 화일 확장자 확인.
			MediaType mType = Utils.getMediaType(format);	
			
			HttpHeaders headers = new HttpHeaders();
			
			// 파일객체가 아닌 문자열로 넣었다...
			// 파일객체를 만들어서 넣어도 됨...
			in = new FileInputStream(uploadPath+filename);		
			
			
			// header에 minetype지정
			if(mType != null) {		// 이미지 화일이면   headers에 mType 넣어주기... 
				headers.setContentType(mType);
			} else {	// 이미지 화일이 아니면 다운로드 되게...
				 idx = filename.indexOf("_");		
				 // uuid를 제거하기
				 String originalName = filename.substring(idx+1);	// +1 을 안하면 _originalName 이 나온다...
				 
				// MediaType.APPLICATION_OCTET_STREAM 다운로드를 하게함...
				// 다운로드를 가능하게 해주는 mine type
				 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				 
				// filename= "" 안에 들어가야하기 때문에... \" 를 붙여줘야한다.
				// \" 데이터로서 "를 넣고싶을때....역슬러시" 붙인다.
				 headers.add("Content-Disposition",
						 		"attachment;filename=\"" + 					
				 new String(originalName.getBytes("UTF-8"),"ISO-8859-1"));	
				 // 브라우져가 사용하는 인코딩 방식으로 바꾸어 주어야한다.
				 // originalName.getBytes("UTF-8"),"ISO-8859-1"
			}
			// 썸네일이 가지고 있는 바이트 정보, 헤더 정보, 통신상태코드
			// img src에 소스를 넣어줌
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in) , headers, HttpStatus.OK );
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			// 실패했을때 통신상태 코드를 날려주겠다...
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return entity;
	}
	
	
	
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
