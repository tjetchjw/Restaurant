package com.chinasofti.restman.biz.impl;

import java.util.List;

import com.chinasofti.restman.biz.StaffBiz;
import com.chinasofti.restman.dao.StaffDao;
import com.chinasofti.restman.dao.impl.StaffDaoImpl;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public class StaffBizImpl implements StaffBiz{
	private StaffDao staDao;
	
	
	public StaffBizImpl() {
		this.staDao=new StaffDaoImpl();
	}
	//创建一个查询所有员工的方法
	@Override
	public List<Staff> findAll() {
		
		return this.staDao.selectAll();
	}
	//创建一个购物车添加的方法
	@Override
	public List<Orderterm> addOrder() {
		
		return this.staDao.findOrd();
	}
	//创建一个删除购物车的方法
	@Override
	public String removeByDiid(int id) {

		return this.staDao.deleteByDiid(id);
	}
	//创建一个员工登录的方法
	@Override
	public Staff findByIdAndPw(int id, String password) {
		
		return this.staDao.findByfindByAcAndPw(id, password);
	}
	//创建一个打印的方法
	@Override
	public List<Orderterm> print() {
		
		return this.staDao.selectOrderterm();
	}
	//创建一个结账的功能
	@Override
	public String accounts() {
		
		return this.staDao.selectDinumRideDiprice();
	}
}
