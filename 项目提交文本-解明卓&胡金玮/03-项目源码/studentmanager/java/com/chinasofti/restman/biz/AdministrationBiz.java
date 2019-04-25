package com.chinasofti.restman.biz;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Dishes;

public interface AdministrationBiz {
	//创建一个添加员工的方法
	public String addStaff(int stid, String stname, String stpass);
	//创建一个删除员工的方法
	public String removeByStid(int stid);
	//创建修改管理员信息的方法
	public String updateAdm();
	//创建通过id查询员工信息的方法
	public String seletctById(int stid);
	//创建查询所有菜谱的方法
	public List<Dishes> findAll();
	//创建一个添加菜品的方法
	public String addDishes(int diid, String diname, int diprice, int dtid);
	//创建删除菜品的方法
	public String removeByDiid(int diid);
	//创建一个经理登录的方法
	Administration findByIdAndPw(int id, String password);
	

}
