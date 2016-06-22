package com.ite.smvcDemo.service.teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.teacher.ITeacherDAO;
import com.ite.smvcDemo.entity.ExamTeacher;

@Service
@Transactional
public class TeacherService implements ITeacherService {
	
	@Autowired
	private ITeacherDAO iTeacherDAO;
	
	@Override
	public List<UserVO> findAll() {
		List<UserVO> returnList = new ArrayList<UserVO>();
		List<ExamTeacher> list = iTeacherDAO.findAll();
		for(ExamTeacher examTeacher : list){
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(examTeacher, userVO);
			returnList.add(userVO);
		}
		return returnList;

	}

	@Override
	public PagerModel<UserVO> findAllByPage() {
		return iTeacherDAO.findAllByPage();
	}

	@Override
	public UserVO findByNumber(UserVO userVO) {
		return iTeacherDAO.findByNumber(userVO);
	}

	@Override
	public Serializable save(ExamTeacher examTeacher) {
		return iTeacherDAO.save(examTeacher);
	}

	@Override
	public void update(ExamTeacher examTeacher) {
		iTeacherDAO.update(examTeacher);
	}

	@Override
	public void delete(ExamTeacher examTeacher) {
		iTeacherDAO.delete(examTeacher);
		
	}

	@Override
	public List<UserVO> findByRoleId(Integer TeachId, String roleName) {
		// TODO Auto-generated method stub
		return iTeacherDAO.findByRoleId(TeachId, roleName);
	}

	@Override
	public List<UserVO> findByResource(Integer roleId) {
		// TODO Auto-generated method stub
		return iTeacherDAO.findByResource(roleId);
	}
}
