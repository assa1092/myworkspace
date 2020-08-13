package kr.co.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.FaqDTO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaDTO;
import kr.co.service.CustomerService;


@Controller
@RequestMapping("customerservice")


public class CustomerServiceController {
	
	@Inject
	private CustomerService cService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main() {
		
	}
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public void notice() {
		
	}
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public void inquiry() {
		
	}
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public void event() {
		
	}
	@RequestMapping(value = "/winner", method = RequestMethod.GET)
	public void winner() {
		
	}
	////////////////////////////FAQ//////////////////////////////////////////////
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public void faq() {
		
	}
	
	@RequestMapping(value = "/faqinsert", method = RequestMethod.GET)
	public void faqInsert() {
		
	}
	
	@RequestMapping(value = "/faqinsert", method = RequestMethod.POST)
	public String faqInsert(FaqDTO fdto) {
		
		cService.faqInsert(fdto);
		return "redirect:/customerservice/faqlist";
	}
	@RequestMapping(value = "/faqlist", method = RequestMethod.GET)
	public void faqList(Model model, String curPage) {
		int page = -1;
		if(curPage==null) {
			page=1;
		} else {
			page = Integer.parseInt(curPage);
		}
		PageTO<FaqDTO> fto = new PageTO<FaqDTO>(page);
		fto = cService.faqList(fto);
		model.addAttribute("to",fto);
		model.addAttribute("listist",fto.getList());
	}
	@RequestMapping(value = "/faqSearchlist", method = RequestMethod.GET)
	public String faqSearchlist(Model model, String searchType, String keyword) {
		
		List<FaqDTO> flist = cService.faqSearchlist(searchType,keyword);
		model.addAttribute("flist",flist);
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);
		
		return "customerservice/faqserchlist";
	}
	
	@RequestMapping(value = "/faqread", method = RequestMethod.GET)
	public String faqRead(Model model,@PathVariable("faqNo")int faqNo) {
		
		FaqDTO fdto = cService.faqRead(faqNo);
		model.addAttribute("fdto", fdto);
		return "customerservice/faqRead";
	}
	@RequestMapping(value = "/faqupdate", method = RequestMethod.POST)
	public String faqUpdate(FaqDTO fdto) {
		
		cService.faqUpdate(fdto);
		return "redirect:/customerservice/faqread" + fdto.getFaqNo();
	}
	
	@RequestMapping(value = "/faqupdate/{qnaNo}", method = RequestMethod.GET)
	public String faqUpdate(Model model,@PathVariable("faqNo") int faqNo) {
		
		FaqDTO fdto = cService.faqUpdateUI(faqNo);
		model.addAttribute("fdto", fdto);
		
		return "customerservice/faqupdate";
	}
	
	@RequestMapping(value = "/faqdelete/{faqNo}", method = RequestMethod.GET)
	public String faqDelete(@PathVariable("faqNo") int faqNo) {
		cService.faqDelete(faqNo);
		return "redirect:/customerservice/faqlist";
	}
	
	
	////////////////////////////////////Q&A//////////////////////////////////////////
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public void qna() {
		
	}
	
	@RequestMapping(value = "/qnasearchlist")
	public String qnaSearchlist(Model model, String searchType,String keyword) {
		
		
		List<QnaDTO> qlist =cService.qnaSearchlist(searchType,keyword);
		model.addAttribute("qlist",qlist);
		model.addAttribute("searchType",searchType);
		model.addAttribute("keyword",keyword);

		return "customerservice/qnasearchlist";
	}
	
	@RequestMapping(value = "/qnainsert", method = RequestMethod.GET)
	public void qnaInsert() {
		
	}
	@RequestMapping(value = "/qnainsert", method = RequestMethod.POST)
	public String qnaInsert(QnaDTO qdto) {
		cService.qnaInsert(qdto);
		return "redirect:/customerservice/qnalist";
	}
	@RequestMapping(value = "/qnalist", method = RequestMethod.GET)
	public void qnaList(Model model, String curPage) {
		int page = -1;
		if(curPage==null) {
			page=1;
		} else {
			page = Integer.parseInt(curPage);
		}
		PageTO<QnaDTO> qto = new PageTO<QnaDTO>(page);
		qto = cService.qnaList(qto);
		model.addAttribute("to",qto);
		model.addAttribute("listist",qto.getList());
	}
	@RequestMapping(value = "/qnaread/{qnaNo}", method = RequestMethod.GET)
	public String qnaRead(Model model,@PathVariable("qnaNo")int qnaNo) {
		QnaDTO qdto = cService.qnaRead(qnaNo);
		model.addAttribute("qdto", qdto);
		return "customerservice/qnaRead";
	}
	
	@RequestMapping(value = "/qnaupdate", method = RequestMethod.POST)
	public String qnaUpdate(QnaDTO qdto) {
		
		cService.qnaUpdate(qdto);
		return "redirect:/customerservice/qnaread" + qdto.getQnaNo();
	}
	
	@RequestMapping(value = "/qnaupdate/{qnaNo}", method = RequestMethod.GET)
	public String qnaUpdate(Model model,@PathVariable("qnaNo") int qnaNo) {
		
		QnaDTO qdto = cService.qnaUpdateUI(qnaNo);
		model.addAttribute("qdto", qdto);
		
		return "customerservice/qnaupdate";
	}
	
	@RequestMapping(value = "/qnadelete/{qnaNo}", method = RequestMethod.GET)
	public String qnaDelete(@PathVariable("qnaNo") int qnaNo) {
		cService.qnaDelete(qnaNo);
		return "redirect:/customerservice/qnalist";
	}
}

