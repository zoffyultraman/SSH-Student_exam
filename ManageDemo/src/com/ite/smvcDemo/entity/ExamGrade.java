package com.ite.smvcDemo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="exam_grade")
public class ExamGrade implements Serializable{

	private static final long serialVersionUID = -8426518506388777474L;
	
	@Id
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@Column(name = "exam_grade_id",length =5) 
	private Integer examGradeId;

	@Column(name="exam_stu_id" ,length =10 , nullable = true)
	private int examStuId;
	
	@Column(name="exam_subject_id" ,length = 5, nullable = true)
	private int examSubjectId;
	
	@Column(name="exam_grade_point" ,length = 5, nullable = true)
	private int examGradePoint;

	@Column(name="exam_grade_right" ,length = 5, nullable = true)
	private int examGradeRight;
	
	@Column(name="exam_grade_sum" ,length = 5, nullable = true)
	private int examGradeSum;
	
	@Column(name="exam_grade_time" , nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date examGradeTime;
	
	@Column(name="exam_grade_flag" ,length = 5, nullable = true)
	private int examGradeFlag;

	
	
	
	
	public Date getExamGradeTime() {
		return examGradeTime;
	}

	public void setExamGradeTime(Date examGradeTime) {
		this.examGradeTime = examGradeTime;
	}


	
	public Integer getExamGradeId() {
		return examGradeId;
	}

	public void setExamGradeId(Integer examGradeId) {
		this.examGradeId = examGradeId;
	}

	public int getExamStuId() {
		return examStuId;
	}

	public void setExamStuId(int examStuId) {
		this.examStuId = examStuId;
	}

	public int getExamSubjectId() {
		return examSubjectId;
	}

	public void setExamSubjectId(int examSubjectId) {
		this.examSubjectId = examSubjectId;
	}

	public int getExamGradePoint() {
		return examGradePoint;
	}

	public void setExamGradePoint(int examGradePoint) {
		this.examGradePoint = examGradePoint;
	}

	public int getExamGradeRight() {
		return examGradeRight;
	}

	public void setExamGradeRight(int examGradeRight) {
		this.examGradeRight = examGradeRight;
	}

	public int getExamGradeSum() {
		return examGradeSum;
	}

	public void setExamGradeSum(int examGradeSum) {
		this.examGradeSum = examGradeSum;
	}



	public int getExamGradeFlag() {
		return examGradeFlag;
	}

	public void setExamGradeFlag(int examGradeFlag) {
		this.examGradeFlag = examGradeFlag;
	}
	
}