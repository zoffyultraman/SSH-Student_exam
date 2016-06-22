package com.ite.smvcDemo.common.vo.studentsubject;

import java.sql.Date;

public class StudentSujectVO {
	    private Integer examStudentSubjectId;
		
	    private Integer examSubjectId;
		
	    private Integer examStuId;
	    
	    private String UPDUSER;
	    
	    private Date UPDDATE;
	    
	    
	    
	    

		public String getUPDUSER() {
			return UPDUSER;
		}

		public void setUPDUSER(String uPDUSER) {
			UPDUSER = uPDUSER;
		}

		public Date getUPDDATE() {
			return UPDDATE;
		}

		public void setUPDDATE(Date uPDDATE) {
			UPDDATE = uPDDATE;
		}

		public Integer getExamStudentSubjectId() {
			return examStudentSubjectId;
		}

		public void setExamStudentSubjectId(Integer examStudentSubjectId) {
			this.examStudentSubjectId = examStudentSubjectId;
		}

		public Integer getExamSubjectId() {
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


	    
	    
}
