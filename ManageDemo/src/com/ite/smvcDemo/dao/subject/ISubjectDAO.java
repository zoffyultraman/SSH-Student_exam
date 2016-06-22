package com.ite.smvcDemo.dao.subject;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamSubject;

public interface ISubjectDAO extends IBaseDAO<ExamSubject>{
	
	public Serializable save(ExamSubject examSubject);
	
	public void update(ExamSubject examStu);
	
	public void updateflag(ExamSubject examSubject);
	
	public void delete(ExamSubject examStu);
	
	public List<ExamSubject> findAll();
	
	public PagerModel<SubjectVO> findAllByPage();
	
	public SubjectVO findByName(SubjectVO subjectVO);
	
	public List<UserVO> findByStuSubject(String Number,UserVO userVO);
	
	public List<UserVO> findByStuId(UserVO userVO);
}
