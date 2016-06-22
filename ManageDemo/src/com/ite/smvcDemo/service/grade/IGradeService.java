package com.ite.smvcDemo.service.grade;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamGrade;

public interface IGradeService {
	public Serializable save(ExamGrade examGrade);
	
	public void update(ExamGrade examGrade);
	
	public void delete(ExamGrade examGrade);
	

//	public List<UserVO> findByStuName();
	
	public List<Integer> findAll();
	
	public PagerModel<GradeVO> findAllByPage();
	
	public List<GradeVO> findByCondition(String num,GradeVO grade);
	
	public GradeVO findByKey(GradeVO gradeVO);
	
	public List<GradeVO> findByStuId(GradeVO gradeVO);
	
	public GradeVO findByNumber(GradeVO gradeVO);

	PagerModel<GradeVO> findAllByCondition(String num);
	
	
	public List<GradeVO> findByStuGrade(GradeVO gradeVO,String number);
}
