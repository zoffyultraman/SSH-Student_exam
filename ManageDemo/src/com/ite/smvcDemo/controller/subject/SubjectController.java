package com.ite.smvcDemo.controller.subject;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamSubject;
import com.ite.smvcDemo.service.subject.ISubjectSerivce;

@Controller
@RequestMapping(value="/subject")
public class SubjectController {
    
	@Autowired
	private ISubjectSerivce iSubjectSerivce;

	//教师查看要考的科目
	@RequestMapping(value="/Subject", method= {RequestMethod.GET , RequestMethod.POST})
	public String SubjectList(Model model,ExamStu examStum){
//		System.out.println("1");
		PagerModel<SubjectVO> page = iSubjectSerivce.findAllByPage();
//		System.out.println("2");
		model.addAttribute("page",page);
		return "subject/subjectList";
	}
	
	@RequestMapping(value="/subjectFlag",method= RequestMethod.POST)
	public void SubjectFlag(HttpServletRequest request,HttpServletResponse res) throws IOException{
		Integer flag=Integer.parseInt(request.getParameter("flag"));
		Integer TgTagg=Integer.parseInt(request.getParameter("TgTagg"));
		System.out.println(flag);
		SubjectVO subjectVO=new SubjectVO();
//		res.getWriter().write("668");
		subjectVO.setExamsubjectid(TgTagg);
		
		subjectVO=iSubjectSerivce.findByKey(subjectVO);
		
		subjectVO.setExamsubjectflag(flag);
		subjectVO.setExamsubjectdone(flag);
		ExamSubject examSubject=new ExamSubject();
		
		BeanUtils.copyProperties(subjectVO, examSubject);
		iSubjectSerivce.update(examSubject);
     		
	}
	


}
