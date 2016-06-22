package com.ite.smvcDemo.service.role;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.dao.role.IRoleDAO;
import com.ite.smvcDemo.entity.role.Role;

@Service
@Transactional
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDAO roleDAO;
	
	@Override
	public List<RoleVO> findAll() {
		List<RoleVO> returnList = new ArrayList<RoleVO>();
		List<Role> list = roleDAO.findAll();
		for(Role role : list){
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(role, roleVO);
			returnList.add(roleVO);
		}
		return returnList;

	}

	@Override
	public PagerModel<RoleVO> findAllByPage() {
		return roleDAO.findAllByPage();
	}

}
