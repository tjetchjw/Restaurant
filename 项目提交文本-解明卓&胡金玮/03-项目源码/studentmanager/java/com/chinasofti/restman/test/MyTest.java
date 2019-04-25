package com.chinasofti.restman.test;

import org.junit.Test;

import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dao.impl.AdministrationDaoImpl;

public class MyTest {
	@Test
	public void test() {
		AdministrationDao a = new AdministrationDaoImpl();
		String s = a.findById();
		System.out.println(s);
	}
}
