package com.ite.smvcDemo.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.entity.role.Role;
import com.ite.smvcDemo.service.role.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	
	@Autowired
	private IRoleService roleService;

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}


	@RequestMapping(value="/roleList", method= {RequestMethod.GET , RequestMethod.POST})
	public String roleList(Model model,Role role){
		PagerModel<RoleVO> page = roleService.findAllByPage();
//		System.out.println(page.getDates().get(0).getUpdUser());
		model.addAttribute("page",page);
		return "role/roleList";
	}
	
}
