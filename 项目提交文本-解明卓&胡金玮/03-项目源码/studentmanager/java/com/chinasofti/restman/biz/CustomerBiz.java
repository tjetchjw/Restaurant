package com.chinasofti.restman.biz;

import java.util.List;

import com.chinasofti.restman.dmain.Customer;

public interface CustomerBiz {
	//创建查询所有客户信息方法
	public List<Customer> findAll();
	//创建添加客户信息方法
	public String addCustomer(int cuid, String cuname, String memtype, double cubal);
	//创建通过Id查询消费记录的方法
	public String findById(int id);
	//创建补卡的方法
	public String findByCuid(int id);
	//创建一个冻结的方法
	public String removeByCuid(int id);
	//创建一个客户登录的方法
	public Customer findByCouid(int coid);	
	
}
