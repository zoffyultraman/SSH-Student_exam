package com.ite.smvcDemo.controller.grade;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.tidifficulty.TidifficultyVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamGrade;
import com.ite.smvcDemo.service.grade.IGradeService;
import com.ite.smvcDemo.service.stu.IStuService;

@Controller
@RequestMapping(value="/grade")
public class GradeController {
	
	
	@Autowired
	private IGradeService iGradeService;
	
	@Autowired 
	private IStuService iStuService;
	

	
	
	@RequestMapping(value="/Grade",method={RequestMethod.GET,RequestMethod.POST})
	public String GradeList(Model model,ExamGrade examGrade) throws Exception{
//		PagerModel<GradeVO> pagerModel=iGradeService.findAllByPage();
		GradeVO gradeVO=new GradeVO();
		List<GradeVO> list=iGradeService.findByStuId(gradeVO);
//		System.out.println(list.get(1).getExam_stu_name());
//		List<UserVO> userName=iGradeService.findByStuName();
		//从界面表格传来的Id
//		Map<Integer, String>  iStu=this.getStu();
//		System.out.println(iStu);
//		model.addAttribute("iStu",iStu);
//		model.addAttribute("userName",userName);
//		List<Integer> user=iGradeService.findAll();
//		model.addAttribute("user",user);
		model.addAttribute("list",list);
//		model.addAttribute("page",pagerModel);
		return "grade/gradeList";
	}
	

	
	//条件查询方法
	//查询跳转
	@RequestMapping(value="/GradeFind",method=RequestMethod.POST)
	public String GradeFind(String num,Model model,RedirectAttributes redirectAttributes)throws Exception{
		if(num==""){
//			GradeVO gradeVO=new GradeVO();
//			List<GradeVO> pagerModel=iGradeService.findByCondition(num,gradeVO);
//			System.out.println("输入为空");
//			model.addAttribute("list",pagerModel);
			redirectAttributes.addFlashAttribute("message", "输入的查询条件为空，请重新查询 ");
			return "redirect:/grade/Grade";
		}
		else{
		GradeVO gradeVO=new GradeVO();
     	List<GradeVO> pagerModel=iGradeService.findByCondition(num,gradeVO);
//		GradeVO=iGradeService.findByKey(GradeVO);
		model.addAttribute("list",pagerModel);
		return "grade/gradeList";
		}
	}
	
	@RequestMapping(value="/GradePrint/{exam_grade_id}",method=RequestMethod.GET)
	public String GradePrint(@PathVariable String exam_grade_id,Model model)throws Exception{
/*		GradeVO gradeVO=new GradeVO();
		gradeVO.setExamGradeId(new Integer(examGradeId));
		gradeVO=iGradeService.findByKey(gradeVO);
		model.addAttribute("GradeVO",gradeVO);*/
		System.out.println("666");
		
		return "grade/gradeFind";
	}
	
	



}
