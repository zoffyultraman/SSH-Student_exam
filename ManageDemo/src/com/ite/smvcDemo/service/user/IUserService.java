package com.ite.smvcDemo.service.user;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.entity.user.Users;

public interface IUserService {

	public Serializable save(Users users);
	
	public void update(Users users);
	
	public void delete(Users users);
	
	public UsersVO findByKey(UsersVO usersVO);
	
	public List<UsersVO> findAll();
	
	public PagerModel<UsersVO> findAllByPage();
	
	public UsersVO findByName(UsersVO usersVO);
}
