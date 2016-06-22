package com.ite.smvcDemo.service.stu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.student.IStudentDAO;
import com.ite.smvcDemo.entity.ExamStu;

@Service
@Transactional
public class StuService implements IStuService {

	@Autowired
	private IStudentDAO iStudentDAO;
	
	
	
	@Override
	public List<UserVO> findAll() {
		List<UserVO> returnList = new ArrayList<UserVO>();
		List<ExamStu> list = iStudentDAO.findAll();
		for(ExamStu stu : list){
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(stu, userVO);
			returnList.add(userVO);
		}
		System.out.println(returnList);
		return returnList;
		
	}
	
/*	@Override
	public List<UserVO> findAllIstu(String istuid) {
		List<UserVO> returnList = new ArrayList<UserVO>();
		List<ExamStu> list = iStudentDAO.findAll();
		for(ExamStu stu : list){
			if(istuid==){
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(stu, userVO);
			userVO.setExamTeacherId(examTeacherId);
			returnList.add(userVO);
			}
		}
		return returnList;
	}*/
	

	@Override
	public UserVO findByKey(UserVO userVO) {
		ExamStu temp = iStudentDAO.findByKey(userVO.getExamStuId());
		UserVO tempVO = new UserVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}
	@Override
	public PagerModel<UserVO> findAllByPage() {
		return iStudentDAO.findAllByPage();
	}

	@Override
	public UserVO findByNumber(UserVO userVO) {
		return iStudentDAO.findByNumber(userVO);
	}

	@Override
	public Serializable save(ExamStu stu) {
		return iStudentDAO.save(stu);
	}

	@Override
	public void update(ExamStu stu) {
         iStudentDAO.update(stu);		
	}

	@Override
	public void delete(ExamStu stu) {
        iStudentDAO.delete(stu);
	
	}

	@Override
	public List<UserVO> findByRoleId(Integer StuId, String roleName) {
		return iStudentDAO.findByRoleId(StuId, roleName);
	}

	@Override
	public List<UserVO> findByResource(Integer roleId) {
		return iStudentDAO.findByResource(roleId);
	}


	

}
