package com.ite.smvcDemo.dao.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.role.Role;


@Repository("roleDAOImp")
public class RoleDAOImp extends BaseDAOimp<Role> implements IRoleDAO{
	/*	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		String hql = "from Role ";
		//return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).list();
		//return getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).list();
		return getHibernateTemplate().find(hql);
	}*/



	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<RoleVO> findAllByPage() {
		PagerModel<RoleVO> page = new PagerModel<RoleVO>();
		ArrayList<RoleVO> dates = new ArrayList<RoleVO> ();
		int offset = SystemContext.getOffset();
		int pageSize = SystemContext.getPageSize();
		
		//使用hibernate完成分页
		List<Role> tempDates = this.getSession().createQuery("from Role ")
		.setFirstResult(offset)
		.setMaxResults(pageSize)
		.list();
		
		for(Role role : tempDates){
			RoleVO roleVO = new RoleVO();
//		    BeanUtils.copyProperties(role, roleVO);
			roleVO.setRoleId(role.getRoleId());
			roleVO.setRoleName(role.getRoleName());
			roleVO.setUpdDate(role.getUpdDate());
			roleVO.setUpdUser(role.getUpdUser());
/*			usersVO.setRoleName(role.getRole().getRoleName());*/
			dates.add(roleVO);
		}
		
		page.setDates(dates);
		page.setOffset(offset);
		page.setPageSize(pageSize);
		
		//获取总记录数
		long totalSize =  (long) this.getSession().createQuery("select count(*) from Role ").uniqueResult();
		page.setTotalSize(totalSize);
		return page;
	}


	@Override
	public RoleVO findByName(RoleVO roleVO) {
		Role role = (Role) this.getSession().createQuery(" from Role t where t.roleName = :roleName ").setParameter("roleName", roleVO.getRoleName()).uniqueResult();
		RoleVO returnVO = null;
		if(role != null){
			returnVO = new RoleVO();
			BeanUtils.copyProperties(role, returnVO);
		}
		return returnVO;
	}
	
}
