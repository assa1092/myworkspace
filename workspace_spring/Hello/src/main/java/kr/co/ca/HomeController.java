package kr.co.ca;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// MVC 핸들러...
	@RequestMapping(value ="/insert", method = RequestMethod.GET)
	public String insert(Model model, String name){
		
		name = toKor(name);
		
		model.addAttribute("name",name);
				
		return "insert";		// web-inf/view/insert.jsp 로 이동...
	}
	
	private String toKor(String name) {
		
		try {
			return new String(name.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list() {		
			// return값이 없으면 기본적으로 핸들러 이름따라서 list.jsp로 넘어간다...
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
				
		model.addAttribute("serverTime", "안녕하세요." );
		
		return "home";
	}
	
}
