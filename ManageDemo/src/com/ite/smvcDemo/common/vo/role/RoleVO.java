package com.ite.smvcDemo.common.vo.role;

import org.hibernate.validator.constraints.NotEmpty;

import com.ite.smvcDemo.common.vo.base.BaseVO;

public class RoleVO extends BaseVO{

	private static final long serialVersionUID = 7984039487224473623L;

	private String RoleId;
	
	@NotEmpty(message="{RoleName.empty.error}") 
	private String RoleName;

	public String getRoleId() {
		return RoleId;
	}

	public void setRoleId(String roleId) {
		RoleId = roleId;
	}

	public  String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	
	
}
