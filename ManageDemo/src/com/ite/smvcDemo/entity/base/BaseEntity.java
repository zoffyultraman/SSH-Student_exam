package com.ite.smvcDemo.entity.base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {


	
	@Column(name="UPDUSER" ,length = 30, nullable = true)
	private String updUser;
	
	@Column(name="UPDDATE" , nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updDate;

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
	
}
