package test.junit.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ite.smvcDemo.dao.role.IRoleDAO;
import com.ite.smvcDemo.entity.role.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-config.xml"})
public class RoleTest {

	@Autowired
 	private IRoleDAO roledao;
	
	
	@Test
    public void testSaveMethod() {
//		Role role = new Role();
//		role.setRoleId("ite");
//		role.setRoleName("IT Training");
//		role.setUpdUser("Alex");
//		role.setUpdDate(new Date());
//		roledao.save(role);
    }
	
	@Test
    public void testFindAll() {
		List<Role> list = roledao.findAll();
		for(Role role : list){
			System.out.println(role.getRoleId());
		}
		
    }
	
	
}
