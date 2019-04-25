package com.chinasofti.restman.biz;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Staff;

public interface AdministrationBiz {
	//创建一个添加员工的方法
	public Staff addStaff( String stname, String stpass);
	//创建一个删除员工的方法
	public String removeByStid(int stid);
	//创建修改管理员信息的方法
	public String updateAdm(String name,String password);
	//创建通过id查询员工信息的方法
	public Staff seletctById(int stid);
	//创建查询所有菜谱的方法
	public List<Dishes> findAll();
	//创建一个添加菜品的方法
	public String addDishes(String diname, double diprice, int dtid);
	//创建删除菜品的方法
	public String removeByDiid(int diid);
	//创建一个经理登录的方法
	Administration findByIdAndPw(int id, String password);
	//创建一个查询菜品的方法
	public Dishes findByDiid(int id);
	//创建一个修改会员类型的方法
	public String updateMem(int cuid, String memtype);
	//创建一个修改员工信息的类型
	public boolean updateById(int stid, String stname, String stpass);
	//创建一个修改菜品的方法
	public boolean updateD(int diid, String name, double price, int dtid);
	//创建一个设置特价菜的方法
	public String setIsc(int id, int ischeap);
	//创建一个更新菜品月销量的方法
	public boolean updateDishes(int diid, int dimonsv);
	

}
