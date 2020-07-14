package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Inject
	private BoardService bService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model, String curPage) {

		// 파라미터로 현재 페이지를 받고 그것을 적용해준다. 파라미터의 값이 null이라면 1페이지와 같다.
		int page = -1;
		if (curPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(curPage);
		}

		// 많은 정보들을 제네릭으로 받고, 현재 페이지도 넣어준다.
		PageTO<BoardVO> to = new PageTO<BoardVO>(page);

		// Page의 정보를 모두 담고 있는 list로 받는다.
		to = bService.list(to);
		model.addAttribute("to", to);
		// 기존에 사용했던 JSP의 EL을 활용하기 위해 to에서 리스트를 가져와 같은 이름으로 바인딩해준다.
		model.addAttribute("list", to.getList());
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		bService.insert(vo);
		return "redirect:/board/list";
	}

	// 입력 화면이 먼저 있어야 한다.
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {

	}

	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, Model model) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo", vo);
		return "/board/read";
	}

	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(Model model, @PathVariable("bno") int bno) {
		BoardVO vo = bService.updateUI(bno);
		
		model.addAttribute("vo", vo);
		return "/board/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		bService.update(vo);
		return "redirect:/board/read/" + vo.getBno();
	}

	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
	public String delete(@PathVariable("bno") int bno) {
		bService.delete(bno);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/searchlist", method = RequestMethod.GET)
	// 검색 타입과 검색어를 다 받아야 한다.
	public String searchlist(Model model, String searchType, String keyword) {
		List<BoardVO> list = bService.searchlist(searchType, keyword);
		model.addAttribute("list", list);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		return "board/searchlist";
	}
	@RequestMapping(value = "/sread/{bno}", method = RequestMethod.GET)
	public String sread(@PathVariable("bno") int bno, Model model) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo", vo);
		return "/board/sread";
	}
}
