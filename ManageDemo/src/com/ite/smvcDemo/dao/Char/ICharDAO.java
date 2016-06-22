package com.ite.smvcDemo.dao.Char;

import java.util.List;

import com.ite.smvcDemo.common.vo.Char.CharVO;
import com.ite.smvcDemo.dao.base.IBaseDAO;

public interface ICharDAO  extends IBaseDAO<CharVO>{

	
	
	public List<CharVO> findChar();
}
