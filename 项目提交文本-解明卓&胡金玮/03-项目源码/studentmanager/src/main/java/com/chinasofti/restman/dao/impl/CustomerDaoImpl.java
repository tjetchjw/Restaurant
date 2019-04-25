package com.chinasofti.restman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.restman.dao.CustomerDao;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	private DBUtil db;

	// 实现一个查询所有客户的方法
	@Override
	public List<Customer> selectAll() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select cuid,cuname,memtype,cubal from customer where frozen=1";

		try {
			ResultSet rs = this.db.query(sql);
			// 创建一个list集合用于存储所有的课程
			List<Customer> list = new ArrayList<Customer>();
			while (rs.next()) {
				list.add(new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),
						rs.getInt("cubal")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 实现一个添加的方法
	@Override
	public Customer insertCustomer(String cuname, String memtype) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into Customer(cuid,cuname,MEMTYPE) values(seq_cus.nextval,?,?)";
		try {
			int i = this.db.update(sql, cuname, memtype);
			// 查询最新创建的数据并显示
			String sql1 = "select * from customer where rownum=1 order by cuid desc";
			ResultSet rs = this.db.query(sql1);
			if (rs.next()) {
				return new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),
						rs.getDouble("cubal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	// 实现一个通过id查询消费记录方法
	@Override
	public CustomerConsumptionRecords selectById(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select  *from customerconsumptionrecords where cuid=" + id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new CustomerConsumptionRecords(rs.getString("orid"), rs.getString("diname"), rs.getInt("dinum")
					, rs.getDate("ordate"), rs.getInt("cuid"), rs.getDouble("totalprice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 实现通过id补卡的方法
	@Override
	public Customer selectByCuid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from customer where cuid=" + id + "and frozen=1";
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),
						rs.getDouble("cubal"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	// 实现一个冻结账户的方法
	@Override
	public boolean delectByCuid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update customer set frozen=0where cuid=" + id;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 实现一个客户登录的方法
	@Override
	public Customer login(int coid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from customer where cuid=? and frozen=1";
		try {
			ResultSet rs = this.db.query(sql, coid);
			while (rs.next()) {
				Customer c = new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),
						rs.getInt("cubal"));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 充值
	@Override
	public boolean topUp(int cuid, double money) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update customer set cubal=" + money + "where cuid=" + cuid;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 实现解冻方法
	@Override
	public boolean thswById(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update customer set frozen=1where cuid=" + id;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer selectAllCusByCuid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from customer where cuid=" + id;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Customer(rs.getInt("cuid"), rs.getString("cuname"), rs.getString("memtype"),
						rs.getDouble("cubal"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

}
