package com.ite.smvcDemo.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.ite.smvcDemo.entity.user.Users;
import com.ite.smvcDemo.service.role.IRoleService;
import com.ite.smvcDemo.service.user.IUserService;

@Controller
@RequestMapping("users")
public class UserController {

//	public Map<String, UserVO> users = new HashMap<String, UserVO>();
//	
//	public UserController() {
//		users.put("aaa", new UserVO("aaa", "123", 12, "a@apj.com"));
//		users.put("bbb", new UserVO("bbb", "123", 12, "b@apj.com"));
//		users.put("ccc", new UserVO("ccc", "123", 12, "c@apj.com"));
//	}
	
	@Autowired
	private IUserService userServcie;
	
	@Autowired
	private IRoleService roleService;
	
	public IUserService getUserServcie() {
		return userServcie;
	}

	public void setUserServcie(IUserService userServcie) {
		this.userServcie = userServcie;
	}

	@RequestMapping(value="/userList", method= {RequestMethod.GET , RequestMethod.POST})
	public String userList(Model model){
    	PagerModel<UsersVO> page = userServcie.findAllByPage();
		model.addAttribute("page",page);
		return "user/userList";
	}
	
	@RequestMapping(value="/delete/{userId}", method= RequestMethod.GET )
	public String delete(@PathVariable String userId){
		Users users = new Users();
		users.setUserId(new Integer(userId));
		userServcie.delete(users);
		return "redirect:/users/userList";
	}
	
	protected Map<String,String> getRoleList() throws Exception {
		Map<String,String> roleLabel = new HashMap<String,String>();
		List<RoleVO> list = roleService.findAll();
		for(RoleVO roleVO : list){
			roleLabel.put(roleVO.getRoleId(), roleVO.getRoleName());
		}
		return roleLabel;
	}
	
	
	@RequestMapping(value="/edit/{userId}", method= RequestMethod.GET )
	public String edit(@PathVariable String userId , Model model) throws Exception{
		UsersVO usersVO = new UsersVO();
		usersVO.setUserId(new Integer(userId));
		usersVO = userServcie.findByKey(usersVO);
		
		Map<String, String> roleList = this.getRoleList();
		//UserVO userVO = users.get(username);
		model.addAttribute("userVO",usersVO);
		model.addAttribute("roleList",roleList);
		return "user/userEdit";
	}
	
	@RequestMapping(value="/edit/{userId}", method= RequestMethod.POST )
	public String update(@PathVariable String userId ,@Validated UsersVO userVO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if (bindingResult.hasErrors()) {
			return "user/userEdit";
		}
		
		UsersVO existVO = userServcie.findByKey(userVO);
		existVO.setAge(userVO.getAge());
		existVO.setEmail(userVO.getEmail());
		existVO.setRemark(userVO.getRemark());
		existVO.setRoleId(userVO.getRoleId());
		existVO.setSex(userVO.getSex());
		existVO.setUserName(userVO.getUserName());
		
		Users users = new Users();
		BeanUtils.copyProperties(existVO, users);
		users.setUpdDate(new Date());
		users.setUpdUser("Deft");
		userServcie.update(users);
		//users.put(userVO.getUserName(), userVO);
		
		redirectAttributes.addFlashAttribute("message", "Update successfully. ");
		return "redirect:/users/userList";
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET )
	public String add(Model model) throws Exception{
		UsersVO usersVO = new UsersVO();
		Map<String, String> roleList = this.getRoleList();
		model.addAttribute("usersVO",usersVO);
		model.addAttribute("roleList",roleList);
		return "user/userAdd";
	}
	
	
	@RequestMapping(value="/add", method= RequestMethod.POST )
	public String Save(HttpServletRequest request, @Validated UsersVO usersVO, BindingResult bindingResult){
		//UserVO userVO = new UserVO(request.getParameter("userName"), request.getParameter("password"), new Integer(request.getParameter("age")).intValue(), request.getParameter("email"));
		if (bindingResult.hasErrors()) {
			return "user/userAdd";
		}
		Users users = new Users();
		BeanUtils.copyProperties(usersVO, users);
		users.setUpdDate(new Date());
		users.setUpdUser("Deft");
		
		userServcie.save(users);
//		System.out.println(request.getSession().getAttribute("user"));
		//users.put(userVO.getUserName(), userVO);
		return "redirect:/users/userList";
	}
}
