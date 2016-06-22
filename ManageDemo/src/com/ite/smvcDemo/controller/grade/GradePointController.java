package com.ite.smvcDemo.controller.grade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.service.grade.IGradeService;

@Controller
@RequestMapping(value="/gradePoint")
public class GradePointController {
	
	@Autowired
	private IGradeService iGradeService;

	@RequestMapping(value="/GradePrint",method=RequestMethod.GET)
	public String GradePrint(Model model)throws Exception{
		GradeVO gradeVO=new GradeVO();
		List<GradeVO> list=iGradeService.findByStuId(gradeVO);
		model.addAttribute("list",list);
		return "gradePoint/gradeFind";
	}
	
    @RequestMapping(value="/GradeStuPrint",method=RequestMethod.GET)
	public String StuGrade(Model model,HttpServletRequest request,HttpSession session){
//		System.out.println("16");
		UserVO stuVO=new UserVO();
		stuVO=(UserVO)session.getAttribute("teacher");
		String number=stuVO.getExamStuNumber();
		System.out.println(number);
		GradeVO gradeVO=new GradeVO();
		List<GradeVO> list=iGradeService.findByStuGrade(gradeVO, number);
//		System.out.println(gradeVO.get);
//		String stuName=list.get(0).getExam_stu_name();
//		request.setAttribute("stuName", stuName);
		System.out.println("2016");
		model.addAttribute("list", list);
		return "gradePoint/gradeStuFind";
	}
    
    
    
    
    
}
