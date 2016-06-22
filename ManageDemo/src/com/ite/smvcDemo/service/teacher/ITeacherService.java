package com.ite.smvcDemo.service.teacher;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamTeacher;

public interface ITeacherService {
	
	public Serializable save(ExamTeacher examTeacher);
	
	public void update(ExamTeacher examTeacher);
	
	public void delete(ExamTeacher examTeacher);
	

	public List<UserVO> findAll();
	
	public PagerModel<UserVO> findAllByPage();
	
	
	public UserVO findByNumber(UserVO userVO);
	
	public List<UserVO> findByRoleId(Integer TeachId,String roleName);
	
	public List<UserVO> findByResource(Integer roleId);
}
