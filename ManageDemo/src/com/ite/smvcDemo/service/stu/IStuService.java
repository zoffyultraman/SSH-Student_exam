package com.ite.smvcDemo.service.stu;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.entity.ExamStu;

public interface IStuService {

	public Serializable save(ExamStu stu);
	
	public void update(ExamStu stu);
	
	public void delete(ExamStu stu);
	
	public List<UserVO> findAll();
	
//	public List<UserVO> findAllIstu(String istuid);
	
	public PagerModel<UserVO> findAllByPage();
	
	public UserVO findByKey(UserVO userVO);
	
	public UserVO findByNumber(UserVO userVO);
	
	public List<UserVO> findByRoleId(Integer StuId,String roleName);
	
	public List<UserVO> findByResource(Integer roleId);
	
	
	
	
	
	
	
	
}
