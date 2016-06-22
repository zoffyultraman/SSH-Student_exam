package com.ite.smvcDemo.service.Char;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.vo.Char.CharVO;
import com.ite.smvcDemo.dao.Char.CharDAO;

@Service
@Transactional
public class CharSevice implements ICharService {

	@Autowired
	private CharDAO charDAO;
	
	@Override
	public List<CharVO> findChar() {
		return charDAO.findChar();
	}

}
