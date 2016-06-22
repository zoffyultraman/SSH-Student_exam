package com.ite.smvcDemo.controller.fileUpload;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.entity.user.Users;
import com.ite.smvcDemo.service.user.IUserService;
import com.ite.smvcDemo.util.ExcelUtil;

@Controller
public class FileUploadController {

	@Autowired
	private IUserService userServcie;
	
	@RequestMapping(value = "/upload",method = RequestMethod.GET)  
	public String upload() {  
        return "fileUpload/fileUpload";  
    } 
	
	@RequestMapping(value = "/fileUpload",method = RequestMethod.POST)  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, ModelMap model) {  
  
		UsersVO user = (UsersVO) session.getAttribute("user");
        String path = session.getServletContext().getRealPath("upload");    //保存文件路径到session
        String fileName = file.getOriginalFilename();     //创建文件名
        
        System.out.println(fileName);
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile); 
            
            ExcelUtil excelUtil = new ExcelUtil();
            List<UsersVO> list = excelUtil.readExcel(path +"\\"+ fileName);
            for(UsersVO usersVO :list){
            	System.out.println(usersVO.getUserName() +"=="+usersVO.getPassword()+"=="+usersVO.getAge()+"=="+usersVO.getSex()+"=="+usersVO.getEmail()+"=="+usersVO.getRemark());
            	
            	Users users = new Users();
            	BeanUtils.copyProperties(usersVO, users);
            	users.setUpdUser(user.getUserName());
            	users.setUpdDate(new Date());
            	users.setRoleId("teacher");
            	userServcie.save(users);
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
       
        
        model.addAttribute("message", "Upload successfully.");  
  
        return "fileUpload/fileUpload";  
    }  
}
