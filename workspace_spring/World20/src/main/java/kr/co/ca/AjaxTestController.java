package kr.co.ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberDTO;

@Controller
public class AjaxTestController {

	// ajax 통신을 하는 핸들러라고 표기하기 위해 
	// @ResponseBody 어노테이션이 필요
	@ResponseBody
	@RequestMapping(value = "/at4", method = RequestMethod.POST)
	public List<Map<String, Object>> at4(@RequestParam Map<String, Object> map) throws Exception{	// JSON 으로 데이터 넘겼다.////		System.out.println(map);
		String jsonStr = map.get("listStr").toString();	// map.get("listStr") 은 자료형이 Object이므로 스트링으로..
		
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>> () {		
			
		});
		for(Map<String, Object> m :list) {	// Map의 m
			System.out.println("============================");
			System.out.println(m.get("id"));
			System.out.println(m.get("name"));
			System.out.println(m.get("age"));
			System.out.println("============================");
			
		}
		return list;
	}
//	
//	@RequestMapping(value = "/at4", method = RequestMethod.POST)
//	public void at4(String liststr) {
//		System.out.println(liststr);
//		
//	}
	
	@RequestMapping(value = "/at4", method = RequestMethod.GET)
	public void at4() {
		
	}
		
	@ResponseBody
	@RequestMapping(value = "/at3", method = RequestMethod.POST)
	public MemberDTO at3(MemberDTO dto) {
		return dto;
	}
	
	
	@RequestMapping(value = "/at3", method = RequestMethod.GET)
	public void at3() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/at2", method = RequestMethod.POST)
	public String[] at2(String[] arr) {
		for(String x : arr) {
			System.out.println(x);
		}
		return arr;
	}
	
	@RequestMapping(value = "/at2", method = RequestMethod.GET)
	public void at2() {
		
	}
	
	@ResponseBody		// Ajax 통신을 하는 애구나...하고 정의...
	@RequestMapping(value = "/at1", method = RequestMethod.POST)
	public String at1(String msg) {
		
		return msg + "!!!";			// 입력값에 !!! 더해서 
		
//		@ResponseBody 를 안 붙여주면....msg!!!라는 jsp로 갈려고 함... 그래서 에러...
//		@ResponseBody 를 붙여주어서 Ajax와 통신하는 용도라는것을 알려주어야 함....ㅣ
	}
	
	
	@RequestMapping(value = "/at1", method = RequestMethod.GET)	// ajax test
	public void at1() {
		
	}
	
}
