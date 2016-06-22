package com.ite.smvcDemo.common.vo.base;

import java.io.Serializable;
import java.util.Date;

public class BaseVO implements Serializable{

	private static final long serialVersionUID = -8748073868218755956L;

	private String updUser;
	
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
