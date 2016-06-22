package com.ite.smvcDemo.dao.titype;

import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamTitype;

@Repository("titypeDAOImp")
public class TitypeDAOImp  extends BaseDAOimp<ExamTitype> implements ITitypeDAO {

}
