package com.ite.smvcDemo.common.vo.user;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.ite.smvcDemo.common.util.Constant;
import com.ite.smvcDemo.common.vo.base.BaseVO;

public class UsersVO extends BaseVO{

	private static final long serialVersionUID = 3956374005288454720L;

	private Integer userId;
	
	@NotEmpty(message="{username.empty.error}") 
	private String userName;
	
	private String password;
	
	private String remark;
	
	private String email;
	
	private Integer age;
	
	private String roleId;
	
	private String sex;

	private String roleName;
	
	private String sexDescription;

	private Date birthDay;
	
	private Integer roleld;
	
	
	
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSexDescription() {
		if(Constant.MALE.equals(this.getSex())){
			sexDescription = "Male";
		}else if(Constant.FEMALE.equals(this.getSex())){
			sexDescription = "Female";
		}else{
			sexDescription = Constant.EMPTY;
		}
		return sexDescription;
	}

	public void setSexDescription(String sexDescription) {
		this.sexDescription = sexDescription;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
}
