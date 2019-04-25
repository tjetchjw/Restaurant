package com.chinasofti.restman.dao;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Staff;

public interface AdministrationDao {
	//添加一个员工
	public Staff insertStaff(String stname, String stpass);
	//删除一个员工通过员工号
	public boolean delectByStid(int id);
	//修改管理员信息
	public boolean reviseAdm(String name,String password);
	//通过id查询员工
	public Staff findById(int id);
	//查询菜单
	public List<Dishes> selectDishes();
	//添加菜品
	public String insertDishes( String diname, double diprice, int dtid);
	//删除菜品
	public boolean deleteByDiid(int diid);
	//经理登录
	public Administration login(int id, String password);
	//查询菜品
	public Dishes selectDishesById(int id);
	//修改会员类型
	public String upMen(int cuid, String memtype);
	//修改员工信息
	public boolean upById(int stid, String stname, String stpass);
	//修改菜品
	public boolean updateById(int diid, String name, double price, int dtid);
	//设置特价菜
	public String setIsc(int id, int ischeap);
	//更新菜品月销量的方法
	public boolean updateDishes(int diid, int dimonsv);
	

}
