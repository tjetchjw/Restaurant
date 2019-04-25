package com.chinasofti.restman.dao;

import java.util.List;

import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public interface StaffDao {
	//查询所有员工的方法
	public List<Staff> selectAll();
	//添加购物车方法
	public List<Orderterm> findOrd();
	//删除购物车方法
	public String deleteByDiid(int id);
	//登录方法
	public Staff findByfindByAcAndPw(int id, String password);
	//查询订单整体方法
	public List<Orderterm> selectOrderterm();
	//查询菜品数量及菜品价格方法
	public String selectDinumRideDiprice();

}
