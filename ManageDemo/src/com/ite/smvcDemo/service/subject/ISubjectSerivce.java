package com.ite.smvcDemo.service.subject;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamSubject;
import com.ite.smvcDemo.entity.ExamTeacher;

public interface ISubjectSerivce {
	
	public Serializable save(ExamSubject examSubject);
	
	public void update(ExamSubject examSubject);
	
	
	public void updateflag(ExamSubject examSubject);
	
	public void delete(ExamSubject examSubject);
	
	public SubjectVO findByKey(SubjectVO subjectVO);
	
	public UserVO finByNumber(UserVO userVO);
	
//	public SubjectVO finByKeyFlag(SubjectVO subjectVO);
	
	public List<SubjectVO> findAll();
	
	public PagerModel<SubjectVO> findAllByPage();
	
	public List<UserVO> findByStuSubject(String StuNumber,UserVO userVO);

	public SubjectVO findByName(SubjectVO subjectVO);
}
