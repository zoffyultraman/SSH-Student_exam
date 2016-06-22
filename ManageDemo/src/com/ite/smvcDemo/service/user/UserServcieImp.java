package com.ite.smvcDemo.service.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.dao.user.IUsersDAO;
import com.ite.smvcDemo.entity.user.Users;

@Service("userServcie")
@Transactional
public class UserServcieImp implements IUserService{

	@Autowired
	private IUsersDAO userdao;
	
	@Override
	public Serializable save(Users users) {
		return userdao.save(users);
	}

	@Override
	public void update(Users users) {
		userdao.update(users);
	}

	@Override
	public void delete(Users users) {
		userdao.delete(users);
		
	}

	@Override
	public UsersVO findByKey(UsersVO usersVO) {
		Users temp = userdao.findByKey(usersVO.getUserId());
		UsersVO tempVO = new UsersVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}

	@Override
	public List<UsersVO> findAll() {
		List<UsersVO> returnList = new ArrayList<UsersVO>();
		List<Users> list = userdao.findAll();
		for(Users users : list){
			UsersVO usersVO = new UsersVO();
			BeanUtils.copyProperties(users, usersVO);
			usersVO.setRoleName(users.getRole().getRoleName());
			returnList.add(usersVO);
		}
		return returnList;
	}

	@Override
	public PagerModel<UsersVO> findAllByPage() {
		return userdao.findAllByPage();
	}

	@Override
	public UsersVO findByName(UsersVO usersVO) {
		return userdao.findByName(usersVO);
	}
}
