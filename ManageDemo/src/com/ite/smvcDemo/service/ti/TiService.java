package com.ite.smvcDemo.service.ti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.dao.ti.ITiDAO;
import com.ite.smvcDemo.entity.ExamTi;

@Service
@Transactional
public class TiService implements ITiService{

	@Autowired
	private ITiDAO iTiDAO;
	
	
	@Override
	public Serializable save(ExamTi examTi) {
		return iTiDAO.save(examTi);
	}

	@Override
	public void update(ExamTi examTi) {
		iTiDAO.update(examTi);		
	}

	@Override
	public void delete(ExamTi examTi) {
		iTiDAO.delete(examTi);
		
	}

	@Override
	public List<TiVO> findAll() {
		List<TiVO> returnList=new ArrayList<TiVO>();
		List<ExamTi> list = iTiDAO.findAll();
		for(ExamTi examTi:list){
			TiVO tiVO = new TiVO();
			BeanUtils.copyProperties(examTi, tiVO);
     		/*tiVO.setExamTiDifficultyName(examTi.getExamTidifficulty().getExamTiDifficultyName());*/
			/*tiVO.setExamTiTypeName(examTi.getExamTitype().getExamTiTypeName());*/
			returnList.add(tiVO);
		}
		return returnList;
	}

	@Override
	public List<TiVO> FindTiArray(TiVO tiVO){
		return null;
	}
	
	@Override
	public PagerModel<TiVO> findAllByPage() {
		return iTiDAO.findAllByPage();
	}

	@Override
	public TiVO findByNumber(TiVO tiVO) {
		return iTiDAO.findByNumber(tiVO);
	}
	
	@Override
	public TiVO findByKey(TiVO tiVO) {
		ExamTi temp = iTiDAO.findByKey(tiVO.getExamTiId());
		TiVO tempVO = new TiVO();
		BeanUtils.copyProperties(temp, tempVO);
		return tempVO;
	}

	@Override
	public List<TiVO> findByName(TiVO tiVO) {
		return iTiDAO.findByName(tiVO);
	}
	
}
