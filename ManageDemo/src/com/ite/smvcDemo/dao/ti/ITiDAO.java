package com.ite.smvcDemo.dao.ti;

import java.io.Serializable;
import java.util.List;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;
import com.ite.smvcDemo.entity.ExamTi;

public interface ITiDAO extends IBaseDAO<ExamTi>{
	public Serializable save(ExamTi examTi);
	
	public void update(ExamTi examTi);
	
	public void delete(ExamTi examTi);
	
	public List<ExamTi> findAll();
	
	public PagerModel<TiVO> findAllByPage();
	
	public TiVO findByNumber(TiVO tiVO);
	
	public List<TiVO> findByName(TiVO tiVO);
}
