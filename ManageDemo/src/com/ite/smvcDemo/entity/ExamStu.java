package com.ite.smvcDemo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="exam_stu",uniqueConstraints={@UniqueConstraint(columnNames="exam_stu_number")})
public class ExamStu implements Serializable{
	
	
	private static final long serialVersionUID = -8426518506388777474L;
	
	
	@Id
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "exam_stu_id",length =15,nullable=false) 
	private Integer examStuId;
	
	
	@Column(name="exam_stu_name" ,length =12 , nullable = true)
	private String examStuName;
	
	@Column(name="exam_stu_number" ,length =12 , nullable = false)
	private String examStuNumber;
	
	@Column(name="exam_stu_password" ,length =200 , nullable = false)
	
	private String examStuPassword;
	
	@Column(name="exam_stu_sex" ,length =7 , nullable = true)
	private String examstuSex;
	
	@Column(name="exam_stu_birthday" ,length =15 , nullable = true)
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date examStuBirthday;
	


	@Column(name="exam_stu_tel" ,length =15 , nullable = true)
	private String examStuTel;
	
	@Column(name="exam_stu_address" ,length =25 , nullable = true)
	private String examStuAddress;
	
	@Column(name="exam_stu_done" ,length =5 , nullable = true)
	private int examStuDone;

	public Date getExamStuBirthday() {
		return examStuBirthday;
	}

	public void setExamStuBirthday(Date examStuBirthday) {
		this.examStuBirthday = examStuBirthday;
	}
	
	public Integer getExamStuId() {
		return examStuId;
	}

	public void setExamStuId(Integer examStuId) {
		this.examStuId = examStuId;
	}

	public String getExamStuName() {
		return examStuName;
	}

	public void setExamStuName(String examStuName) {
		this.examStuName = examStuName;
	}

	public String getExamStuNumber() {
		return examStuNumber;
	}

	public void setExamStuNumber(String examStuNumber) {
		this.examStuNumber = examStuNumber;
	}

	public String getExamStuPassword() {
		return examStuPassword;
	}

	public void setExamStuPassword(String examStuPassword) {
		this.examStuPassword = examStuPassword;
	}

	public String getExamstuSex() {
		return examstuSex;
	}

	public void setExamstuSex(String examstuSex) {
		this.examstuSex = examstuSex;
	}


	public String getExamStuTel() {
		return examStuTel;
	}

	public void setExamStuTel(String examStuTel) {
		this.examStuTel = examStuTel;
	}

	public String getExamStuAddress() {
		return examStuAddress;
	}

	public void setExamStuAddress(String examStuAddress) {
		this.examStuAddress = examStuAddress;
	}

	public int getExamStuDone() {
		return examStuDone;
	}

	public void setExamStuDone(int examStuDone) {
		this.examStuDone = examStuDone;
	}


	
	
}
