package com.ite.smvcDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamStudentSubjectId  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="exam_subject_id",length=15)
	private Integer examSubjectId;
	
	@Column(name="exam_stu_id",length=15)
	private Integer examStuId;

	public int getExamSubjectId() {
		return examSubjectId;
	}

	public void setExamSubjectId(Integer examSubjectId) {
		this.examSubjectId = examSubjectId;
	}

	public Integer getExamStuId() {
		return examStuId;
	}

	public void setExamStuId(Integer examStuId) {
		this.examStuId = examStuId;
	}

	public ExamStudentSubjectId(Integer examSubjectId, Integer examStuId) {
		this.examSubjectId = examSubjectId;
		this.examStuId = examStuId;
	}

	public ExamStudentSubjectId() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examSubjectId == null) ? 0 : examSubjectId.hashCode());
		result = prime * result + ((examStuId == null) ? 0 : examStuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamStudentSubjectId other = (ExamStudentSubjectId) obj;
		if (examSubjectId == null) {
			if (other.examSubjectId != null)
				return false;
		} else if (!examSubjectId.equals(other.examSubjectId))
			return false;
		if (examStuId == null) {
			if (other.examStuId != null)
				return false;
		} else if (!examStuId.equals(other.examStuId))
			return false;
		return true;
	}
	
}
