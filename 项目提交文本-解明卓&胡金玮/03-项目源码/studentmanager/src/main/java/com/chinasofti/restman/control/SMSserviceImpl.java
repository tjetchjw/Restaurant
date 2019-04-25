package com.chinasofti.restman.control;

import java.sql.Date;
import java.util.List;

import com.chinasofti.restman.biz.AdministrationBiz;
import com.chinasofti.restman.biz.CustomerBiz;
import com.chinasofti.restman.biz.StaffBiz;
import com.chinasofti.restman.biz.impl.StaffBizImpl;
import com.chinasofti.restman.biz.impl.AdministrationBizImpl;
import com.chinasofti.restman.biz.impl.CustomerBizImpl;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Order;
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

	public Customer insertCustomer( String cuname, String memtype) {
		
		return this.cusBiz.addCustomer(cuname,memtype);
	}

	public CustomerConsumptionRecords selectCusRecordBycuid(int id) {
		
		return this.cusBiz.findById(id);
	}

	public Customer selectCustomerByCuid(int id) {
		
		
		return this.cusBiz.findByCuid(id);
	}

	public String deleteCustomerByCuid(int id) {
		
		return this.cusBiz.removeByCuid(id);
	}

	public boolean insertOrderterm(List<Orderterm> list) {
		
		return this.staBiz.addOrder(list);
	}

	public boolean deleteOrderByDiid(int id) {
		
		return this.staBiz.removeByDiid(id);
	}

	public boolean PrintOrder() {
		
		return this.staBiz.print();
	}
	@Override
	public String settleAccounts(int cuid,double money){
		
		return this.staBiz.accounts(cuid,money);
	}
	

	
	public List<Staff> selectStaff() {
		
		return this.staBiz.findAll();
	}

	public Staff insertStaff( String stname, String stpass) {
		
		return this.admBiz.addStaff(stname,stpass);
	}

	public String deleteStaffById(int stid) {
		
		return this.admBiz.removeByStid(stid);
	}

	public String updateAdministration(String name,String password) {
		
		return this.admBiz.updateAdm(name, password);
	}

	public Staff selectStaffById(int stid) {
		
		return this.admBiz.seletctById(stid);
	}

	public List<Dishes> selectDishes() {
		
		return this.admBiz.findAll();
	}

	public String insertDishes(String diname, double diprice, int dtid) {
		
		return this.admBiz.addDishes(diname,diprice,dtid);
	}

	public String deleteDishesById(int diid) {
		
		return this.admBiz.removeByDiid(diid);
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

	@Override
	public Dishes selectDishesById(int id) {
		
		return this.admBiz.findByDiid(id);
	}

	@Override
	public String topUp(int cuid, double money) {
		
		return this.cusBiz.topUp(cuid,money);
	}

	@Override
	public String updateMemtype(int cuid, String memtype) {
		
		return this.admBiz.updateMem(cuid,memtype);
	}

	@Override
	public String insertOrder(Order ord) {
		
		return this.staBiz.insertOrder(ord);
	}

	@Override
	public String thaw(int id) {
		
		return this.cusBiz.thawById(id);
	}

	@Override
	public List<Orderterm> returnOrderterm() {
		
		return this.staBiz.findAllOr();
	}

	@Override
	public Order returnOrder() {
		
		return this.staBiz.findAllOrder();
	}

	@Override
	public boolean clearOrd() {
		
		return this.staBiz.clear();
	}

	@Override
	public boolean updateStaffById(int stid, String stname, String stpass) {
		
		return this.admBiz.updateById(stid,stname,stpass);
	}

	@Override
	public String updateCustomerConsumptionRecords(List<Orderterm> lort, Date ordate, int cuid, double totalprice) {
		
		return this.staBiz.updateCCR(lort,ordate,cuid,totalprice);
	}

	@Override
	public boolean updateDishes(int diid, String name, double price, int dtid) {
		
		return this.admBiz.updateD(diid,name,price,dtid);
	}

	@Override
	public String selectDtnameByDtid(int id) {
		return this.staBiz.findByDtid(id);
	}

	@Override
	public boolean updateOrderStId(int stid) {
		
		return this.staBiz.update(stid);
	}

	@Override
	public Customer selectAllCusByCuid(int id) {
		
		return this.cusBiz.selectAllCusByCuid(id);
	}

	@Override
	public String setIscheap(int id, int ischeap) {
		
		return this.admBiz.setIsc(id,ischeap);
	}

	@Override
	public String insertOrdStIf(int stid) {
		
		return this.staBiz.addStIf(stid);
	}

	@Override
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid) {
		
		return this.staBiz.returnCCROrderterm(cuid);
	}

	@Override
	public boolean updateDishes(int diid, int dimonsv) {
		
		return this.admBiz.updateDishes(diid,dimonsv);
	}

	

	

}
