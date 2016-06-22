package com.ite.smvcDemo.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.user.UsersVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.user.Users;

@Repository("usersDAOImp")
public class UsersDAOImp extends BaseDAOimp<Users> implements IUsersDAO{

	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<UsersVO> findAllByPage() {
		PagerModel<UsersVO> page = new PagerModel<UsersVO>();
		ArrayList<UsersVO> dates = new ArrayList<UsersVO> ();
		int offset = SystemContext.getOffset();
		int pageSize = SystemContext.getPageSize();
		
		//使用hibernate完成分页
		List<Users> tempDates = this.getSession().createQuery(" from Users ")
		.setFirstResult(offset)
		.setMaxResults(pageSize)
		.list();
		
		for(Users users : tempDates){
			UsersVO usersVO = new UsersVO();
			BeanUtils.copyProperties(users, usersVO);
			usersVO.setRoleName(users.getRole().getRoleName());
			dates.add(usersVO);
		}
		
		page.setDates(dates);
		page.setOffset(offset);
		page.setPageSize(pageSize);
		
		//获取总记录数
		long totalSize =  (long) this.getSession().createQuery("select count(*) from Users ").uniqueResult();
		page.setTotalSize(totalSize);
		return page;
	}

	@Override
	public UsersVO findByName(UsersVO usersVO) {
		Users users = (Users) this.getSession().createQuery(" from Users t where t.userName = :userName ").setParameter("userName", usersVO.getUserName()).uniqueResult();
		UsersVO returnVO = null;
		if(users != null){
			returnVO = new UsersVO();
			BeanUtils.copyProperties(users, returnVO);
		}
		return returnVO;
	}

}
