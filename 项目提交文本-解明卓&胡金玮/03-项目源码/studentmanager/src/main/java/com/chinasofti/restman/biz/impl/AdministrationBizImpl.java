package com.chinasofti.restman.biz.impl;

import java.util.List;

import com.chinasofti.restman.biz.AdministrationBiz;
import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dao.impl.AdministrationDaoImpl;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Staff;

public class AdministrationBizImpl implements AdministrationBiz{
	private AdministrationDao admDao;
	
	public AdministrationBizImpl() {
		super();
		this.admDao=new AdministrationDaoImpl();
	}
	//创建一个添加员工的方法
	@Override
	public Staff addStaff(String stname, String stpass) {
		
		return this.admDao.insertStaff(stname,stpass);
	}
	//创建一个删除员工的方法
	@Override
	public String removeByStid(int stid) {
		
		return this.admDao.delectByStid(stid)?"删除成功":"删除失败";
	}
	//创建修改管理员信息的方法
	@Override
	public String updateAdm(String name,String password) {
		
		return this.admDao.reviseAdm( name, password)?"修改成功":"修改失败";
	}
	//创建通过id查询员工信息的方法
	@Override
	public Staff seletctById(int stid) {
		
		return this.admDao.findById(stid);
	}
	//创建查询所有菜谱的方法
	@Override
	public List<Dishes> findAll() {
		
		return this.admDao.selectDishes();
	}
	//创建一个添加菜品的方法
	@Override
	public String addDishes( String diname, double diprice, int dtid) {
		
		return this.admDao.insertDishes(diname,diprice,dtid);
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
	//创建一个通过菜品id查询菜品的方法
	@Override
	public Dishes findByDiid(int id) {
		
		return this.admDao.selectDishesById(id);
	}
	//创建一个修改会员类型的方法
	@Override
	public String updateMem(int cuid, String memtype) {
		
		return this.admDao.upMen(cuid,memtype);
	}
	@Override
	public boolean updateById(int stid, String stname, String stpass) {
		
		return this.admDao.upById(stid,stname,stpass);
	}

	@Override
	public boolean updateD(int diid, String name, double price, int dtid) {
		
		return this.admDao.updateById(diid,name,price,dtid);
	}
	@Override
	public String setIsc(int id, int ischeap) {
		
		return this.admDao.setIsc(id,ischeap);
	}
	@Override
	public boolean updateDishes(int diid, int dimonsv) {
		
		return this.admDao.updateDishes(diid,dimonsv);
	}
	
}
