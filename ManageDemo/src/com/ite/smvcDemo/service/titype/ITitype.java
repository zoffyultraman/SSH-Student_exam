package com.ite.smvcDemo.service.titype;

import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.titype.TiTypeVO;
import com.ite.smvcDemo.entity.ExamTitype;

public interface ITitype {
	public List<TiTypeVO> findAll();
	
	public PagerModel<ExamTitype> findAllByPage();
}
