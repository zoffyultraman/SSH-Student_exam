package com.ite.smvcDemo.dao.tidifficulty;

import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamTidifficulty;

@Repository("tidifficultyDAOImp") /* @Repository用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean*/
public class TidifficultyDAOImp extends BaseDAOimp<ExamTidifficulty> implements ITidifficultyDAO {

}
