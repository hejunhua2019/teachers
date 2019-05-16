/*package cn.com.yajiaotong.wface.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.yajiaotong.wface.entity.StudentsInformation;
import cn.com.yajiaotong.wface.test.commons.SpringTestCase;

public class StudentsInformationServiceTest extends SpringTestCase{
	
	@Autowired
    private StudentsInformationService studentsInformationService;
	
	@Test
	public void testBasicDBCRUD() {
		try{
			String name = "hejunhua";
			int age=26;
			String highestEducation="大专";
			int socialAge=6;
			char houseProperty='0';
			String mobile="135876492376";
			StudentsInformation studentsInformation = new StudentsInformation();	
			studentsInformation.setAge(age);
			studentsInformation.setHighestEducation(highestEducation);
			studentsInformation.setHouseProperty(houseProperty);
			studentsInformation.setMobile(mobile);
			studentsInformation.setName(name);
			studentsInformation.setSocialAge(socialAge);
			//user.setId((long)111113);
			studentsInformation.setId((long)000001);
			studentsInformationService.add(studentsInformation);
			user = userService.findById(user.getId());
			System.out.println(user.getAccount());
			assertEquals(account,user.getAccount());
			assertEquals(password,user.getPassword());
			assertEquals(token,user.getToken());
			assertEquals(type,user.getType());
			user.setAccount(account1);
			userService.update(user);
			user = userService.findById(user.getId());
			assertEquals(account1,user.getAccount());
			userService.delete(user.getId());
			assertNull(userService.findById(user.getId()));
		}catch(Exception e){
			e.printStackTrace();
			assert(false);
		}
		assert(true);
	}

}*/