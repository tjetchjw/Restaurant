package com.chinasofti.restman.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.chinasofti.restman.control.SMSservice;
import com.chinasofti.restman.control.SMSserviceImpl;
import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dao.CustomerDao;
import com.chinasofti.restman.dao.StaffDao;
import com.chinasofti.restman.dao.impl.AdministrationDaoImpl;
import com.chinasofti.restman.dao.impl.CustomerDaoImpl;
import com.chinasofti.restman.dao.impl.StaffDaoImpl;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;
import com.chinasofti.restman.util.DateUtil;

public class MyTest {
	@Test
	public void test() {
		
		CustomerDao cd=new CustomerDaoImpl();
		AdministrationDao ad = new AdministrationDaoImpl();
		StaffDao sd = new StaffDaoImpl();
		String i = ad.upMen(3, "超级会员");
		System.out.println(i);
	}
}
