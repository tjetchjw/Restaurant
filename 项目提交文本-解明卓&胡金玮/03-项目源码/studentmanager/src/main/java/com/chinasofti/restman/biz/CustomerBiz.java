package com.chinasofti.restman.biz;

import java.util.List;

import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;

public interface CustomerBiz {
	//创建查询所有客户信息方法
	public List<Customer> findAll();
	//创建添加客户信息方法
	public Customer addCustomer(String cuname, String memtype);
	//创建通过Id查询消费记录的方法
	public CustomerConsumptionRecords findById(int id);
	//创建补卡的方法
	public Customer findByCuid(int id);
	//创建一个冻结的方法
	public String removeByCuid(int id);
	//创建一个客户登录的方法
	public Customer findByCouid(int coid);
	//创建一个充值方法
	public String topUp(int cuid, double money);
	//创建一个解冻的方法
	public String thawById(int id);
	public Customer selectAllCusByCuid(int id);	
	
}
