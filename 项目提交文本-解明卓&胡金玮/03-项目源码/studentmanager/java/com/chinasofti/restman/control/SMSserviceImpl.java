package com.chinasofti.restman.control;

import java.util.List;

import com.chinasofti.restman.biz.AdministrationBiz;
import com.chinasofti.restman.biz.CustomerBiz;
import com.chinasofti.restman.biz.StaffBiz;
import com.chinasofti.restman.biz.impl.StaffBizImpl;
import com.chinasofti.restman.biz.impl.AdministrationBizImpl;
import com.chinasofti.restman.biz.impl.CustomerBizImpl;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;



public class SMSserviceImpl implements SMSservice {

	private AdministrationBiz admBiz;
	private CustomerBiz cusBiz;
	private StaffBiz staBiz;
	
	public SMSserviceImpl() {
		this.admBiz=new AdministrationBizImpl();
		this.cusBiz=new CustomerBizImpl();
		this.staBiz=new StaffBizImpl();
	}
	
	public List<Customer> selectCustomer() {
		
		return  this.cusBiz.findAll();
	}

	public String insertCustomer(int cuid, String cuname, String memtype, double cubal) {
		
		return this.cusBiz.addCustomer(cuid,cuname,memtype,cubal);
	}

	public String selectCustomerByOrid(int id) {
		
		return this.cusBiz.findById(id);
	}

	public String selectCustomerByCuid(int id) {
		
		return this.cusBiz.findByCuid(id);
	}

	public String deleteCustomerByCuid(int id) {
		
		return this.cusBiz.removeByCuid(id);
	}

	public List<Orderterm> insertOrder() {
		
		return this.staBiz.addOrder();
	}

	public String deleteOrderByDiid(int id) {
		
		return this.staBiz.removeByDiid(id);
	}

	public List<Orderterm> PrintOrder() {
		
		return this.staBiz.print();
	}

	public String selectAccounts() {
		
		return this.staBiz.accounts();
	}

	public List<Staff> selectStaff() {
		
		return this.staBiz.findAll();
	}

	public String insertStaff(int stid, String stname, String stpass) {
		
		return this.admBiz.addStaff(stid,stname,stpass);
	}

	public String deleteStaffById(int stid) {
		
		return this.admBiz.removeByStid(stid);
	}

	public String updateAdministration() {
		
		return this.admBiz.updateAdm();
	}

	public String selectStaffById(int stid) {
		
		return this.admBiz.seletctById(stid);
	}

	public List<Dishes> selectDishes() {
		
		return this.admBiz.findAll();
	}

	public String insertDishes(int diid, String diname, int diprice, int dtid) {
		
		return this.admBiz.addDishes(diid,diname,diprice,dtid);
	}

	public String deleteDishesById(int diid) {
		
		return this.admBiz.removeByDiid(diid);
	}

	public String updateQuota(double memberDis, double superDis) {
		
		return null;
	}

	public Customer cuslogin(int coid) {
		 return this.cusBiz.findByCouid(coid);
		
	}

	public Staff stalogin(int id,String password) {
		return this.staBiz.findByIdAndPw(id, password);
	}

	@Override
	public Administration admlogin(int id, String password) {
		
		return this.admBiz.findByIdAndPw(id, password);
	}
	

}
