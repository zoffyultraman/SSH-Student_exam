package com.ite.smvcDemo.controller.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ite.smvcDemo.common.vo.titype.TiTypeVO;
import com.ite.smvcDemo.service.titype.ITitype;

@Controller
public class TypeController {

/*	@Autowired
	private ITitype iTitype;
	
	//题目类型外检表
		public Map<String , String > getType() throws Exception {
			Map<String, String > TypeLabel=new HashMap<String,String>();
			List<TiTypeVO> list=iTitype.findAll();
			for(TiTypeVO tiTypeVO:list){
				TypeLabel.put(String.valueOf(tiTypeVO.getExamTiType()), tiTypeVO.getExamTiTypeName());
			}
			return TypeLabel;
}*/
}
