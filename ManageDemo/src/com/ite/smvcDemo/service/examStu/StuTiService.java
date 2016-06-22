package com.ite.smvcDemo.service.examStu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.examStuTi.ExamStuTiDAO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamTi;

@Service
@Transactional
public class StuTiService implements IStuTiService {
	
	@Autowired
	private ExamStuTiDAO examStuTiDAO;

	@Override
	public Serializable save(ExamStuTiVO stuTi) {
		return examStuTiDAO.save(stuTi);
	}

	@Override
	public void update(ExamStuTiVO stuTi) {
		examStuTiDAO.update(stuTi);
	}

	@Override
	public void delete(ExamStuTiVO stuTi) {
		examStuTiDAO.delete(stuTi);		
	}

	@Override
	public List<ExamStuTiVO> findAll() {
		return examStuTiDAO.findAll();
	}
	@Override
	public ExamStuTiVO findByKey(ExamStuTiVO stuTi) {
		ExamStuTiVO temp = examStuTiDAO.findByKey(stuTi.getExam_subject_id());
		ExamStuTiVO tempVO = new ExamStuTiVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}

	@Override
	public ExamStuTiVO findByNumber(ExamStuTiVO stuTi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamStuTiVO> findExamTi(String num, ExamStuTiVO examStuTiVO) {
		return examStuTiDAO.findExamTi(num, examStuTiVO);
	}

	@Override
	public TiVO findExamTiMap(Integer num, List<Integer> list) {
		return examStuTiDAO.findExamTiMap(num, list);
	}

	@Override
	public HashMap<Integer, ExamStuTiVO> findExamTiMap(String num, ExamStuTiVO examStuTiVO) {
		return examStuTiDAO.findExamTiMap(num, examStuTiVO);
	}

	public void updatePoint(Integer point,Integer subjectid,Integer stuid){
		examStuTiDAO.updatePoint(point, subjectid, stuid);
	}

	public void updatestats(Integer subjectid){
		examStuTiDAO.updatestats(subjectid);
	}
}
