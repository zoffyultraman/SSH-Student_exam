package com.ite.smvcDemo.dao.subject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamSubject;

@Repository("subjectDAOImp")
public class SubjectDAOImp extends BaseDAOimp<ExamSubject> implements ISubjectDAO {

	@Autowired
	private HibernateTemplate HibernateTemplate;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<SubjectVO> findAllByPage() {
		PagerModel<SubjectVO> page=new PagerModel<SubjectVO>();
		ArrayList<SubjectVO> dates=new ArrayList<SubjectVO>();
		int offset=SystemContext.getOffset();
		int pageSize=SystemContext.getPageSize();
		List<ExamSubject> tempDates=this.getSession().createQuery("from ExamSubject")
				
				.setFirstResult(offset).setMaxResults(pageSize)
				.list();
		for(ExamSubject examSubject : tempDates){
			SubjectVO subjectVO = new SubjectVO();
		    BeanUtils.copyProperties(examSubject, subjectVO);
			dates.add(subjectVO);
		}
		
		page.setDates(dates);
		page.setOffset(offset);
		page.setPageSize(pageSize);
		
		//获取总记录数
		long totalSize =  (long) this.getSession().createQuery("select count(*) from ExamSubject ").uniqueResult();
		page.setTotalSize(totalSize);
		return page;
	}

	@Override
	public SubjectVO findByName(SubjectVO subjectVO) {
		
		ExamSubject examSubject = (ExamSubject) this.getSession().createQuery(" from ExamSubject t where t.examsubjectname = :examsubjectname ").setParameter("Examsubjectname", subjectVO.getExamsubjectname()).uniqueResult();
		SubjectVO returnVO = null;
		if(examSubject != null){
			returnVO = new SubjectVO();
			BeanUtils.copyProperties(examSubject, returnVO);
		}
		return returnVO;
	}

	@Override
	public void updateflag(ExamSubject examSubject) {
		HibernateTemplate.update(examSubject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> findByStuSubject(String Number,UserVO userVO){
		List<UserVO> StuList=new ArrayList<UserVO>();
        String sql="select s.exam_stu_number,s.exam_stu_id,s.exam_stu_done,s.exam_stu_name, t.exam_subject_id,t.exam_subject_name,t.exam_subject_description,t.exam_subject_sum,t.exam_subject_done,t.exam_subject_tnumber,"
        		+ "a.exam_subject_id,t.exam_subject_totaltime,a.exam_stu_id,a.UPDUSER,a.UPDDATE,"
        		+ "p.exam_stu_id,p.exam_grade_point from exam_student_subject as a "
        		+ "LEFT JOIN exam_grade as p ON p.exam_subject_id = a.exam_stu_id  "
        		+ "LEFT JOIN exam_stu as s ON s.exam_stu_id = a.exam_stu_id "
        		+ "LEFT JOIN exam_subject as t ON t.exam_subject_id = a.exam_subject_id where s.exam_stu_number = '"+Number+"'";		
        StuList=getSession().createSQLQuery(sql)
        	   .addScalar("UPDUSER",StringType.INSTANCE)
        	   .addScalar("exam_subject_id",IntegerType.INSTANCE)
        	   .addScalar("exam_stu_id",IntegerType.INSTANCE)
        	   .addScalar("exam_subject_name",StringType.INSTANCE)
 	           .addScalar("exam_subject_description",StringType.INSTANCE)
 	           .addScalar("exam_subject_tnumber",IntegerType.INSTANCE)
 	           .addScalar("exam_subject_totaltime", IntegerType.INSTANCE)
 	           .addScalar("exam_subject_sum",IntegerType.INSTANCE)
 	           .addScalar("exam_subject_done", IntegerType.INSTANCE)
 	           .addScalar("exam_stu_done", IntegerType.INSTANCE)
 	           .addScalar("exam_stu_name", StringType.INSTANCE)
 	           .addScalar("exam_grade_point",IntegerType.INSTANCE)
// 	           .setParameter("exam_stu_id", gradeVO.getExamStuId())
 	           .setResultTransformer(Transformers.aliasToBean(UserVO.class))
        		.list();
        return StuList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> findByStuId(UserVO userVO){
		List<UserVO> StuId=new ArrayList<UserVO>();
		String sql="select t.exam_stu_id,t.exam_stu_number from exam_stu as t where t.exam_stu_number = 666";
		StuId=getSession().createSQLQuery(sql)
				.addScalar("exam_stu_id", IntegerType.INSTANCE)
				.addScalar("exam_stu_number", IntegerType.INSTANCE)
				.list();
		
		System.out.println(StuId);
		return StuId;
	}

}
