package com.ite.smvcDemo.controller.Difficulty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.ite.smvcDemo.common.vo.tidifficulty.TidifficultyVO;
import com.ite.smvcDemo.service.tidifficulty.IDifficultyService;
public class DifficultyController {

	@Autowired
	private IDifficultyService iDifficultyService;
	
	
	//题目难度外键表
	public Map<String,String> getDifficulty() throws Exception {
		Map<String,String> DifficultyLabel = new HashMap<String,String>();
		List<TidifficultyVO> list = iDifficultyService.findAll();
		for(TidifficultyVO tidifficultyVO : list){
			DifficultyLabel.put(String.valueOf(tidifficultyVO.getExamTiDifficulty()), tidifficultyVO.getExamTiDifficultyName());
		}
		return DifficultyLabel;
	}
}
