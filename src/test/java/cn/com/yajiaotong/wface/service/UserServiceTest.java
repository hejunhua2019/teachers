/*package cn.com.yajiaotong.wface.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.test.commons.SpringTestCase;

public class UserServiceTest extends SpringTestCase{
	
	@Autowired
    private ServicesService userService;
	
	@Test
	public void testBasicDBCRUD() {
		try{
			String account = "asdfsdn32432sfgsf";
			String account1="hejunhua";
			String password="sdfsfsd";
			String token="sdfsfsdytktyr";
			int type=1;
			Services user = new Services();	
			user.setAccount(account);
			user.setPassword(password);
			user.setToken(token);
			user.setType(type);
			user.setId((long)111114);
			//userService.add(user);
			user = userService.findById(user.getId());
			System.out.println(user.getAccount());
			assertEquals(account,user.getAccount());
			assertEquals(password,user.getPassword());
			assertEquals(token,user.getToken());
			assertEquals(type,user.getType());
			//user.setAccount(account1);
			//userService.update(user);
			//user = userService.findById(user.getId());
			//assertEquals(account1,user.getAccount());
			//userService.delete(user.getId());
			//assertNull(userService.findById(user.getId()));
		}catch(Exception e){
			e.printStackTrace();
			assert(false);
		}
		assert(true);
	}

}*/