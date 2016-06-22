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
@Table(name="exam_ti_type")
public class ExamTitype implements Serializable{
		
	private static final long serialVersionUID= -8426518506388777474L;
	
		
	@Id
/*	@GeneratedValue(strategy = GenerationType.IDENTITY) */
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@Column(name = "exam_ti_type",length =5,nullable=false)
	private Integer examTiType;

	@Column(name = "exam_ti_type_name",length =20,nullable=true)
	private String examTiTypeName;

	public Integer getExamTiType() {
		return examTiType;
	}

	public void setExamTiType(Integer examTiType) {
		this.examTiType = examTiType;
	}

	public String getExamTiTypeName() {
		return examTiTypeName;
	}

	public void setExamTiTypeName(String examTiTypeName) {
		this.examTiTypeName = examTiTypeName;
	}
	
	
	
	
		
	
}
