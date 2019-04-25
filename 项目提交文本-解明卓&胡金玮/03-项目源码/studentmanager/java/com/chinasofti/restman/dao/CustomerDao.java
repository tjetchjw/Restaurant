package com.chinasofti.restman.dao;

import java.util.List;

import com.chinasofti.restman.dmain.Customer;

public interface CustomerDao {
	//实现一个查询所有客户的方法
	public List<Customer> selectAll();
	//实现一个添加的方法
	public boolean insertCustomer(Customer cus);
	//实现一个通过id查询消费记录方法
	public String selectById(int id);
	//实现通过id补卡的方法
	public String selectByCuid(int id);
	//实现一个冻结账户的方法
	public boolean delectByCuid(int id);
	//实现一个客户登录的方法
	public Customer login(int coid);

}
