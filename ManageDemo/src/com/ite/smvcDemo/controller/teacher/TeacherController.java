package com.ite.smvcDemo.controller.teacher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamTeacher;
import com.ite.smvcDemo.entity.role.Role;
import com.ite.smvcDemo.service.stu.IStuService;
import com.ite.smvcDemo.service.teacher.ITeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private ITeacherService iTeacherService;
	
	@RequestMapping(value="/Teacher",method= {RequestMethod.GET,RequestMethod.POST})
	public String StudentList(Model model,ExamStu examStum){
		PagerModel<UserVO> page = iTeacherService.findAllByPage();
		model.addAttribute("page",page);
		System.out.println("161658");
		return "teacher/teacherList";
	}
	@RequestMapping(value="/TeacherList",method= {RequestMethod.GET,RequestMethod.POST})
	public String TeacherList(Model model){
		PagerModel<UserVO> page = iTeacherService.findAllByPage();
		model.addAttribute("page",page);
		System.out.println("161658");
		return "/teacher/teacherList";
	}
	//教师增加
	@RequestMapping(value="/TeacherAdd", method= RequestMethod.GET )
	public String TeacherAdd(Model model) {
		UserVO userVO=new UserVO();
	    model.addAttribute("teacherVO", userVO);
		return "teacher/teacherAdd";
	}
	
	@RequestMapping(value="/TeacherAdd",method = RequestMethod.POST)
	public String StudentSave(@Validated UserVO userVO, BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return "teacher/teacherAdd";
		}
		try{
		ExamTeacher examTeacher=new ExamTeacher();
		BeanUtils.copyProperties(userVO, examTeacher);
		examTeacher.setExamTeacherPassword(userVO.getExamStuPassword());
		iTeacherService.save(examTeacher);
		redirectAttributes.addFlashAttribute("message", "Add successfully.");
		return "redirect:/teacher/teacherList";
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("message", "修改重复");
			return "redirect:/teacher/TeacherAdd";
		}
	}
		
	
	//教师删除
	@RequestMapping(value="/TeacherDelete/{examTeacherId}",method=RequestMethod.GET)
	public String TeacherDelete(@PathVariable String examTeacherId){
		ExamTeacher teacher=new ExamTeacher();
		teacher.setExamTeacherId(new Integer(examTeacherId));  //类型转换
		iTeacherService.delete(teacher);
		return "redirect:/teacher/Teacher";
	}
	
	
	 public static String Md5(String inStr) throws NoSuchAlgorithmException{
	    	StringBuffer sb=new StringBuffer();
	    	MessageDigest md=MessageDigest.getInstance("MD5");
	    	md.update(inStr.getBytes());
	    	byte b[]=md.digest();
	    	int i;
	    	for(int offset=0;offset<b.length;offset++){
	    		i=b[offset];
	    		if(i<0)
	    			i+=256;
	    		if(i<16)
	    			sb.append("0");
	    		sb.append(Integer.toHexString(i));
	    	}
	    	return sb.toString().toUpperCase();
	    }
	
}
