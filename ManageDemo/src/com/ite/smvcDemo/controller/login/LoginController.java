package com.ite.smvcDemo.controller.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.service.stu.IStuService;
import com.ite.smvcDemo.service.teacher.ITeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


@Controller
public class LoginController {

	private static Logger logger = (Logger) LogManager.getLogger(LoginController.class); 
	
	@Autowired
	private ITeacherService iTeacherService;
	@Autowired
    private IStuService iStuService;
	
	@RequestMapping(value="/home" , method = {RequestMethod.GET})   //登录窗口
	public String home(Model model){
		model.addAttribute("userVO",new UserVO());
		return "login/login";
	}
	
	@RequestMapping(value="/miss",method = RequestMethod.GET)
	public String error(Model model){
		model.addAttribute("userVO",new UserVO());
		return "error/error";
	}
	//考试结束回到下一题
	@RequestMapping(value="/returnzhu", method = RequestMethod.GET)
	public String returnzhu(){
		return "redirect:/stuSubject/StuGradeFind";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login( UserVO userVO,String character, HttpSession session,HttpServletRequest request,BindingResult br,Model model,RedirectAttributes redirectAttributes) throws NoSuchAlgorithmException{
		System.out.println("---------"); 
		
		
		 logger.debug("我是debug信息");
		 logger.info("我是info信息");    //info级别的信息
         logger.warn("我是warn信息");
         logger.fatal("我是fatal信息");
         logger.error("---error---");
         
         
         System.out.println("---------"); 
		
		if(br.hasErrors()){
			return "redirect:/error";
		}

		UserVO teacher=iTeacherService.findByNumber(userVO);
		UserVO student=iStuService.findByNumber(userVO);
		String role;
		if(character.equals("teacher")){
		    if(this.isUser(teacher, userVO.getExamStuPassword())){
		    	role="teacher";
		    	Integer TeachId=teacher.getExamTeacherId();
		    	
		    	//查找roleId
				List<UserVO>  roleidList=new ArrayList<UserVO>();
				roleidList=iTeacherService.findByRoleId(TeachId,role);
                Integer roleId=roleidList.get(0).getRoleId();
                //利用查到的roleId查找界面菜单信息
				List<UserVO>  ResourceTea=new ArrayList<UserVO>();
				ResourceTea=iTeacherService.findByResource(roleId);
				session.setAttribute("ResourceTea", ResourceTea);
		    	
		    	
			    session.setAttribute("teacher", teacher);
			    session.setAttribute("role", role);
			    int a=1;
			    session.setAttribute("panduan",1);
			    return "redirect:/teacher/Teacher";
		   /* redirectAttributes.addFlashAttribute("message", "登陆失败  ");
		    return "redirect:/login/login";*/
		    }else{
		    	
		    	redirectAttributes.addFlashAttribute("message", "登陆失败  ");
		    	return "redirect:/home";
		    }
		}else if(character.equals("student")){
		    if(this.isStu(student, Md5(userVO.getExamStuPassword()))){
		    	role = "student";
		    	Integer StuId=student.getExamStuId();
		    	
		    	//查找roleId
				List<UserVO>  roleidList=new ArrayList<UserVO>();
				roleidList=iStuService.findByRoleId(StuId,role);
                Integer roleId=roleidList.get(0).getRoleId();
                //利用查到的roleId查找界面菜单信息
				List<UserVO>  Resource=new ArrayList<UserVO>();
				Resource=iStuService.findByResource(roleId);
				session.setAttribute("Resource", Resource);
				
				
				
				
				
				
		    	session.setAttribute("role", role);
		    	session.setAttribute("stuid", student.getExamStuId());
				session.setAttribute("teacher", student);
				
				int a=2;
				session.setAttribute("panduan",2);
			return "redirect:/stuSubject/StuGradeFind";
			
			}
		    redirectAttributes.addFlashAttribute("message", "登陆失败  ");
	    	return "redirect:/home";
		}
//		return character;
		return character;
	}

	public boolean isStu(UserVO teacher, String password) throws NoSuchAlgorithmException{
		boolean isStu = true;
		
		if(teacher == null ){
			isStu = false;
		}else{
			if(!password.equals(teacher.getExamStuPassword())){
				isStu = false;
			}
		}
		return isStu;
	}
	public boolean isUser(UserVO teacher, String password)  throws NoSuchAlgorithmException{
		boolean isUser = true;
		
     	if(teacher == null ){
			isUser = false;
		}else{
			if(!password.equals(teacher.getExamTeacherPassword())){
				isUser = false;
			}
		}
		return isUser;
	}
	
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(UserVO userVO, HttpSession session){
		
		session.invalidate();
		
		return "redirect:/home";
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
