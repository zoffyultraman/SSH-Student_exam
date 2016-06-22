package com.ite.smvcDemo.service.titype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.titype.TiTypeVO;
import com.ite.smvcDemo.dao.titype.ITitypeDAO;
import com.ite.smvcDemo.entity.ExamTitype;

@Service
@Transactional
public class Titype implements ITitype {

	@Autowired  /*自动装配*/
	private ITitypeDAO iTitypeDAO;
	 
	@SuppressWarnings("unused")
	@Override
	public List<TiTypeVO> findAll() {
		List<TiTypeVO> returnList=new ArrayList<TiTypeVO>();
		List<ExamTitype> list=iTitypeDAO.findAll();
		for(ExamTitype examTitype:list){
			  TiTypeVO tiTypeVO=new TiTypeVO();
			  BeanUtils.copyProperties(examTitype, tiTypeVO);
			  returnList.add(tiTypeVO);
		}
		return returnList;
	}

	@Override
	public PagerModel<ExamTitype> findAllByPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
