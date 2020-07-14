package kr.co.ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.MemberDTO;

@RestController		//Ajax 전문 컨트롤러... 
public class RestTestController {
	
	@RequestMapping(value = "/rt4", method = RequestMethod.POST)
	public String rt4(@RequestBody Map<String, Object> map) {
		
		List<Map<String, Object>> list 
			= (List<Map<String, Object>>) map.get("listStr");
			
		for(Map<String, Object> m : list) {	
			System.out.println("=====================");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println("=====================");
		}
		
		return "world";
	}
	
	
	
	
	
	@RequestMapping(value = "/rt3", method = RequestMethod.POST)
	public String rt3(@RequestBody Map<String, Object> map) {
		List<Map<String, Object>> list=  (List<Map<String, Object>>) map.get("test4");
		// [{id=m001, name=kim, age=11}, {id=m002, name=lee, age=44}, {id=m003, name=park, age=55}]
		// [] 안에꺼는 List, {} 안에꺼는 Map...
		// list 안에꺼 풀면...map 안에 내용 나옴...
		
		for(Map<String, Object> m : list){
			System.out.println("=====================");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println("=====================");
		}
		return "hello";
	}
	
	@RequestMapping(value = "/rt2", method = RequestMethod.POST)
	public Map<String , Object> rt2(@RequestBody Map<String , Object> map) {	// 값의 형태가 여러가지면 Map으로 받는다.
		System.out.println(map.get("test1"));
		System.out.println(map.get("test2"));
		return map;
	}
	
	// @RequestBody 매개변수로 넣어주어서 선언 안해줘도 된다...
	// @RestController 가 Ajax 전문 컨트롤러라 @RequestBody 안써도 됨.
	@RequestMapping(value="/rt1", method=RequestMethod.POST)
	public String rt1(@RequestBody String test1) {	// @RequestBody를 매개변수로 쓴다. 
		System.out.println(test1);
		
		return "ok";
	}
}
