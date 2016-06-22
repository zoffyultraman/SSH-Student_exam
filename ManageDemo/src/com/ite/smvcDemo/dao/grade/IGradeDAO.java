package com.ite.smvcDemo.dao.grade;

import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.users.*;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamGrade;

public interface IGradeDAO extends IBaseDAO<ExamGrade> {

	
	public PagerModel<GradeVO> findAllByPage();
	
	public List<UserVO> findByStuName();
	
	public PagerModel<GradeVO> findAllByCondition(String num);
	
	public List<GradeVO> findByCondition(String num,GradeVO gradeVO);
	
	public List<GradeVO> findByStuGrade(GradeVO gradeVO,String number);
	
	public List<GradeVO> finByStuId(GradeVO gradeVO);
	
	public GradeVO findByNumber(GradeVO gradeVO);
}
