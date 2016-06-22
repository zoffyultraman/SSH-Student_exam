package com.ite.smvcDemo.dao.ti;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.page.SystemContext;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamTeacher;
import com.ite.smvcDemo.entity.ExamTi;

@Repository("iTiDAOImp")
public class ITiDAOImp extends BaseDAOimp<ExamTi> implements ITiDAO {

	@SuppressWarnings("unchecked")
	@Override
	public PagerModel<TiVO> findAllByPage() {
		PagerModel<TiVO> page = new PagerModel<TiVO>();
		List<TiVO> dates = new ArrayList<TiVO> ();
		int offset = SystemContext.getOffset();
		int pageSize = SystemContext.getPageSize();
		
		//使用hibernate完成分页
		List<ExamTi> tempDates = this.getSession().createQuery("from ExamTi ")
		.setFirstResult(offset)
		.setMaxResults(pageSize)
		.list();
		
		for(ExamTi examTi : tempDates){
			TiVO tiVO = new TiVO();
			System.out.println("2");
//			System.out.println(examTi.getExamTiName());
//			String Name=examTi.getExamTiName();
//			Name.replace("\n","<br>>");
//			System.out.println(Name);
//		    BeanUtils.copyProperties(examTi, tiVO);
			tiVO.setExamSubjectId(examTi.getExamSubjectId());
			tiVO.setExamTiId(examTi.getExamTiId());
			tiVO.setExamTiName(examTi.getExamTiName().replace("\n","<br>"));
			tiVO.setExamTiKey(examTi.getExamTiKey());
			tiVO.setExamTiPoint(examTi.getExamTiPoint());
			tiVO.setExamTiDifficulty(examTi.getExamTiDifficulty());
			
/*			usersVO.setRoleName(role.getRole().getRoleName());*/
			dates.add(tiVO);
		}
		
		page.setDates(dates);
		page.setOffset(offset);
		page.setPageSize(pageSize);
		
		//获取总记录数
		long totalSize =  (long) this.getSession().createQuery("select count(*) from ExamTi ").uniqueResult();
		page.setTotalSize(totalSize);
		return page;
	}

	@Override
	public TiVO findByNumber(TiVO tiVO) {
		ExamTi examTi = (ExamTi) this.getSession().createQuery(" from ExamTi t where t.examTiName = :examTiName ").setParameter("examTiName", Integer.parseInt(tiVO.getExamTiName())).uniqueResult();
		TiVO returnVO = null;
		if(examTi != null){
			returnVO = new TiVO();
			BeanUtils.copyProperties(examTi, returnVO);
		}
		return returnVO;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TiVO> findByName(TiVO tiVO){
		String sql="select exam_ti_name from exam_grade ";
		List<TiVO> list=new ArrayList<TiVO>();
		list=getSession().createSQLQuery(sql)
				.addScalar("exam_ti_name",StringType.INSTANCE)
		        .setResultTransformer(Transformers.aliasToBean(TiVO.class))
				.list();
		return list;
		
	}
}

