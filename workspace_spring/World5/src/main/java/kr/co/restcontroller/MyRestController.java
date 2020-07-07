package kr.co.restcontroller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.ReplyVO;
import kr.co.service.ReplyService;

@RestController
public class MyRestController {
	
	@Inject
	private ReplyService rService;
	
	
	@RequestMapping(value = "/replies", method = RequestMethod.DELETE)
	public String delete(@RequestBody ReplyVO vo ) {
		
		int i = rService.delete(vo.getRno());
		if(i==1) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value = "/replies/{rno}", method = RequestMethod.PUT)
	public String update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo) {
		// 넘겨받은 rno를 vo에 값을 넣어주어야한다..
		// ajax에서 넘겨줄때....rno 같이 넘겨주면 그냥 바로 쓸 수있다...
		vo.setRno(rno);
		int i = rService.update(vo);
		
		if(i==1) {
			return "success";
		} 		
		return "fail";
	}
	
	// /replies/all/{bno} 
	@RequestMapping(value = "/replies/all/{bno}", method = RequestMethod.GET)
	public List<ReplyVO> list(@PathVariable("bno") int bno){
		List<ReplyVO> list = rService.list(bno);
		
		return list;
	}
	
	@RequestMapping(value = "/replies", method = RequestMethod.POST)
	public String insert(@RequestBody ReplyVO vo) {
		int i = rService.insert(vo);		// 성공하면 1, 실패하면 0
		if (i==1) {
			return "success";
		} else {
			return "fail";
		}
	}
}
