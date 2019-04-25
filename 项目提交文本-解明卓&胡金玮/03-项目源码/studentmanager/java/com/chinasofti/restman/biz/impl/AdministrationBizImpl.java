package com.chinasofti.restman.biz.impl;

import java.util.List;

import com.chinasofti.restman.biz.AdministrationBiz;
import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dao.impl.AdministrationDaoImpl;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Dishes;

public class AdministrationBizImpl implements AdministrationBiz{
	private AdministrationDao admDao;
	
	public AdministrationBizImpl() {
		super();
		this.admDao=new AdministrationDaoImpl();
	}
	//创建一个添加员工的方法
	@Override
	public String addStaff(int stid, String stname, String stpass) {
		
		return this.admDao.insertStaff(stid,stname,stpass)?"添加成功":"添加失败";
	}
	//创建一个删除员工的方法
	@Override
	public String removeByStid(int stid) {
		
		return this.admDao.delectByStid()?"删除成功":"删除失败";
	}
	//创建修改管理员信息的方法
	@Override
	public String updateAdm() {
		
		return this.admDao.reviseAdm()?"修改成功":"修改失败";
	}
	//创建通过id查询员工信息的方法
	@Override
	public String seletctById(int stid) {
		
		return this.admDao.findById();
	}
	//创建查询所有菜谱的方法
	@Override
	public List<Dishes> findAll() {
		
		return this.admDao.selectDishes();
	}
	//创建一个添加菜品的方法
	@Override
	public String addDishes(int diid, String diname, int diprice, int dtid) {
		
		return this.admDao.insertDishes(diid,diname,diprice,dtid)?"添加成功":"添加失败";
	}
	//创建删除菜品的方法
	@Override
	public String removeByDiid(int diid) {
		
		return this.admDao.deleteByDiid(diid)?"删除成功":"删除失败";
	}
	//创建一个经理登录的方法
	@Override
	public Administration findByIdAndPw(int id, String password) {
		
		return this.admDao.login(id,password);
	}
	
}
