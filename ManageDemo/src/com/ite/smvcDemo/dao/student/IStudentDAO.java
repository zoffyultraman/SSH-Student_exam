package com.ite.smvcDemo.dao.student;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamStu;


public interface IStudentDAO extends IBaseDAO<ExamStu> {
	public Serializable save(ExamStu examStu);
	
	public void update(ExamStu examStu);
	
	public void delete(ExamStu examStu);
	
	public List<ExamStu> findAll();
	
	public PagerModel<UserVO> findAllByPage();
	
	public UserVO findByNumber(UserVO userVO);
	
	public List<UserVO> findByRoleId(Integer StuId,String roleName);
	
	public List<UserVO> findByResource(Integer roleId);
}
