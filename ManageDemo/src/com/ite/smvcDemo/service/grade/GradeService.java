package com.ite.smvcDemo.service.grade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Array;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.grade.GradeVO;
import com.ite.smvcDemo.common.vo.users.UserVO;
import com.ite.smvcDemo.dao.grade.IGradeDAO;
import com.ite.smvcDemo.entity.ExamGrade;
import com.ite.smvcDemo.entity.ExamStu;
import com.ite.smvcDemo.service.stu.IStuService;

@Service
@Transactional
public class GradeService implements IGradeService {

	@Autowired
	private IGradeDAO iGradeDAO;
	
	@Autowired
	private IStuService iStuService;
	
	@Override
	public Serializable save(ExamGrade examGrade) {
		return iGradeDAO.save(examGrade);
	}

	@Override
	public void update(ExamGrade examGrade) {
		iGradeDAO.update(examGrade);
		
	}

	
	@Override
	public void delete(ExamGrade examGrade) {
		iGradeDAO.delete(examGrade);
		
	}

	@SuppressWarnings("unused")
	@Override
	public List<Integer> findAll() {
		List<GradeVO> returnList=new ArrayList<GradeVO>();
		List<ExamGrade> Gradelist=iGradeDAO.findAll();
		List<UserVO> StuList=iStuService.findAll();
		List<Integer> StuName=new ArrayList<Integer>();
		Integer a = null;
		for(ExamGrade examGrade:Gradelist){
			GradeVO gradeVO=new GradeVO();
//			BeanUtils.copyProperties(examGrade, gradeVO);
			UserVO userVO=new UserVO();
			if(gradeVO.getExamStuId()==userVO.getExamStuId()){
				
			gradeVO.setExamStuId(Integer.valueOf(userVO.getExamStuName()));
			StuName.add(gradeVO.getExamStuId());
			}
//			returnList.add(StuName);
		}
		return StuName;
	}
	
	

	@Override
	public PagerModel<GradeVO> findAllByPage() {
		return iGradeDAO.findAllByPage();
	}

	@Override
	public GradeVO findByKey(GradeVO gradeVO) {
		 ExamGrade temp=iGradeDAO.findByKey(gradeVO.getExamGradeId());
		 GradeVO tempVO=new GradeVO();
		 BeanUtils.copyProperties(temp, tempVO);
		 return tempVO;
	}

	@Override
	public GradeVO findByNumber(GradeVO gradeVO) {
		return iGradeDAO.findByNumber(gradeVO);
	}

	@Override
	public PagerModel<GradeVO> findAllByCondition(String num) {
		return iGradeDAO.findAllByCondition(num);
	}

	@Override
	public List<GradeVO> findByStuId(GradeVO gradeVO) {
		return iGradeDAO.finByStuId(gradeVO);
	}

	@Override
	public List<GradeVO> findByCondition(String num,GradeVO gradeVO) {
		return iGradeDAO.findByCondition(num, gradeVO);
	}

/*	@Override
	public List<UserVO> findByStuName() {
		return iGradeDAO.findByStuName();
	}
*/	
	
	//题目难度外键表
/*	protected Map<Integer,String> getStu() throws Exception {
		Map<Integer,String> iStuLabel = new HashMap<Integer,String>();
		List<GradeVO> list = gradeService.findAll();
		for(UserVO userVO : list){
			iStuLabel.put(userVO.getExamStuId(),userVO.getExamStuName());
//			}
		}
		return iStuLabel;
	}*/
	
	
	public List<GradeVO> findByStuGrade(GradeVO gradeVO,String number){
		return iGradeDAO.findByStuGrade(gradeVO, number);
	}
	
	
	
	
	
	
	
	
	

}
