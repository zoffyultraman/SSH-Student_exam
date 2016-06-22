package com.ite.smvcDemo.dao.examStuTi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.entity.ExamStudentSubject;

public interface IExamStuTiDAO  extends IBaseDAO<ExamStuTiVO>{
 
	
	public List<ExamStuTiVO> findExamTi(String num,ExamStuTiVO examStuTiVO);
	

	public TiVO findExamTiMap(Integer num,List<Integer> list);
	
	public HashMap<Integer,ExamStuTiVO> findExamTiMap(String num,ExamStuTiVO examStuTiVO);
	
	public void updatePoint(Integer point,Integer subjectid,Integer stuid);
	
	public void updatestats(Integer subjectid);
	
	
	
	
}
