package kr.or.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.DepartDTO;
import kr.co.service.DepartService;

@Controller
@RequestMapping("depart")
public class DepartController {
	@Inject
	private DepartService dService;
	
	@RequestMapping(value = "/delete/{did}", method = RequestMethod.GET)
	public String delete(@PathVariable("did") String did) {
		dService.delete(did);
		
		return "redirect:/depart/list";
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(DepartDTO dto) {
		dService.update(dto);
		
		return "redirect:/depart/list";
	}
	
	@RequestMapping(value = "/update/{did}", method = RequestMethod.GET)
	public String updateui(@PathVariable("did") String did, Model model) {
		DepartDTO dto = dService.updateui(did);
		
		model.addAttribute("dto", dto);
		return "depart/update";
	}
	
	// 가져온값 did  그값을 읽는것...@PathVariable("did")
	@RequestMapping(value="/read/{did}", method = RequestMethod.GET)
	public String read(@PathVariable("did") String did, Model model) {
		DepartDTO dto = dService.read(did);
		
		model.addAttribute("dto", dto);
		return "depart/read";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(Model model) {	// 일단은 model 로 매개변수를 받아놓고 필요하면 써도 된다. 
		List<DepartDTO> list = dService.list();
		
		model.addAttribute("list",list);
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(DepartDTO dto) {
		
		dService.insert(dto);
		
		return "redirect:/depart/list";
	}
	
	@RequestMapping("/insert") // 이러면 GET 방식....
	public void  insert() {
		
	}
	
}
