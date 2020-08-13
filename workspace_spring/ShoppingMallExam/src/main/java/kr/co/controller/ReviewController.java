package kr.co.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {
	
	@Inject
	private ReviewService reviewService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void reviewIndex() {
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void reviewMain() {
	}

}
