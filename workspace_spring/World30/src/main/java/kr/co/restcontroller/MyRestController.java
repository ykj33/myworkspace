package kr.co.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.ReplyVO;
import kr.co.service.ReplyService;

@RestController
public class MyRestController {

	@Autowired
	private ReplyService rService;

	@RequestMapping(value = "/replies", method = RequestMethod.POST)
	public String insert(@RequestBody ReplyVO vo) {
		// 성공하면 1, 실패하면 0
		int i = rService.insert(vo);
		if (i == 1) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping(value = "/replies/all/{bno}", method = RequestMethod.GET)
	public List<ReplyVO> list(@PathVariable("bno") int bno) {
		List<ReplyVO> list = rService.list(bno);
		return list;
	}

	@RequestMapping(value = "/replies/{rno}", method = RequestMethod.PUT)
	public String update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo) {
		// 받아온 rno값을 세팅해주어야 한다.
		vo.setRno(rno);
		int i = rService.update(vo);
		if (i == 1) {
			return "success";
		}
		return "fail";

	}
	
	@RequestMapping(value = "/replies", method = RequestMethod.DELETE)
	public String delete(@RequestBody ReplyVO vo) {
		// 에러 발생시 vo에서 rno를 받는다.
		int i = rService.delete(vo.getRno());
		if (i == 1) {
			return "success";
		}
		return "fail";
	}
}
