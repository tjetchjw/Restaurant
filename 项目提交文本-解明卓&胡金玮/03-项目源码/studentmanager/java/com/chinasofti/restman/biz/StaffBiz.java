package com.chinasofti.restman.biz;

import java.util.List;

import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public interface StaffBiz {
	//创建一个查询所有员工的方法
	public List<Staff> findAll();
	//创建一个购物车添加的方法
	public List<Orderterm> addOrder();
	//创建一个删除购物车的方法
	public String removeByDiid(int id);
	//创建一个员工登录的方法
	public Staff findByIdAndPw(int id, String password);
	//创建一个打印的方法
	public List<Orderterm> print();
	//创建一个结账的功能
	public String accounts();


}
