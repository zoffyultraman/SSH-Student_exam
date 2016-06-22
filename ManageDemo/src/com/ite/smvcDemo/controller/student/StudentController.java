package com.ite.smvcDemo.controller.student;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.service.stu.IStuService;


@Controller
@RequestMapping("/student")	
public class StudentController {
	@Autowired
	private IStuService iStuService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/Student", method= {RequestMethod.GET , RequestMethod.POST})
	public String StudentList(Model model,ExamStu examStum,HttpSession session){
		PagerModel<UserVO> page = iStuService.findAllByPage();
		List<UserVO>  list=new ArrayList<UserVO>();
		
		
		model.addAttribute("page",page);
		return "student/stuList";
	}
	
	@RequestMapping(value="/StudentDelete/{examstuid}",method=RequestMethod.GET)
	public String StudentDelete(@PathVariable String examstuid,RedirectAttributes redirectAttributes){
		ExamStu stu=new ExamStu();
		stu.setExamStuId(new Integer(examstuid));  //类型转换
		iStuService.delete(stu);
		System.out.println("测试反应");
		redirectAttributes.addFlashAttribute("message", "Delete successfully. ");
		return "redirect:/student/Student";
	}
	
	@RequestMapping(value="/StudentAdd", method= RequestMethod.GET )
	public String StudentAdd(Model model) {
		UserVO userVO=new UserVO();
	    model.addAttribute("stuVO", userVO);
	    Map<Integer,String>  done=new HashMap<Integer,String>();
		done.put(1, "考试开启");
		done.put(2, "考试暂停");
		model.addAttribute("done", done);
		return "student/stuAdd";
	}
	
	@RequestMapping(value="/StudentAdd",method = RequestMethod.POST)
	public String StudentSave(@Validated UserVO userVO, BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
		if(bindingResult.hasErrors()){
			return "student/stuAdd";
		}
		UserVO userVO2=new UserVO();
		
		
		
		
		
		ExamStu examStu = new ExamStu();
		BeanUtils.copyProperties(userVO, examStu);
		try {
			examStu.setExamStuPassword(Md5(userVO.getExamStuPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		iStuService.save(examStu);
		redirectAttributes.addFlashAttribute("message", "Add successfully. ");
		return "redirect:/student/Student";
		
	}
	
	@RequestMapping(value="/StudentEdit/{examStuId}",method= RequestMethod.GET )
	public String StudentEdit(@PathVariable String examStuId , Model model) throws Exception{
		UserVO userVO = new UserVO();
		userVO.setExamStuId((new Integer(examStuId)));
		userVO = iStuService.findByKey(userVO);
		model.addAttribute("userVO",userVO);
		return "/student/stuEdit";
	}
	
	
	@RequestMapping(value="/StudentEdit/{examStuId}", method= RequestMethod.POST )
	public String StudentUpdate(@PathVariable String examStuId ,@Validated UserVO userVO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if (bindingResult.hasErrors()) {
			return "student/StudentEdit";
		}
		UserVO existVO = iStuService.findByKey(userVO);
		existVO.setExamStuName(userVO.getExamStuName());
		existVO.setExamStuNumber(userVO.getExamStuNumber());
		try {
			existVO.setExamStuPassword(Md5(userVO.getExamStuPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		existVO.setExamstuSex(userVO.getExamstuSex());
		existVO.setExamStuBirthday(userVO.getExamStuBirthday());
		existVO.setExamStuTel(userVO.getExamStuTel());
		existVO.setExamStuAddress(userVO.getExamStuAddress());
		existVO.setExamStuDone(userVO.getExamStuDone());

		
		ExamStu user = new ExamStu();
		BeanUtils.copyProperties(existVO, user);
		iStuService.update(user);
		
		redirectAttributes.addFlashAttribute("message", "Update successfully. ");
		return "redirect:/student/Student";
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
