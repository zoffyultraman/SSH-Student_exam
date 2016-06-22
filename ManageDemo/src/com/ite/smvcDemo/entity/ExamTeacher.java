package com.ite.smvcDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="exam_teacher")
public class ExamTeacher implements Serializable{

	private static final long serialVersionUID= -8426518506388777474L;

	@Id
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "exam_teacher_id",length =10) 
	private Integer examTeacherId;
	
	@Column(name = "exam_teacher_name",length =5,nullable=true) 
	private String examTeacherName;
	
	@Column(name = "exam_teacher_number",length =12,nullable=false) 
	private Integer examTeacherNumber;
	
	@Column(name = "exam_teacher_password",length =12,nullable=false) 
	private String examTeacherPassword;

	public Integer getExamTeacherId() {
		return examTeacherId;
	}

	public void setExamTeacherId(Integer examTeacherId) {
		this.examTeacherId = examTeacherId;
	}

	public String getExamTeacherName() {
		return examTeacherName;
	}

	public void setExamTeacherName(String examTeacherName) {
		this.examTeacherName = examTeacherName;
	}

	public Integer getExamTeacherNumber() {
		return examTeacherNumber;
	}

	public void setExamTeacherNumber(Integer examTeacherNumber) {
		this.examTeacherNumber = examTeacherNumber;
	}

	public String getExamTeacherPassword() {
		return examTeacherPassword;
	}

	public void setExamTeacherPassword(String examTeacherPassword) {
		this.examTeacherPassword = examTeacherPassword;
	}
	
	
	
	
	
}
