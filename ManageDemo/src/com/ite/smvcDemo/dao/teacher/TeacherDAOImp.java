package com.ite.smvcDemo.dao.teacher;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamTeacher;

@Repository("teacherDAOImp")
public class TeacherDAOImp extends BaseDAOimp<ExamTeacher> implements ITeacherDAO{

	
	
		@SuppressWarnings("unchecked")
		@Override
		public PagerModel<UserVO> findAllByPage() {
			PagerModel<UserVO> page = new PagerModel<UserVO>();
			ArrayList<UserVO> dates = new ArrayList<UserVO> ();
			int offset = SystemContext.getOffset();
			int pageSize = SystemContext.getPageSize();
			
			//使用hibernate完成分页
			List<ExamTeacher> tempDates = this.getSession().createQuery("from ExamTeacher ")
			.setFirstResult(offset)
			.setMaxResults(pageSize)
			.list();
			
			for(ExamTeacher examTeacher : tempDates){
				UserVO userVO = new UserVO();
			    BeanUtils.copyProperties(examTeacher, userVO);
				
	/*			usersVO.setRoleName(role.getRole().getRoleName());*/
				dates.add(userVO);
			}
			
			page.setDates(dates);
			page.setOffset(offset);
			page.setPageSize(pageSize);
			
			//获取总记录数
			long totalSize =  (long) this.getSession().createQuery("select count(*) from ExamTeacher ").uniqueResult();
			page.setTotalSize(totalSize);
			return page;
		}
	
	
		@Override
		public UserVO findByNumber(UserVO userVO) {
			ExamTeacher examTeacher = (ExamTeacher) this.getSession().createQuery(" from ExamTeacher t where t.examTeacherNumber = :examTeacherNumber ")
					.setParameter("examTeacherNumber",Integer.parseInt( userVO.getExamStuNumber()))
					.uniqueResult();
			UserVO returnVO = null;
			if(examTeacher != null){
				returnVO = new UserVO();
				BeanUtils.copyProperties(examTeacher, returnVO);
			}
			return returnVO;
		}


		@SuppressWarnings("unchecked")
		@Override
		public List<UserVO> findByRoleId(Integer TeachId, String roleName) {
			List<UserVO> RoleVOId=new ArrayList<UserVO>();
			String sql="SELECT t.userid,t.roleId,s.roleId,s.roleName,a.exam_teacher_id"
					+" FROM user_role AS t"
					+" LEFT JOIN exam_teacher AS a ON a.exam_teacher_id = t.userid"
					+" LEFT JOIN role AS s ON s.roleId = t.roleId"
					+" where a.exam_teacher_id  = :TeachId && s.roleName = :roleName";
			RoleVOId=getSession().createSQLQuery(sql)
					.addScalar("roleId", IntegerType.INSTANCE)
					.setParameter("TeachId",TeachId)
					.setParameter("roleName",roleName)
					.setResultTransformer(Transformers.aliasToBean(UserVO.class))
					.list();
			return RoleVOId;
		}


		@SuppressWarnings("unchecked")
		@Override
		public List<UserVO> findByResource(Integer roleId) {
			List<UserVO> Resource=new ArrayList<UserVO>();
			String sql="SELECT t.roleId,t.recourceId,s.roleName,s.roleId,"
					  +" a.recourceId,a.resouceName,a.URL,a.fathermenu,a.Sonmenu"
					  +" from role_recource AS t"
					  +" LEFT JOIN role AS s ON s.roleId = t.roleId"
					  +" LEFT JOIN resouce AS a ON a.recourceId = t.recourceId"
					  +" where t.roleId = :roleId ";
			Resource=getSession().createSQLQuery(sql)
					.addScalar("fathermenu",IntegerType.INSTANCE)
					.addScalar("resouceName",StringType.INSTANCE)
					.addScalar("URL",StringType.INSTANCE)
					.setParameter("roleId",roleId)
					.setResultTransformer(Transformers.aliasToBean(UserVO.class))
					.list();
			return Resource;
		}

}
