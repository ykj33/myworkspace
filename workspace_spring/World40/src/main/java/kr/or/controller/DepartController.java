package kr.or.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DepartService dService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(DepartDTO dto) {
		dService.insert(dto);
		return "redirect:/depart/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "depart/insert";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<DepartDTO> list = dService.list();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/read/{did}", method = RequestMethod.GET)
	public String read(@PathVariable("did") String did, Model model) {
		DepartDTO read = dService.read(did);
		model.addAttribute("read", read);
		// 아이디를 뒤에 붙여주지 않아도 넘겨주는 값에 따라서 출력해준다.
		return "/depart/read";
	}

	@RequestMapping(value = "/update/{did}", method = RequestMethod.GET)
	public String updateui(@PathVariable("did") String did, Model model) {
		DepartDTO dto = dService.updateui(did);
		model.addAttribute("dto", dto);
		return "depart/update";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(DepartDTO dto) {
		dService.update(dto);
		return "redirect:/depart/list";
	}
	
	@RequestMapping(value="/delete/{did}", method = RequestMethod.GET)
	public String delete(@PathVariable("did") String did) {
		dService.delete(did);
		return "redirect:/depart/list";
	}
}
