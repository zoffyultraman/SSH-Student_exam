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
@Table(name="exam_ti_difficulty")
public class ExamTidifficulty implements Serializable{
		
		private static final long serialVersionUID= -8426518506388777474L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
		@Column(name = "exam_ti_difficulty",length =5,nullable=true) 
		private Integer examTiDifficulty;
		
		@Column(name = "exam_ti_difficulty_name",length =25,nullable=true) 
		private String examTiDifficultyName;

		public Integer getExamTiDifficulty() {
			return examTiDifficulty;
		}

		public void setExamTiDifficulty(Integer examTiDifficulty) {
			this.examTiDifficulty = examTiDifficulty;
		}

		public String getExamTiDifficultyName() {
			return examTiDifficultyName;
		}

		public void setExamTiDifficultyName(String examTiDifficultyName) {
			this.examTiDifficultyName = examTiDifficultyName;
		}
		
		
		
		
}
