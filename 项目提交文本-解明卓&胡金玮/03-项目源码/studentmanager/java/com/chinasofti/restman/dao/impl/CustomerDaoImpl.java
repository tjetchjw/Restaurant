package com.chinasofti.restman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.restman.dao.CustomerDao;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{
	private DBUtil db;
	//实现一个查询所有客户的方法
	@Override
	public List<Customer> selectAll() {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql = "select cuid,cuname,memtype,cubal from customer";
		
		try {
			ResultSet rs = this.db.query(sql);
			//创建一个list集合用于存储所有的课程
			List<Customer> list=new ArrayList<Customer>();
			while(rs.next()){
				list.add(new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),rs.getInt("cubal")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//实现一个添加的方法
	@Override
	public boolean insertCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return true;
	}
	//实现一个通过id查询消费记录方法
	@Override
	public String selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//实现通过id补卡的方法
	@Override
	public String selectByCuid(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//实现一个冻结账户的方法
	@Override
	public boolean delectByCuid(int id) {
		// TODO Auto-generated method stub
		return true;
	}
	//实现一个客户登录的方法
	@Override
	public Customer login(int coid) {
		// TODO Auto-generated method stub
		return null;
	}

}
