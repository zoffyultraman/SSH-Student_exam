package com.ite.smvcDemo.dao.student;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamStu;

@Repository("studentDAOImp")
public class StudentDAOImp extends BaseDAOimp<ExamStu> implements IStudentDAO{

	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<UserVO> findAllByPage() {
		PagerModel<UserVO> page = new PagerModel<UserVO>();
		List<UserVO> dates = new ArrayList<UserVO> ();
		int offset = SystemContext.getOffset();
		int pageSize = SystemContext.getPageSize();
		//使用hibernate完成分页
		List<ExamStu> tempDates = this.getSession().createQuery(" from ExamStu ")
		.setFirstResult(offset)
		.setMaxResults(pageSize)
		.list();
		for(ExamStu examStu : tempDates){
			UserVO userVO = new UserVO();
		    BeanUtils.copyProperties(examStu, userVO);
            if(userVO.getExamstuSex().equals("M")){
            	 userVO.setExamstuSex("男");
            	dates.add(userVO);
           
			}else{
				userVO.setExamstuSex("女");
            	dates.add(userVO);
			}
            
		}
		
//		session.setAttribute("stuList", tempDates);
		page.setDates(dates);
		page.setOffset(offset);
		page.setPageSize(pageSize);
		
		//获取总记录数
		long totalSize =  (long) this.getSession().createQuery("select count(*) from ExamStu ").uniqueResult();
		page.setTotalSize(totalSize);
		return page;
	}


	@Override
	public UserVO findByNumber(UserVO userVO) {
		ExamStu examStu = (ExamStu) this.getSession().createQuery(" from ExamStu t where t.examStuNumber = :examStuNumber ").setParameter("examStuNumber", userVO.getExamStuNumber()).uniqueResult();
		UserVO returnVO = null;
		if(examStu != null){
			returnVO = new UserVO();
			BeanUtils.copyProperties(examStu, returnVO);
		}
		return returnVO;
	}


	@SuppressWarnings({"unchecked" })
	@Override
	public List<UserVO> findByRoleId(Integer StuId, String roleName) {
		List<UserVO> RoleVOId=new ArrayList<UserVO>();
		String sql="SELECT t.userid,t.roleId,s.roleId,s.roleName,a.exam_stu_id,a.exam_stu_number"
				+" FROM user_role AS t"
				+" LEFT JOIN exam_stu AS a ON a.exam_stu_id = t.userid"
				+" LEFT JOIN role AS s ON s.roleId = t.roleId"
				+" where a.exam_stu_id  = :StuId && s.roleName = :roleName";
		RoleVOId=getSession().createSQLQuery(sql)
				.addScalar("roleId", IntegerType.INSTANCE)
				.setParameter("StuId",StuId)
				.setParameter("roleName",roleName)
				.setResultTransformer(Transformers.aliasToBean(UserVO.class))
				.list();
		return RoleVOId;
	}

	@SuppressWarnings({ "unused", "unchecked" })
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
