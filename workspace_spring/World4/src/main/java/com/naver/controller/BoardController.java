package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Inject
	private BoardService bService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<BoardVO> list = bService.list();
		model.addAttribute("list", list);
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
}
