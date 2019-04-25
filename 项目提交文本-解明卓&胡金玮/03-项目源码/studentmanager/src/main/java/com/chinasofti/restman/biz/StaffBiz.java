package com.chinasofti.restman.biz;

import java.sql.Date;
import java.util.List;

import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public interface StaffBiz {
	//创建一个查询所有员工的方法
	public List<Staff> findAll();
	//创建一个购物车添加的方法
	public boolean addOrder(List<Orderterm> list);
	//创建一个删除购物车的方法
	public boolean removeByDiid(int id);
	//创建一个员工登录的方法
	public Staff findByIdAndPw(int id, String password);
	//创建一个打印的方法
	public boolean print();
	//创建一个结账的功能
	public String accounts(int cuid,double money);
	//创建一个创建订单方法
	public String insertOrder(Order ord);
	//查询订单项表
	public List<Orderterm> findAllOr();
	//查询订单信息
	public Order findAllOrder();
	//创建一个清空购物车的方法
	public boolean clear();
	//创建一个将订餐详细信息保存到客户消费记录表中的方法
	public String updateCCR(List<Orderterm> lort, Date ordate, int cuid, double totalprice);
	//创建一个通过菜品类型号查询菜品类型名的方法
	public String findByDtid(int id);
	//创建一个插入order表员工号的方法
	public boolean update(int stid);
	//创建一个向order表添加stid的方法
	public String addStIf(int stid);
	// 返回客户消费记录表中的信息中的list部分
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid);



}
