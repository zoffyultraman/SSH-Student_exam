package com.ite.smvcDemo.dao.studentsubject;


import org.springframework.stereotype.Repository;

import com.ite.smvcDemo.dao.base.BaseDAOimp;
import com.ite.smvcDemo.entity.ExamStudentSubject;

@Repository("studentSubjectDAOImp")
public class StudentSubjectDAOImp  extends BaseDAOimp<ExamStudentSubject> implements IStudentSubjectDAO {

}
