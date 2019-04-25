package com.chinasofti.restman.dao;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Dishes;

public interface AdministrationDao {
	//添加一个员工
	public boolean insertStaff(int stid, String stname, String stpass);
	//删除一个员工通过员工号
	public boolean delectByStid();
	//修改管理员信息
	public boolean reviseAdm();
	//通过id查询员工
	public String findById();
	//查询菜单
	public List<Dishes> selectDishes();
	//添加菜品
	public boolean insertDishes(int diid, String diname, int diprice, int dtid);
	//删除菜品
	public boolean deleteByDiid(int diid);
	//经理登录
	public Administration login(int id, String password);

}
