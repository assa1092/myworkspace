package kr.co.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.FaqDTO;
import kr.co.domain.NoticeDTO;
import kr.co.domain.QnaDTO;
import kr.co.domain.ReviewDTO;
import kr.co.service.ManageService;

@Controller
@RequestMapping("admin")
public class AdminManageController {
	@Inject
	private ManageService manageService;

	@RequestMapping(value = "/manage/inquiryBoardWrite", method = RequestMethod.GET)
	public void adminInquiryBoardWrite() {
	}

	@RequestMapping(value = "/manage/inquiryBoardList", method = RequestMethod.GET)
	public void adminInquiryBoardList(Model model) {
	}

	@RequestMapping(value = "/manage/qnaBoardWrite", method = RequestMethod.GET)
	public void adminQnaBoardWrite() {
	}

	@RequestMapping(value = "/manage/qnaBoardList", method = RequestMethod.GET)
	public void adminQnaBoardList(Model model) {
		List<QnaDTO> qnaDto = new ArrayList<QnaDTO>();
		qnaDto = manageService.qnaBoardList(qnaDto);
		model.addAttribute("qnaDto", qnaDto);
	}

	@RequestMapping(value = "/manage/faqBoardWrite", method = RequestMethod.GET)
	public void adminFaqBoardWrite() {
	}

	@RequestMapping(value = "/manage/faqBoardList", method = RequestMethod.GET)
	public void adminFaqBoardList(Model model) {
		List<FaqDTO> faqDto = new ArrayList<FaqDTO>();
		faqDto = manageService.faqBoardList(faqDto);
		model.addAttribute("faqDto", faqDto);
	}

	@RequestMapping(value = "/manage/noticeBoardWrite", method = RequestMethod.GET)
	public void adminNoticeBoardWrite() {
	}

	@RequestMapping(value = "/manage/noticeBoardList", method = RequestMethod.GET)
	public void adminNoticeBoardList(Model model) {
		List<NoticeDTO> noticeDto = new ArrayList<NoticeDTO>();
		noticeDto = manageService.noticeBoardList(noticeDto);
		model.addAttribute("noticeDto", noticeDto);
	}

	@RequestMapping(value = "/manage/reviewBoardWrite", method = RequestMethod.GET)
	public void adminReviewBoardWrite() {
	}

	@RequestMapping(value = "/manage/reviewBoardList", method = RequestMethod.GET)
	public void adminReviewBoardList(Model model) {
		List<ReviewDTO> reviewDto = new ArrayList<ReviewDTO>();
		reviewDto = manageService.reviewBoardList(reviewDto);
		model.addAttribute("reviewDto", reviewDto);
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void adminMain() {
	}

	@RequestMapping(value = "/manage/boardList", method = RequestMethod.GET)
	public void adminManageIndex() {
	}

}