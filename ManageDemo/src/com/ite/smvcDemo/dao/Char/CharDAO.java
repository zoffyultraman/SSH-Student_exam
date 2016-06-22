package com.ite.smvcDemo.dao.Char;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.common.vo.Char.CharVO;
import com.ite.smvcDemo.dao.base.BaseDAOimp;


@Repository("ICharDAO")
public class CharDAO extends BaseDAOimp<CharVO> implements ICharDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<CharVO> findChar() {
		List<CharVO> charList=new ArrayList<CharVO>();
		String sql="select * from `case` ";
		charList = getSession().createSQLQuery(sql)
				    .addScalar("area",StringType.INSTANCE)
				    .addScalar("comNum",IntegerType.INSTANCE)
				    .addScalar("Num",IntegerType.INSTANCE)
				    .setResultTransformer(Transformers.aliasToBean(CharVO.class))
				    .list();
		return charList;
	}

}
