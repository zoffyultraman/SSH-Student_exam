package com.ite.smvcDemo.dao.examStuTi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamTi;

@Repository("examStuTiDAO")
public class ExamStuTiDAO  extends BaseDAOimp<ExamStuTiVO> implements IExamStuTiDAO  {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExamStuTiVO> findExamTi(String num,ExamStuTiVO examStuTiVO){
		List<ExamStuTiVO> StuTiVO=new ArrayList<ExamStuTiVO>();
		String sql="select t.exam_ti_key,t.exam_subject_id,t.exam_ti_id,t.exam_ti_name,t.exam_ti_optiona,t.exam_ti_optionb,t.exam_ti_optionc,t.exam_ti_optiond,t.exam_ti_point,t.exam_ti_difficulty,t.exam_ti_type,"
				+"b.exam_ti_difficulty,b.exam_ti_difficulty_name,"
                +"p.exam_ti_type,p.exam_ti_type_name,"
                +"n.exam_subject_id,n.exam_subject_name,exam_subject_totaltime,exam_subject_done,"
                +"g.exam_grade_point,g.exam_grade_sum"
                +" from exam_ti AS t"
                +" LEFT JOIN exam_ti_difficulty AS b ON b.exam_ti_difficulty = t.exam_ti_difficulty"
                +" LEFT JOIN exam_ti_type AS p ON p.exam_ti_type = t.exam_ti_type"
                +" LEFT JOIN exam_subject AS n ON n.exam_subject_id = t.exam_subject_id"
                +" LEFT JOIN exam_grade AS g ON g.exam_subject_id =t.exam_subject_id"
                +" WHERE t.exam_subject_id = :num"
                +" order by rand( ) limit 20";
		StuTiVO=getSession().createSQLQuery(sql)
				.addScalar("exam_subject_id",IntegerType.INSTANCE)
				.addScalar("exam_ti_key",StringType.INSTANCE)
				.addScalar("exam_ti_name",StringType.INSTANCE)
				.addScalar("exam_ti_point",IntegerType.INSTANCE)
				.addScalar("exam_ti_optiona",StringType.INSTANCE)
				.addScalar("exam_ti_optionb",StringType.INSTANCE)
				.addScalar("exam_ti_optionc",StringType.INSTANCE)
				.addScalar("exam_ti_optiond",StringType.INSTANCE)
				.addScalar("exam_ti_type",StringType.INSTANCE)
				.addScalar("exam_subject_totaltime",IntegerType.INSTANCE)
				.setParameter("num", Integer.parseInt(num))
			    .setResultTransformer(Transformers.aliasToBean(ExamStuTiVO.class))
				.list();
//		System.out.println("999");
		return StuTiVO;
	}
	
//	public 
	
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<Integer,ExamStuTiVO> findExamTiMap(String num,ExamStuTiVO examStuTiVO){
		HashMap<Integer,ExamStuTiVO> StuTiVO=new HashMap<Integer,ExamStuTiVO>();
		List<ExamStuTiVO> list = new ArrayList<ExamStuTiVO>();
		String sql=" select t.exam_ti_key,t.exam_subject_id,t.exam_ti_id,t.exam_ti_name,t.exam_ti_optiona,t.exam_ti_optionb,t.exam_ti_optionc,t.exam_ti_optiond,t.exam_ti_point,t.exam_ti_difficulty,t.exam_ti_type,"
				+" b.exam_ti_difficulty,b.exam_ti_difficulty_name,"
                +" p.exam_ti_type,p.exam_ti_type_name,"
                +" n.exam_subject_id,n.exam_subject_name,exam_subject_totaltime,exam_subject_done,"
                +" g.exam_grade_point,g.exam_grade_sum"
                +" from exam_ti AS t"
                +" LEFT JOIN exam_ti_difficulty AS b ON b.exam_ti_difficulty = t.exam_ti_difficulty"
                +" LEFT JOIN exam_ti_type AS p ON p.exam_ti_type = t.exam_ti_type"
                +" LEFT JOIN exam_subject AS n ON n.exam_subject_id = t.exam_subject_id"
                +" LEFT JOIN exam_grade AS g ON g.exam_subject_id =t.exam_subject_id"
                +" WHERE t.exam_subject_id = :num"
                +" order by rand() limit 12";
		list=(List<ExamStuTiVO>) getSession().createSQLQuery(sql)
				.addScalar("exam_subject_id",IntegerType.INSTANCE)
				.addScalar("exam_ti_key",StringType.INSTANCE)
				.addScalar("exam_ti_name",StringType.INSTANCE)
				.addScalar("exam_ti_point",IntegerType.INSTANCE)
				.addScalar("exam_ti_optiona",StringType.INSTANCE)
				.addScalar("exam_ti_optionb",StringType.INSTANCE)
				.addScalar("exam_ti_optionc",StringType.INSTANCE)
				.addScalar("exam_ti_optiond",StringType.INSTANCE)
				.addScalar("exam_subject_totaltime",IntegerType.INSTANCE)
				.setParameter("num", Integer.parseInt(num))
			    .setResultTransformer(Transformers.aliasToBean(ExamStuTiVO.class))
				.list();
		
		
		return StuTiVO;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public TiVO findExamTiMap(Integer num,List<Integer> list){
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append(" from ExamTi where examTiDifficulty = :diff ");
		if(list!=null){
		sBuffer.append(" and examTiId not in (:list) ");
		}
		sBuffer.append(" order by rand() ");
		ExamTi ti=(ExamTi) this.getSession()
				.createQuery(sBuffer.toString())
				.setParameter("diff", num)
				.setMaxResults(1)
			    .setParameterList("list", list)
				.uniqueResult()
				;
		
		TiVO tiVO=new TiVO();
		if(ti!=null){
			 String TiName=ti.getExamTiName().replace("\n", "<br/>");
			BeanUtils.copyProperties(ti,tiVO);
			tiVO.setExamTiName(TiName);
		}
		return tiVO;
	}

     public void updatePoint(Integer point,Integer subjectid,Integer stuid){
    	 String sql="update exam_grade SET exam_grade_point = "+point+" WHERE exam_subject_id= "+subjectid+" AND exam_stu_id= "+stuid;
    	 this.getSession().createSQLQuery(sql).executeUpdate();
     }
     
     
     //注意只修改指定科目的科目状态（UPDUSER）
     public void updatestats(Integer subjectid){
    	 int a=1;
    	 String sql="update exam_student_subject SET UPDUSER = "+a+" where exam_subject_id = "+subjectid;
    	 this.getSession().createSQLQuery(sql).executeUpdate();
     }






}
	
