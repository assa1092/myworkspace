package kr.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.CategoryDTO;
import kr.co.service.ProductService;

@Controller
@RequestMapping("main")
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public void mainIndex2() {
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void mainIndex() {
	}

}
