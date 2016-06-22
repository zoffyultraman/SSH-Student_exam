package com.ite.smvcDemo.entity.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.ite.smvcDemo.entity.base.BaseEntity;
import com.ite.smvcDemo.entity.role.Role;

@Entity
@Table(name="users")
public class Users extends BaseEntity  implements Serializable{

	private static final long serialVersionUID = -8426518506388777474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//缺点只支持单例
	//@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	//常用native,可多例
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@Column(name = "USER_ID") 
	private Integer userId;
	
	@NotEmpty
	@Column(name="USER_NAME" ,length = 50, nullable = false)
	private String userName;
	
	
	@Column(name="PASSWORD" ,length = 20, nullable = false)
	private String password;
	
	@Column(name="REMARK" ,length = 100, nullable = true)
	private String remark;
	
	@Column(name="email" ,length = 100, nullable = true)
	private String email;
	
	@Column(name="age" , precision=11, scale=0 ,nullable = true)
	private Integer age;
	
	@Column(name="RoleId" , length=45, nullable = false)
	private String roleId;
	
	@Column(name="sex" , length=50, nullable = false)
	private String sex;


	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="RoleId", referencedColumnName="roleId", insertable = false, updatable = false)
	private Role role;

	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
