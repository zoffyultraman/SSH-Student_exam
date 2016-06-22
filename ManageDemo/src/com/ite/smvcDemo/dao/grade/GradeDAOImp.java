package com.ite.smvcDemo.dao.grade;


import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.xml.transform.Transformer;

import org.apache.catalina.tribes.transport.DataSender;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamGrade;
import com.ite.smvcDemo.entity.ExamStu;

@Repository("gradeDAOImp")
public class GradeDAOImp  extends BaseDAOimp<ExamGrade>   implements IGradeDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<GradeVO> findAllByPage() {
		PagerModel<GradeVO> pagerModel=new PagerModel<GradeVO>();
		List<GradeVO> dates=new ArrayList<GradeVO>();
		int offset=SystemContext.getOffset();
		int pageSize=SystemContext.getPageSize();
//		String sql="select * from exam_grade join exam_stu on exam_grade.exam_stu_id=exam_stu.exam_stu_id";
		String sql="from ExamGrade ";
		
		
//		List<GradeVO> graVO=this.getSession().createSQLQuery(hql)
//				.setResultTransformer(Transformer.aliasToBean(GradeVO))
//				.list();
		List<ExamGrade> tempDates=this.getSession().createQuery(sql)
				.setFirstResult(offset)
				.setMaxResults(pageSize)
				.list();
		System.out.println(tempDates);
          for(ExamGrade examGrade:tempDates){
        	  GradeVO gradeVO=new GradeVO();
        	  BeanUtils.copyProperties(examGrade, gradeVO);
        	  dates.add(gradeVO);
          }
		   pagerModel.setDates(dates);
		   pagerModel.setOffset(offset);
		   pagerModel.setPageSize(pageSize);
		   
