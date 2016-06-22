package com.ite.smvcDemo.service.subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.subject.SubjectVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.subject.ISubjectDAO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamSubject;
import com.ite.smvcDemo.entity.ExamTi;

@Service
@Transactional
public class SubjectSerivce implements ISubjectSerivce{
	
	@Autowired
	private ISubjectDAO iSubjectDAO;
	
	@Override
	public List<SubjectVO> findAll() {
		List<SubjectVO> returnList = new ArrayList<SubjectVO>();
		List<ExamSubject> list = iSubjectDAO.findAll();
		for(ExamSubject examSubject : list){
			SubjectVO subjectVO = new SubjectVO();
			BeanUtils.copyProperties(examSubject, subjectVO);
			returnList.add(subjectVO);
		}
		return returnList;

	}

	@Override
	public PagerModel<SubjectVO> findAllByPage() {
		return iSubjectDAO.findAllByPage();
	}

	@Override
	public SubjectVO findByName(SubjectVO subjectVO) {
		return iSubjectDAO.findByName(subjectVO);
	}

	@Override
	public Serializable save(ExamSubject examSubject) {
		return iSubjectDAO.save(examSubject);
	}

	@Override
	public void update(ExamSubject examSubject) {
		iSubjectDAO.update(examSubject);
		
	}

	@Override
	public void delete(ExamSubject examSubject) {
		iSubjectDAO.delete(examSubject);		
	}

	@Override
	public void updateflag(ExamSubject examSubject) {
		iSubjectDAO.updateflag(examSubject);
	}
	
	
	@Override
	public SubjectVO findByKey(SubjectVO subjectVO) {
		ExamSubject temp = iSubjectDAO.findByKey(subjectVO.getExamsubjectid());
		SubjectVO tempVO = new SubjectVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}
	
	@Override
	public UserVO finByNumber(UserVO userVO){
		ExamSubject temp=iSubjectDAO.findByKey(userVO.getExamStuId());
		UserVO tempVO=new UserVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}
	
	public List<UserVO> findByStuSubject(String StuNumber,UserVO userVO){
		return iSubjectDAO.findByStuSubject(StuNumber, userVO);
	}
}
