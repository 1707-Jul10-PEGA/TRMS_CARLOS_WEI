package com.revature.trms.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.trms.pojos.User;

public class UserTest {
	static User user;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new User();
	}

	@Test
	public void getSetUseridTest() {
		user.setUserid(-1);
		assertEquals(user.getUserid(), 0);
		
		user.setUserid(1);
		assertEquals(user.getUserid(), 1);
	}
	@Test
	public void getSetFirstName() {
		user.setFirstname("");
		assertFalse("".equals(user.getFirstname()));
		
		user.setFirstname("Carlos");
		assertTrue("Carlos".equals(user.getFirstname()));
	}
	@Test
	public void getSetLastName() {
		user.setLastname("");
		assertFalse("".equals(user.getLastname()));
		
		user.setLastname("Carlos");
		assertTrue("Carlos".equals(user.getLastname()));
	}
	@Test
	public void getSetEmail() {
		user.setEmail("");
		assertFalse("".equals(user.getEmail()));
		
		user.setEmail("Carlos@gmail.com");
		assertTrue("Carlos@gmail.com".equals(user.getEmail()));
	}
	@Test
	public void getSetPosition() {
		user.setPosition("");
		assertFalse("".equals(user.getPosition()));
		
		user.setPosition("c");
		assertTrue("c".equals(user.getPosition()));
	}
	@Test
	public void getSetDepartment() {
		user.setDepartment("");
		assertFalse("".equals(user.getDepartment()));
		
		user.setDepartment("c");
		assertTrue("c".equals(user.getDepartment()));
	}
	@Test
	public void getSetSupervisor() {
		user.setSupervisor(-1);
		assertSame(user.getSupervisor(), null);

		assertTrue("Department Head".equals(user.getPosition()));
		
		user.setSupervisor(1);
		assertEquals(user.getSupervisor(), 1);
	}
	

}
