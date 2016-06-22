package com.ite.smvcDemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="exam_subject")
public class ExamSubject implements Serializable{
	private static final  long serialVersionUID=-8426518506388777474L;
	
	@Id
	@Column(name="exam_subject_id",length=5)
	private Integer examsubjectid;
	
	@Column(name="exam_subject_name",length=15,nullable=true)
	private String examsubjectname;
	
	@Column(name="exam_subject_description",length=50,nullable=true)
	private String  examsubjectdescription;
	
	@Column(name="exam_subject_tnumber",length=5,nullable=true)
	private Integer examsubjecttnumber;
	
	@Column(name="exam_subject_totaltime",length=12,nullable=false)
//	@Temporal(TemporalType.TIMESTAMP)
	private Integer examsubjecttotaltime;
	
	@Column(name="exam_subject_sum",nullable=true)
	private Integer examsubjectsum;
	
	@Column(name="exam_subject_flag",nullable=true)
	private Integer examsubjectflag;
	
	@Column(name="exam_subject_done",nullable=true)
	private Integer examsubjectdone;

	public Integer getExamsubjectid() {
		return examsubjectid;
	}

	public void setExamsubjectid(Integer examsubjectid) {
		this.examsubjectid = examsubjectid;
	}

	public String getExamsubjectname() {
		return examsubjectname;
	}

	public void setExamsubjectname(String examsubjectname) {
		this.examsubjectname = examsubjectname;
	}

	public String getExamsubjectdescription() {
		return examsubjectdescription;
	}

	public void setExamsubjectdescription(String examsubjectdescription) {
		this.examsubjectdescription = examsubjectdescription;
	}

	public Integer getExamsubjecttnumber() {
		return examsubjecttnumber;
	}

	public void setExamsubjecttnumber(Integer examsubjecttnumber) {
		this.examsubjecttnumber = examsubjecttnumber;
	}


	public Integer getExamsubjecttotaltime() {
		return examsubjecttotaltime;
	}

	public void setExamsubjecttotaltime(Integer examsubjecttotaltime) {
		this.examsubjecttotaltime = examsubjecttotaltime;
	}

	public Integer getExamsubjectsum() {
		return examsubjectsum;
	}

	public void setExamsubjectsum(Integer examsubjectsum) {
		this.examsubjectsum = examsubjectsum;
	}

	public Integer getExamsubjectflag() {
		return examsubjectflag;
	}

	public void setExamsubjectflag(Integer examsubjectflag) {
		this.examsubjectflag = examsubjectflag;
	}

	public Integer getExamsubjectdone() {
		return examsubjectdone;
	}

	public void setExamsubjectdone(Integer examsubjectdone) {
		this.examsubjectdone = examsubjectdone;
	}

	
}
