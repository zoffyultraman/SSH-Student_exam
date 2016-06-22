package com.ite.smvcDemo.entity.role;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.ite.smvcDemo.entity.base.BaseEntity;

@Entity
@Table(name="role")
public class Role  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7726216009520888143L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@GenericGenerator(name = "persistenceGenerator", strategy = "native") 
	@Column(name="RoleId" , length=45, nullable = false)
	private String roleId;
	
	@Column(name="RoleName" , length=45, nullable = false)
	private String roleName;

	/*@Column(name="UPDUSER" ,length = 30, nullable = true)
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
	*/
	
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	


}