		   long totalSize=(long) this.getSession().createQuery("select count(*) from ExamGrade").uniqueResult();
		   pagerModel.setTotalSize(totalSize);
		   return pagerModel;
	}

	//学生查看成绩列表
		@SuppressWarnings("unchecked")
		@Override
		public List<GradeVO> findByStuGrade(GradeVO gradeVO,String number){
			String sql="select t.exam_stu_id,t.exam_stu_number as examStuNumber,t.exam_stu_name as examStuName,"
					+ "a.exam_stu_id,a.exam_subject_id,b.exam_subject_id,b.exam_subject_tnumber as examSubjectTnumber,b.exam_subject_name as examSubjectName,b.exam_subject_totaltime,"
					+ "p.exam_stu_id,p.exam_grade_point as examGradePoint,p.exam_grade_time as examGradeTime from exam_student_subject AS a "
					+ "LEFT JOIN  exam_stu AS t ON t.exam_stu_id = a.exam_stu_id LEFT JOIN  exam_subject AS b ON b.exam_subject_id = a.exam_subject_id LEFT JOIN  exam_grade AS p ON p.exam_stu_id = a.exam_stu_id WHERE t.exam_stu_number = :number ";
			List<GradeVO> gradeVOList=new ArrayList<GradeVO>();
			System.out.println("2001");
			gradeVOList=getSession().createSQLQuery(sql)
					      .addScalar("examStuNumber",IntegerType.INSTANCE)
					      .addScalar("examStuName",StringType.INSTANCE)
					      .addScalar("examSubjectName",StringType.INSTANCE)
					      .addScalar("examSubjectTnumber",IntegerType.INSTANCE)
					      .addScalar("examGradeTime",DateType.INSTANCE)
					      .addScalar("examGradePoint",IntegerType.INSTANCE)
					      .setParameter("number", Integer.parseInt(number))
					      .setResultTransformer(Transformers.aliasToBean(GradeVO.class))
				     	  .list();
			
//			System.out.println(gradeVOList.get(0).getExamStuName());
			return gradeVOList;
			
		}
	
	
	//老师查看成绩列表
	@SuppressWarnings("unchecked")
	@Override
    public List<GradeVO> finByStuId(GradeVO gradeVO){
		
    	StringBuffer sqll=new StringBuffer();
//    	System.out.println("888");
    	List<GradeVO> list=new ArrayList<GradeVO>();
		sqll.append("select s.exam_stu_number,s.exam_stu_id,s.exam_stu_name,ex.exam_subject_id,ex.exam_subject_name,t.exam_stu_id,t.exam_grade_point,t.exam_grade_time,t.exam_subject_id,t.exam_grade_id from exam_grade as t ");
		sqll.append(" left join exam_stu as s on s.exam_stu_id = t.exam_stu_id");
		sqll.append(" right join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id");
     if(gradeVO.getExamStuId()!=null){
    	 System.out.println("1");
    	 sqll.append("where t.exam_stu_id =?");
    	 list=getSession().createSQLQuery(sqll.toString())
    			   .addScalar("exam_grade_id",IntegerType.INSTANCE)
		           .addScalar("exam_stu_number",IntegerType.INSTANCE)
		           .addScalar("exam_stu_name",StringType.INSTANCE)
		           .addScalar("exam_subject_id",IntegerType.INSTANCE)
		           .addScalar("exam_subject_name", StringType.INSTANCE)
		           .addScalar("exam_grade_point", IntegerType.INSTANCE)
		           .addScalar("exam_grade_time", StringType.INSTANCE)
		           .setParameter("exam_stu_id", gradeVO.getExamStuId())
		           .setResultTransformer(Transformers.aliasToBean(GradeVO.class))
		           .list();
     }
     else{
//    	 System.out.println("2");
    	 list=getSession().createSQLQuery(sqll.toString())
    			.addScalar("exam_grade_id",IntegerType.INSTANCE)
	           .addScalar("exam_stu_number",IntegerType.INSTANCE)
  	           .addScalar("exam_stu_name",StringType.INSTANCE)
  	           .addScalar("exam_subject_id",IntegerType.INSTANCE)
  	           .addScalar("exam_subject_name", StringType.INSTANCE)
  	           .addScalar("exam_grade_point", IntegerType.INSTANCE)
  	           .addScalar("exam_grade_time", StringType.INSTANCE)
  	           .setResultTransformer(Transformers.aliasToBean(GradeVO.class))
  	           .list();
     }
     System.out.println("2");
//     System.out.println(gradeVO.getExam_grade_id());
    	return list;
    }
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<GradeVO> findAllByCondition(String num) {
		PagerModel<GradeVO> pagerModel=new PagerModel<GradeVO>();
		List<GradeVO> dates=new ArrayList<GradeVO>();
		int offset=SystemContext.getOffset();
		int pageSize=SystemContext.getPageSize();
		System.out.println("6");
		String sql="from ExamGrade where examStuId like '%"+num+"%' or examSubjectId like '%"
				+num+"%' or examGradeTime like '%"+num+"%'";
		List<ExamGrade> tempDates=this.getSession().createQuery(sql)
				.setFirstResult(offset)
				.setMaxResults(pageSize)
				.list();
          for(ExamGrade examGrade:tempDates){
        	  GradeVO gradeVO=new GradeVO();
        	  BeanUtils.copyProperties(examGrade, gradeVO);
        	  dates.add(gradeVO);
          }
		   pagerModel.setDates(dates);
		   pagerModel.setOffset(offset);
		   pagerModel.setPageSize(pageSize);
		   System.out.println("7");
		   long totalSize=(long) this.getSession().createQuery("select count(*) from ExamGrade where examStuId like '%"+num+"%' or examSubjectId like '%"
				+num+"%' or examGradeTime like '%"+num+"%'").uniqueResult();
		   pagerModel.setTotalSize(totalSize);
		   return pagerModel;
	}

	@Override
	public GradeVO findByNumber(GradeVO gradeVO) {
		ExamGrade examGrade=(ExamGrade)this.getSession().createQuery("from ExamGrade t where t.examStuId=:examStuId").setParameter("examStuId",(gradeVO.getExamStuId())).uniqueResult();
		GradeVO returnVO=null;
		if(examGrade!=null){
			returnVO=new GradeVO();
			BeanUtils.copyProperties(examGrade, returnVO);
		}
		return returnVO;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserVO> findByStuName(){
		List<UserVO>  user=new ArrayList<UserVO>();
		String hql="from ExamStu t where t.examStuName=:examStuName";
		List<ExamStu> stus=this.getSession().createCriteria(hql).list();
		for(ExamStu examStu:stus){
			UserVO userVO=new UserVO();
			BeanUtils.copyProperties(examStu, userVO);
			user.add(userVO);
		}
		return user;
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeVO> findByCondition(String num,GradeVO gradeVO){
		StringBuffer sqlll=new StringBuffer();
		List<GradeVO> gradelist=new ArrayList<GradeVO>();
		System.out.println("2011");
//		List<GradeVO> list=new ArrayList<GradeVO>();
//		String sql1="select s.exam_stu_number,s.exam_stu_id,s.exam_stu_name,ex.exam_subject_id,ex.exam_subject_name,t.exam_stu_id,t.exam_grade_point,t.exam_grade_time,t.exam_subject_id from exam_grade as t left join exam_stu as s on s.exam_stu_id = t.exam_stu_id right join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id where 1=2";
		String sql2="select s.exam_stu_number,s.exam_stu_id,s.exam_stu_name,ex.exam_subject_id,ex.exam_subject_name,t.exam_stu_id,t.exam_grade_point,t.exam_grade_time,t.exam_subject_id from exam_grade as t left join exam_stu as s on s.exam_stu_id = t.exam_stu_id left join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id where ex.exam_subject_name like '%"+num+"%' or s.exam_stu_number like '%"+num+"%' or s.exam_stu_name like '%"+num+"%' or t.exam_grade_time like '%"+num+"%' ";
        String sql3="select s.exam_stu_number,s.exam_stu_id,s.exam_stu_name,ex.exam_subject_id,ex.exam_subject_name,t.exam_stu_id,t.exam_grade_point,t.exam_grade_time,t.exam_subject_id from exam_grade as t left join exam_stu as s on s.exam_stu_id = t.exam_stu_id left join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id where CONCAT(ex.exam_subject_name,s.exam_stu_number,s.exam_stu_name,t.exam_grade_time)  LIKE'%"+ num+"%'";
/*		sqlll.append("select s.exam_stu_number,s.exam_stu_id,s.exam_stu_name,ex.exam_subject_id,ex.exam_subject_name,t.exam_stu_id,t.exam_grade_point,t.exam_grade_time,t.exam_subject_id from exam_grade as t left join exam_stu as s on s.exam_stu_id = t.exam_stu_id left join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id where ex.exam_subject_name like");
		sqlll.append(" left join exam_stu as s on s.exam_stu_id = t.exam_stu_id");
		sqlll.append(" left join exam_subject as ex on  ex.exam_subject_id= t.exam_subject_id");
		sqlll.append("where ex.exam_subject_name like ");
		sqlll.append(num);
		sqlll.append("or s.exam_stu_number like");
		sqlll.append(num);
		sqlll.append("or s.exam_stu_name like");
		sqlll.append(num);
		sqlll.append("or t.exam_grade_time like");
		sqlll.append(num);*/
		System.out.println("2012");
		try{
		   gradelist=getSession().createSQLQuery(sql3)
	           .addScalar("exam_stu_number",IntegerType.INSTANCE)
	           .addScalar("exam_stu_name",StringType.INSTANCE)
	           .addScalar("exam_subject_id",IntegerType.INSTANCE)
	           .addScalar("exam_subject_name", StringType.INSTANCE)
	           .addScalar("exam_grade_point", IntegerType.INSTANCE)
	           .addScalar("exam_grade_time", StringType.INSTANCE)
//	           .setParameter("exam_stu_id", gradeVO.getExamStuId())
	           .setResultTransformer(Transformers.aliasToBean(GradeVO.class))
	           .list();
		   System.out.println("2013");
			
		}catch(Exception e){
			System.out.println("无法查询");
		}
		return gradelist;
	}
	
	public GradeVO findBystuId(GradeVO gradeVO){
		ExamGrade examGrade=(ExamGrade)this.getSession().createQuery(" from ExamGrade t where t.examSubjectId = :examSubjectId ")
				.setParameter("examSubjectId", gradeVO.getExamSubjectId())
				.uniqueResult();
		
		GradeVO returnVO = null;
		if(examGrade != null){
			returnVO = new GradeVO();
			BeanUtils.copyProperties(examGrade, returnVO);
		}
		return returnVO;
	}
	
}