package test.junit.dao;

import java.util.Date;

import javax.security.auth.Subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ite.smvcDemo.dao.grade.IGradeDAO;
import com.ite.smvcDemo.dao.student.IStudentDAO;
import com.ite.smvcDemo.dao.studentsubject.IStudentSubjectDAO;
import com.ite.smvcDemo.dao.subject.ISubjectDAO;
import com.ite.smvcDemo.dao.teacher.ITeacherDAO;
import com.ite.smvcDemo.dao.ti.ITiDAO;
import com.ite.smvcDemo.dao.tidifficulty.ITidifficultyDAO;
import com.ite.smvcDemo.dao.titype.ITitypeDAO;
import com.ite.smvcDemo.entity.ExamSubject;
import com.ite.smvcDemo.entity.ExamTi;
import com.ite.smvcDemo.entity.ExamTidifficulty;
import com.ite.smvcDemo.entity.ExamTitype;

import test.junit.dao.base.JUnitTestBase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-config.xml"})
public class TeacherDAOTest extends JUnitTestBase{

	@Autowired
//	private ITeacherDAO iTeacherDAO;
//	private IStudentDAO iStudentDAO;
//	private IGradeDAO iGradeDAO;
//    private IStudentSubjectDAO iStudentSubjectDAO;
//	private ISubjectDAO iSubjectDAO;
//	private ITiDAO iTiDAO;
//	private ITidifficultyDAO ITidifficultyDAO;
	private ITitypeDAO iTitypeDAO;
	
	
/*	@Test
    public void testFindAll() {
		
		Teacher teacher=new Teacher();
		teacher.setExamTeacherName("Deft");
		teacher.setExamTeacherNumber(1002);
		teacher.setExamTeacherPassword("123");
		iTeacherDAO.save(teacher);
		
*/
	
	
/*	@Test
	public void test(){
		Stu stu=new Stu();
//		stu.setExamStuId(1);
		stu.setExamStuName("Dean");
		stu.setExamStuNumber("16");
		stu.setExamStuPassword("123");
		stu.setExamstuSex("男");
		stu.setExamStuBirthday("2016-01-19");
		stu.setExamStuTel("16");
		stu.setExamStuDone(5);
		stu.setExamStuAddress("16");
	    iStudentDAO.save(stu);
		
	}*/
	/*@Test
	public void test(){
		Grade grade=new Grade();
		grade.setExamGradeId(1);
		grade.setExamStuId(1);
		grade.setExamSubjectId(1);
		grade.setExamGradePoint(1);
		grade.setExamGradeRight(1);
		grade.setExamGradeSum(1);
		grade.setExamGradeTime(new Date());
		grade.setExamGradeFlag(1);
		iGradeDAO.save(grade);
	}*/
/*	@Test
	public void test(){
		StudentSubject  studentsubject=new StudentSubject();
		studentsubject.setExamSubjectId(1);
		studentsubject.setExamStudentSubjectId(1);
		studentsubject.setExamStuId(1);
		iStudentSubjectDAO.save(studentsubject);
		
	}*/
/*	@Test
	public void test(){
		ExamSubject subject=new ExamSubject();
		subject.setExamsubjectid(1);
		subject.setExamsubjectname("Deft");
		subject.setExamsubjectdescription("D");
		subject.setExamsubjecttnumber(1);
		subject.setExamsubjecttotaltime(new Date());
		subject.setExamsubjectsum(1);
	    subject.setExamsubjectflag(1);
	    subject.setExamsubjectdone(1);
	    iSubjectDAO.save(subject);
	
	
	}*/
/*	@Test
	public void test(){
		ExamTi ti=new ExamTi();
		ti.setExamSubjectId(1);
		ti.setExamTiId(1);
		ti.setExamTiName("deft");
		ti.setExamTiOptiona("1");
		ti.setExamTiOptionb("1");
		ti.setExamTiOptionc("1");
		ti.setExamTiOptiond("1");
		ti.setExamTiKey("1");
		ti.setExamTiPoint(1);
		ti.setExamTiDifficulty(1);
		ti.setExamTiType(1);
		iTiDAO.save(ti);
		
	}*/
/*	@Test
	public void test(){
		ExamTidifficulty tidi=new ExamTidifficulty();
     	tidi.setExamTiDifficulty(4);
		tidi.setExamTiDifficultyName("4");
		ITidifficultyDAO.save(tidi);
	}*/
	@Test
	public void test(){
		ExamTitype titype=new ExamTitype();
		titype.setExamTiType(2);
		titype.setExamTiTypeName("2");
		iTitypeDAO.save(titype);
	}
	
	
	
}
