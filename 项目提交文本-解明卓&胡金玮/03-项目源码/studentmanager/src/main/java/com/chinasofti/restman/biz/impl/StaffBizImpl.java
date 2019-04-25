package com.chinasofti.restman.biz.impl;

import java.sql.Date;
import java.util.List;

import com.chinasofti.restman.biz.StaffBiz;
import com.chinasofti.restman.dao.StaffDao;
import com.chinasofti.restman.dao.impl.StaffDaoImpl;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Order;
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
	public boolean addOrder(List<Orderterm> list) {
		
		return this.staDao.findOrd(list);
	}
	//创建一个删除购物车的方法
	@Override
	public boolean removeByDiid(int id) {

		return this.staDao.deleteByDiid(id);
	}
	//创建一个员工登录的方法
	@Override
	public Staff findByIdAndPw(int id, String password) {
		
		return this.staDao.findByfindByAcAndPw(id, password);
	}
	//创建一个打印的方法
	@Override
	public boolean print() {
		
		return this.staDao.deleteOrderterm();
	}
	//创建一个结账的功能
	@Override
	public String accounts(int cuid,double money) {
		
		return this.staDao.selectDinumRideDiprice(cuid,money);
	}
	//创建一个创建订单方法
	@Override
	public String insertOrder(Order ord) {
		
		return this.staDao.addOrder(ord);
	}
	@Override
	public List<Orderterm> findAllOr() {
		
		return this.staDao.findOrdterm();
	}
	@Override
	public Order findAllOrder() {

		return this.staDao.finOrder();
	}
	@Override
	public boolean clear() {
		
		return this.staDao.clearOrd();
	}
	@Override
	public String updateCCR(List<Orderterm> lort, Date ordate, int cuid, double totalprice) {
		
		return this.staDao.UCCR(lort,ordate,cuid,totalprice);
	}
	@Override
	public String findByDtid(int id) {
		
		return this.staDao.selectByDtid(id);
	}
	@Override
	public boolean update(int stid) {
		
		return this.staDao.updateStid(stid);
	}
	@Override
	public String addStIf(int stid) {
		
		return this.staDao.addStIf(stid);
	}
	@Override
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid) {
		
		return this.staDao.returnCCROrderterm(cuid);
	}
	
}
