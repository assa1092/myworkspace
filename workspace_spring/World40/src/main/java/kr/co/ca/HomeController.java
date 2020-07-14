package kr.co.ca;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	@RequestMapping(value = "/intertest2", method = RequestMethod.GET)
	public void intertest2(Model model) {
		model.addAttribute("test", "test");
	}
	
	
	@RequestMapping("/intertest1")
	public void intertest1() {
		System.out.println("<<<<<<<<<<<<<<<  intertest1   >>>>>>>>>>>>>");
	}
	
	
	// 데이터 바인딩....
	// 1. model 객체에 바인딩
	// 2. RedirectAttributes 로 보내고...
	// 3. @ModelAttribute 로 받는다.
	
	
	@RequestMapping("test5")
	public void test5(@ModelAttribute("str2") String mm) {
		System.out.println(mm);
		// test4에서 RedirectAttributes 로 보낸 who를 출력한다....
	}
	
	
	@RequestMapping("test4")
	public String test4(RedirectAttributes rtts) {
		
		// redirect 보내면 주소창에 보내는 값이 보이는데...
		// RedirectAttributes 객체를 이용하면 값이 보이지 않으면서
		// redirect 방식으로 전송 가능하다... 
		
		rtts.addFlashAttribute("str2", "who");
		return "redirect:/test5";
	}
	// redirect 로 전송할때..... 
	// 주소창에 보이게 하고 싶을경우....model 객체이용...
	// 주소창에 안 보이게 하고 싶을경우....RedirectAttributes 객체 이용...
	@RequestMapping("test2")
	public String test2(Model model) {
		
		model.addAttribute("str1", "what");		// redirect로 보내면 주소창에 그래도 보임....
		
		return "redirect:/test3";
	}
	
	
	@RequestMapping("test1")
	public String test1(Model model) {
		model.addAttribute("msg", "==========================");
		return "test1";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
