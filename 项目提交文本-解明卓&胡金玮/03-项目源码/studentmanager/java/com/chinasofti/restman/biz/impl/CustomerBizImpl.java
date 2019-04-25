package com.chinasofti.restman.biz.impl;

import java.util.List;

import com.chinasofti.restman.biz.CustomerBiz;
import com.chinasofti.restman.dao.CustomerDao;
import com.chinasofti.restman.dao.impl.CustomerDaoImpl;
import com.chinasofti.restman.dmain.Customer;

public class CustomerBizImpl implements CustomerBiz{
	private CustomerDao cusDao;
	
	public CustomerBizImpl() {
		this.cusDao=new CustomerDaoImpl();
	}
	//创建查询所有客户信息方法
	@Override
	public List<Customer> findAll() {
		
		return this.cusDao.selectAll();
	}
	//创建添加客户信息方法
	@Override
	public String addCustomer(int cuid, String cuname, String memtype, double cubal) {
		
		return this.cusDao.insertCustomer(new Customer(cuid,cuname,memtype,cubal))?"添加成功":"添加失败";
	}
	//创建通过Id查询消费记录的方法
	@Override
	public String findById(int id) {
		return this.cusDao.selectById(id);
	}
	//创建补卡的方法
	@Override
	public String findByCuid(int id) {
		
		return this.cusDao.selectByCuid(id);
	}
	//创建一个冻结的方法
	@Override
	public String removeByCuid(int id) {
		
		return this.cusDao.delectByCuid(id)?"冻结成功":"冻结失败";
	}
	//创建一个客户登录的方法
	@Override
	public Customer findByCouid(int coid) {
		
		return this.cusDao.login(coid);
	}
}
