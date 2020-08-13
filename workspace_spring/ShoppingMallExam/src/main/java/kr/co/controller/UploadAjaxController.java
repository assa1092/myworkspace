package kr.co.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import kr.co.service.ProductService;
import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {

	@Autowired
	ProductService productService;
	
	private String uploadPath = "C:"+File.separator+"upload";
	
	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {	
	}	
	
	@ResponseBody
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	private String uploadajax(MultipartHttpServletRequest request) throws Exception {
		
		MultipartFile file =  request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String saveFileName = Utils.saveFile(originalName, file, uploadPath);

		return saveFileName;
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename){
		ResponseEntity<byte[]> entity = null;
		
		InputStream	in = null;
	
		try {
			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx+1);
			MediaType mType = Utils.getMediaType(format);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+filename);
			if(mType != null) {
			headers.setContentType(mType);	
			}
			else { 
				idx = filename.indexOf("_");
				String originalName = filename.substring(idx+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""+new String(originalName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
				try {
					if(in != null)	in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public void deletefile(String filename){
		
		filename.replace('/', File.separatorChar);
		
		File f1 = new File(uploadPath+filename);
		if(Utils.isImg(filename)) {
			int idx = filename.indexOf("s_");
			String orgName = filename.substring(0,idx);
			orgName += filename.substring(idx+2);
			File f2 = new File(uploadPath+orgName);
			f2.delete();
		}
		f1.delete();
		productService.deleteAttachByFileName(filename);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAttach/{productNo}", method = RequestMethod.GET )
	public List<String> getAttach(@PathVariable("productNo") Integer productNo){

		return productService.getAttach(productNo);
	}
	
}