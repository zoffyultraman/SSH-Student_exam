package com.ite.smvcDemo.service.tidifficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.tidifficulty.TidifficultyVO;
import com.ite.smvcDemo.dao.tidifficulty.ITidifficultyDAO;
import com.ite.smvcDemo.entity.ExamTidifficulty;

@Service
@Transactional
public class DifficultyService implements IDifficultyService {

	
	@Autowired  /*自动装配*/
	private ITidifficultyDAO  iTidifficultyDAO;
	
	@SuppressWarnings("unused")
	@Override
	public List<TidifficultyVO> findAll() {
		List<TidifficultyVO> returnList = new ArrayList<TidifficultyVO>();
		List<ExamTidifficulty> list = iTidifficultyDAO.findAll();
//		System.out.println(list.get(1).getExamTiDifficultyName());
		for(ExamTidifficulty examTidifficulty : list){
			TidifficultyVO tidifficultyVO = new TidifficultyVO();
			BeanUtils.copyProperties(examTidifficulty, tidifficultyVO);
			returnList.add(tidifficultyVO);
		}
		return returnList;
	}

	
	@Override
	public PagerModel<ExamTidifficulty> findAllByPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
