package com.chinasofti.restman.dao.impl;

import java.util.List;

import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.util.DBUtil;

public class AdministrationDaoImpl implements AdministrationDao{
	//添加一个员工
	@Override
	public boolean insertStaff(int stid, String stname, String stpass) {
		// TODO Auto-generated method stub
		return false;
	}
	//删除一个员工通过员工号
	@Override
	public boolean delectByStid() {
		// TODO Auto-generated method stub
		return false;
	}
	//修改管理员信息
	@Override
	public boolean reviseAdm() {
		// TODO Auto-generated method stub
		return false;
	}
	//通过id查询员工
	@Override
	public String findById() {
		DBUtil dbUtil = new DBUtil();
		return null;
	}
	//查询菜单
	@Override
	public List<Dishes> selectDishes() {
		// TODO Auto-generated method stub
		return null;
	}
	//添加菜品
	@Override
	public boolean insertDishes(int diid, String diname, int diprice, int dtid) {
		// TODO Auto-generated method stub
		return true;
	}
	//删除菜品
	@Override
	public boolean deleteByDiid(int diid) {
		// TODO Auto-generated method stub
		return false;
	}
	//经理登录
	@Override
	public Administration login(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
