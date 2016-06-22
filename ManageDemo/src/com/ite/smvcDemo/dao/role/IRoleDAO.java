package com.ite.smvcDemo.dao.role;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.role.Role;

public interface IRoleDAO  extends IBaseDAO<Role>{

	public Serializable save(Role role);
	
	public void update(Role role);
	
	public void delete(Role role);
	
	public List<Role> findAll();
	
	public PagerModel<RoleVO> findAllByPage();
	
	public RoleVO findByName(RoleVO roleVO);
	
}
