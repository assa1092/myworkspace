package kr.cr.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.ManagerDTO;
import kr.co.service.ManagerService;

@Controller
@RequestMapping("manager")
public class ManagerController {
	@Inject
	private ManagerService mService;
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(ManagerDTO dto) {
		mService.insert(dto);
		// 가입하고나서 list화면으로...
		return "redirect:/manager/list"; 
	}
	
	@RequestMapping(value = "/insert")
	public void insert() {
		// 처음 가입화면
	}
	
}
