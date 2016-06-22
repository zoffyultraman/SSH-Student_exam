package com.ite.smvcDemo.dao.user;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.user.Users;

public interface IUsersDAO extends IBaseDAO<Users>{

	public PagerModel<UsersVO> findAllByPage();
	
	public UsersVO findByName(UsersVO usersVO);
}
