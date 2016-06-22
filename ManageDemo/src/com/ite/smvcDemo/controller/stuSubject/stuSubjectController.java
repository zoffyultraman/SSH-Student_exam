package com.ite.smvcDemo.controller.stuSubject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamStudentSubject;
import com.ite.smvcDemo.service.subject.ISubjectSerivce;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/stuSubject")
public class stuSubjectController {
	
	@Autowired
	private ISubjectSerivce iSubjectSerivce;
	
	
	//学生登录查询自己的科目列表
	@RequestMapping(value="/StuSubject", method= {RequestMethod.GET , RequestMethod.POST})
	public String StuSubjectList(Model model,ExamStu examStum,HttpSession session,HttpServletResponse res){
		
	   UserVO stuVO=new UserVO();
	   stuVO=(UserVO) session.getAttribute("teacher");
	   System.out.println(stuVO.getExamStuNumber());
	   String Number=stuVO.getExamStuNumber();
	   
		return "stuSubject/stuSubjectList";
	}
	
	@SuppressWarnings({"unused","unchecked"})
	@RequestMapping(value="/StuGradeFind",method=RequestMethod.GET)
	public String StuGradeFind(/*String findnumber,*/HttpSession session,Model model,HttpServletRequest request,HttpServletResponse res){
		UserVO stuVO=new UserVO();
		stuVO=(UserVO)session.getAttribute("teacher");
		String Number=stuVO.getExamStuNumber();
		
		List<UserVO> list=iSubjectSerivce.findByStuSubject(Number, stuVO);
		
		
		
		List<UserVO>  Resource=(List<UserVO>) session.getAttribute("Resource");
		
		model.addAttribute("ResourceStu",Resource);
		
		
		List<UserVO>  ResourceTea=(List<UserVO>) session.getAttribute("Resource");
		model.addAttribute("ResourceTea",ResourceTea);
		System.out.println(ResourceTea.get(0).getResouceName());
//		System.out.println(Resource.get(0).getResouceName());
		
		
		
		
		
		session.setAttribute("list", list);
		String stuName=list.get(0).getExam_stu_name();
		session.setAttribute("sName", stuName);
		request.setAttribute("stuName", stuName);
		Integer stuDone=list.get(0).getExam_stu_done();
		request.setAttribute("stuDone", stuDone);
			 
		String bbb=stuVO.getExam_stu_name();
		model.addAttribute("list",list);
		return "stuSubject/stuSubjectList";
	}
	
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value="/ExamTest",method=RequestMethod.POST)
	public void ReturnSubjectId(HttpSession session,HttpServletRequest req,PrintWriter writer,HttpServletResponse response) throws IOException{
		int subjectId=Integer.parseInt(req.getParameter("subjectId"));
		List<ExamStuTiVO> examStuTiTest=(List<ExamStuTiVO>) session.getAttribute("list");
		String Name=examStuTiTest.get(subjectId).getExam_subject_name();
		JSONObject jObject=new JSONObject();
		jObject.put("Name", Name);
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jObject.toString());
		
	}

}
