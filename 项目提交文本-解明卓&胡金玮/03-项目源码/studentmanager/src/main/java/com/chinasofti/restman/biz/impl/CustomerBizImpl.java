package com.chinasofti.restman.biz.impl;

import java.util.List;

import com.chinasofti.restman.biz.CustomerBiz;
import com.chinasofti.restman.dao.CustomerDao;
import com.chinasofti.restman.dao.impl.CustomerDaoImpl;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;

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
	public Customer addCustomer( String cuname, String memtype) {
		
		return this.cusDao.insertCustomer(cuname,memtype);
	}
	//创建通过Id查询消费记录的方法
	@Override
	public CustomerConsumptionRecords findById(int id) {
		return this.cusDao.selectById(id);
	}
	//创建补卡的方法
	@Override
	public Customer findByCuid(int id) {
		
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
	@Override
	public String topUp(int cuid, double money) {
		
		return this.cusDao.topUp(cuid,money)?"充值成功":"充值失败";
	}
	@Override
	public String thawById(int id) {
		
		return this.cusDao.thswById(id)?"解冻成功":"解冻失败";
	}
	@Override
	public Customer selectAllCusByCuid(int id) {
		
		return this.cusDao.selectAllCusByCuid(id);
	}
}
