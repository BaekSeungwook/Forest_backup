package kosta.forrest.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ForStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.forrest.model.board.dto.ForestDTO;
import kosta.forrest.model.board.service.ForestService;

@Controller
@RequestMapping("/forest")
public class ForestController {

	@Autowired
	private ForestService forestService;
	
	private String path="C:\\Edu\\springFileSave";
	
	@RequestMapping("/list")
	public ModelAndView selectAll() {
		System.out.println("ForestController�� selectAllȣ��");
		ModelAndView mv = new ModelAndView();
		List<ForestDTO> list = forestService.selectAll();
		mv.addObject("list", list);
		mv.setViewName("forest/list");
		
		return mv;
	}
	
	//restful��� �̿�
	@RequestMapping("/read/{forestNo}")
	public ModelAndView selectByForestNo(@PathVariable int forestNo) {
		System.out.println("ForestController�� selectByForestNoȣ�� = " + forestNo);
		ForestDTO dbDTO = forestService.selectByForestNo(forestNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dbDTO);
		mv.setViewName("forest/read");
		return mv;
	}
	
	@RequestMapping("/write")
	public void writeForm() {}
	
	@RequestMapping("/insert")
	public String insert(ForestDTO forestDTO) throws IllegalStateException, IOException {
		System.out.println("ForestController�� insertȣ��");
		MultipartFile file = forestDTO.getForestFile();
		System.out.println("size"+file.getSize());
		if(file.getSize() > 0) {//������ ÷�εǾ��ٸ�..
			String fileName = file.getOriginalFilename();
			long fileSize=file.getSize();
			
			forestDTO.setForestFilename(fileName);
			
			//��������
			file.transferTo(new File(path+"/"+fileName));
		}
		forestService.insert(forestDTO);
		
		return "redirect:list";
	}
	
//	@RequestMapping("/delete/{forestNo}")
//	public String delete(@PathVariable int forestNo) {
//		System.out.println("ForestController�� deleteȣ��");
//		//int forestNum = Integer.parseInt(forestNo);
//		forestService.delete(forestNo);	
//		return "redirect:list";
//	}
	
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(int forestNo) {	
		System.out.println("ForestController�� selectByForestNoȣ�� = " + forestNo);
		ForestDTO dbDTO = forestService.selectByForestNo(forestNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("forestDTO", dbDTO);
		mv.setViewName("forest/update");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(ForestDTO forestDTO) {
		forestService.update(forestDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("forestDTO", forestDTO);
		mv.setViewName("redirect:read/"+forestDTO.getForestNo());
		return mv;
	}
	
	@RequestMapping("/delete")
	public String delete(int forestNo) {
		System.out.println("ForestController�� deleteȣ��");
		forestService.delete(forestNo);	
		return "redirect:list";
	}
}
