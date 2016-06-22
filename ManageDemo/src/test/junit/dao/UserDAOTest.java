package test.junit.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ite.smvcDemo.dao.user.IUsersDAO;
import com.ite.smvcDemo.entity.user.Users;
import test.junit.dao.base.JUnitTestBase;

public class UserDAOTest extends JUnitTestBase{

	@Autowired
 	private IUsersDAO userdao;
	
	@Test
    public void testFindAll() {
//		Users users = new Users();
//		users.setAge(20);
//		users.setEmail("alex5@apjcorp.com");
//		users.setPassword("11");
//		users.setRemark("test");
//		users.setRoleId("admin");
//		users.setUserName("tester2");
//		users.setSex("M");
//		users.setUpdUser("Alex");
//		users.setUpdDate(new Date());
//		System.out.println(users.getUserName());
//		userdao.save(users);
		List<Users> list =  userdao.findAll();
		for(Users users : list){
			System.out.println(users.getRole().getRoleName());
		}
    }
	
}
