package com.ite.smvcDemo.service.examStu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.entity.ExamStu;

public interface IStuTiService {
	public Serializable save(ExamStuTiVO stuTi);
	
	public void update(ExamStuTiVO stuTi);
	
	public void delete(ExamStuTiVO stuTi);
	
	public List<ExamStuTiVO> findAll();
	
	public ExamStuTiVO findByKey(ExamStuTiVO stuTi);
	
	public ExamStuTiVO findByNumber(ExamStuTiVO stuTi);
	
	public List<ExamStuTiVO> findExamTi(String num,ExamStuTiVO examStuTiVO);
	
	public TiVO findExamTiMap(Integer num,List<Integer> list);
	
	public void updatePoint(Integer point,Integer subjectid,Integer stuid);
	
	public HashMap<Integer,ExamStuTiVO> findExamTiMap(String num,ExamStuTiVO examStuTiVO);

	public void updatestats(Integer subjectid);
}
