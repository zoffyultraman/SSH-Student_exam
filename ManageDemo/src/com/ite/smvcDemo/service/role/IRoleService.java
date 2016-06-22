package com.ite.smvcDemo.service.role;

import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;

public interface IRoleService {

	public List<RoleVO> findAll();
	
	public PagerModel<RoleVO> findAllByPage();
}
