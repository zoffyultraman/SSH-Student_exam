package com.ite.smvcDemo.controller.stuGrade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.service.grade.IGradeService;

@Controller
@RequestMapping(value="/stuGrade")
public class stuGradeController {

	@Autowired
	private IGradeService iGradeService;
	
	@RequestMapping(value="/stuGradeListS",method=RequestMethod.GET )
	public String StuGrade(Model model,HttpServletRequest request,HttpSession session){
		UserVO stuVO=new UserVO();
		stuVO=(UserVO)session.getAttribute("teacher");
		String number=stuVO.getExamStuNumber();
		System.out.println(number);
		session.setAttribute("number", number);
		GradeVO gradeVO=new GradeVO();
		List<GradeVO> list=iGradeService.findByStuGrade(gradeVO, number);
		model.addAttribute("list", list);
		return "stuGrade/stuGradeList";
	}
	
}
