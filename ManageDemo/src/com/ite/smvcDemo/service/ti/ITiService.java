package com.ite.smvcDemo.service.ti;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.entity.ExamTi;

public interface ITiService {

	public Serializable save(ExamTi examTi);
	
	public void update(ExamTi examTi);
	
	public void delete(ExamTi examTi);
	

	public List<TiVO> findAll();
	
	public PagerModel<TiVO> findAllByPage();
	
	public TiVO findByKey(TiVO tiVO);

	
	public TiVO findByNumber(TiVO tiVO);
	
	public List<TiVO> findByName(TiVO tiVO);
	
	public List<TiVO> FindTiArray(TiVO tiVO);
	
}
