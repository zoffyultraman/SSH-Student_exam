package com.ite.smvcDemo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="exam_ti")
public class ExamTi implements Serializable{
	
	private static final long serialVersionUID= -8426518506388777474L;

	@Column(name = "exam_subject_id",length =5,nullable=true) 
	private  int examSubjectId;
	
	@Id
/*	@GenericGenerator(name = "persistenceGenerator", strategy = "native") */
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "exam_ti_id",length =5,nullable=false) 
	private Integer examTiId;
	
	@Column(name = "exam_ti_name",length =200,nullable=true) 
	private String  examTiName;
	
	@Column(name = "exam_ti_optiona",length =50,nullable=true) 
	private String examTiOptiona;
	
	@Column(name = "exam_ti_optionb",length =50,nullable=true) 
	private String examTiOptionb;

	@Column(name = "exam_ti_optionc",length =50,nullable=true) 
	private String examTiOptionc;
	
	@Column(name = "exam_ti_optiond",length =50,nullable=true) 
	private String examTiOptiond;
	
	@Column(name = "exam_ti_key",length =50,nullable=true) 
	private String examTiKey;
	
	@Column(name = "exam_ti_point",length =5,nullable=true) 
	private Integer examTiPoint;
	
	
/*    @ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="examTiDifficulty", referencedColumnName="examTiDifficulty", insertable = false, updatable = false)
	private ExamTidifficulty examTidifficulty;*/
	
	@Column(name = "exam_ti_difficulty",length =5,nullable=true) 
	private Integer examTiDifficulty;
	
	/*@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="examTiType", referencedColumnName="examTiType", insertable = false, updatable = false)
	private ExamTitype examTitype;
*/
	@Column(name = "exam_ti_type",length =5,nullable=true) 
	private Integer examTiType;
	
	
/*	
	public ExamTidifficulty getExamTidifficulty() {
		return examTidifficulty;
	}

	public void setExamTidifficulty(ExamTidifficulty examTidifficulty) {
		this.examTidifficulty = examTidifficulty;
	}
*/
	public Integer getExamTiDifficulty() {
		return examTiDifficulty;
	}

	public void setExamTiDifficulty(Integer examTiDifficulty) {
		this.examTiDifficulty = examTiDifficulty;
	}

	public int getExamSubjectId() {
		return examSubjectId;
	}

	public void setExamSubjectId(int examSubjectId) {
		this.examSubjectId = examSubjectId;
	}

	public Integer getExamTiId() {
		return examTiId;
	}

	public void setExamTiId(Integer examTiId) {
		this.examTiId = examTiId;
	}

	public String getExamTiName() {
		return examTiName;
	}

	public void setExamTiName(String examTiName) {
		this.examTiName = examTiName;
	}

	public String getExamTiOptiona() {
		return examTiOptiona;
	}

	public void setExamTiOptiona(String examTiOptiona) {
		this.examTiOptiona = examTiOptiona;
	}

	public String getExamTiOptionb() {
		return examTiOptionb;
	}

	public void setExamTiOptionb(String examTiOptionb) {
		this.examTiOptionb = examTiOptionb;
	}

	public String getExamTiOptionc() {
		return examTiOptionc;
	}

	public void setExamTiOptionc(String examTiOptionc) {
		this.examTiOptionc = examTiOptionc;
	}

	public String getExamTiOptiond() {
		return examTiOptiond;
	}

	public void setExamTiOptiond(String examTiOptiond) {
		this.examTiOptiond = examTiOptiond;
	}

	public String getExamTiKey() {
		return examTiKey;
	}

	public void setExamTiKey(String examTiKey) {
		this.examTiKey = examTiKey;
	}

	public Integer getExamTiPoint() {
		return examTiPoint;
	}

	public void setExamTiPoint(Integer examTiPoint) {
		this.examTiPoint = examTiPoint;
	}

/*	public Integer getExamTiDifficulty() {
		return examTiDifficulty;
	}

	public void setExamTiDifficulty(Integer examTiDifficulty) {
		this.examTiDifficulty = examTiDifficulty;
	}*/
	

	public Integer getExamTiType() {
		return examTiType;
	}
/*
	public ExamTidifficulty getExamTidifficulty() {
		return examTidifficulty;
	}

	public void setExamTidifficulty(ExamTidifficulty examTidifficulty) {
		this.examTidifficulty = examTidifficulty;
	}*/

	public void setExamTiType(Integer examTiType) {
		this.examTiType = examTiType;
	}

/*
	public ExamTidifficulty getExamTidifficulty() {
		return examTidifficulty;
	}

	public void setExamTidifficulty(ExamTidifficulty examTidifficulty) {
		this.examTidifficulty = examTidifficulty;
	}*/

/*	public ExamTitype getExamTitype() {
		return examTitype;
	}

	public void setExamTitype(ExamTitype examTitype) {
		this.examTitype = examTitype;
	}*/


	
	
	
}
