package com.ite.smvcDemo.dao.teacher;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.role.RoleVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamTeacher;
import com.ite.smvcDemo.entity.role.Role;


public interface ITeacherDAO extends IBaseDAO<ExamTeacher>{
	public Serializable save(ExamTeacher examTeacher);
	
	public void update(ExamTeacher examTeacher);
	
	public void delete(ExamTeacher examTeacher);
	
	public List<ExamTeacher> findAll();
	
	public PagerModel<UserVO> findAllByPage();
	
	public UserVO findByNumber(UserVO userVO);
	
	public List<UserVO> findByRoleId(Integer TeachId,String roleName);
	
	public List<UserVO> findByResource(Integer roleId);
}
