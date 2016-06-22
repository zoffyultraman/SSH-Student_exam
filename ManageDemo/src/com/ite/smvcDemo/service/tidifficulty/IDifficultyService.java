package com.ite.smvcDemo.service.tidifficulty;

import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.tidifficulty.TidifficultyVO;
import com.ite.smvcDemo.entity.ExamTidifficulty;

public interface IDifficultyService {

	public List<TidifficultyVO> findAll();
	
	public PagerModel<ExamTidifficulty> findAllByPage();
}
