package com.chinasofti.restman.dao;

import java.sql.Date;
import java.util.List;

import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public interface StaffDao {
	//查询所有员工的方法
	public List<Staff> selectAll();
	//添加购物车方法
	public boolean findOrd(List<Orderterm> list);
	//删除购物车方法
	public boolean deleteByDiid(int id);
	//登录方法
	public Staff findByfindByAcAndPw(int id, String password);
	//清空订单整体方法
	public boolean deleteOrderterm();
	//查询菜品数量及菜品价格方法
	public String selectDinumRideDiprice(int cuid,double money);
	//创建订单方法
	public String addOrder(Order ord);
	//查询订单项表
	public List<Orderterm> findOrdterm();
	//查询订单信息
	public Order finOrder();
	//清空购物车
	public boolean clearOrd();
	//将订餐详细信息保存到客户消费记录表中的方法
	public String UCCR(List<Orderterm> lort, Date ordate, int cuid, double totalprice);
	//通过菜品类型id查询菜品类型名
	public String selectByDtid(int id);
	//将stid插入order表
	public boolean updateStid(int stid);
	//向order表添加stid的方法
	public String addStIf(int stid);
	// 返回客户消费记录表中的信息中的list部分
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid);


}
