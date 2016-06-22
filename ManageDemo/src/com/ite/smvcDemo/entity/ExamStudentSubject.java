package com.ite.smvcDemo.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="exam_student_subject")
public class ExamStudentSubject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "examSubjectId", column = @Column(name = "exam_subject_id", length = 15, nullable = false)),
		@AttributeOverride(name = "examStuId", column = @Column(name = "exam_stu_id", length = 15, nullable = false))
	})
	private ExamStudentSubjectId id;

	public ExamStudentSubjectId getId() {
		return id;
	}

	public void setId(ExamStudentSubjectId id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ExamStudentSubject other = (ExamStudentSubject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
