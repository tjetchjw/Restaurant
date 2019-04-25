package com.chinasofti.restman.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.chinasofti.restman.dao.StaffDao;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;
import com.chinasofti.restman.util.DBUtil;

public class StaffDaoImpl implements StaffDao {
	private DBUtil db;
	private static String uuid;

	// 查询所有员工的方法
	@Override
	public List<Staff> selectAll() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select stid,stname,stpass from staff where isdelete=1";

		try {
			ResultSet rs = this.db.query(sql);
			// 创建一个list集合用于存储所有的课程
			List<Staff> list = new ArrayList<Staff>();
			while (rs.next()) {
				list.add(new Staff(rs.getInt("stid"), rs.getString("stname"), rs.getString("stpass")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 添加购物车方法
	@Override
	public boolean findOrd(List<Orderterm> list) {

		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into orderterm(orid,diid,dinum,diprice) values(?,?,?,?)";

		for (Orderterm orderterm : list) {
			try {
				int i = this.db.update(sql, uuid, orderterm.getDiid(), orderterm.getDinum(), orderterm.getPrice());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	// 删除购物车方法
	@Override
	public boolean deleteByDiid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from orderterm where diid=" + id;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 登录方法
	@Override
	public Staff findByfindByAcAndPw(int id, String password) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from staff where stid=? and stpass=?";
		try {
			ResultSet rs = this.db.query(sql, id, password);
			while (rs.next()) {
				Staff s = new Staff(rs.getInt("stid"), rs.getString("stname"), rs.getString("stpass"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			this.db.closed();
		}
		return null;
	}

	// 清空订单整体方法
	@Override
	public boolean deleteOrderterm() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from ordertable cascade";
		try {

			int i = this.db.update(sql);

			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 查询菜品数量及菜品价格方法
	@Override
	public String selectDinumRideDiprice(int cuid, double money) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update customer set cubal=?where cuid=?";
		try {
			int i = this.db.update(sql, money, cuid);
			return "结账完成";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "结账失败";
		}
	}

	// 创建订单方法
	@Override
	public String addOrder(Order ord) {
		uuid = UUID.randomUUID().toString().replace("-", "");
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into ordertable(orid,ordate,cuid) values(?,?,?)";
		try {
			int i = this.db.update(sql, uuid, ord.getOrdate(), ord.getCuid());
			return "创建成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "创建失败";
		}

	}

	// 查询订单项表
	@Override
	public List<Orderterm> findOrdterm() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from orderterm";
		try {
			ResultSet rs = this.db.query(sql);
			// 创建一个list集合用于存储所有的课程
			List<Orderterm> list = new ArrayList<Orderterm>();
			while (rs.next()) {
				list.add(new Orderterm(rs.getString("orid"), rs.getInt("diid"), rs.getInt("dinum"),
						rs.getDouble("diprice")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询订单
	@Override
	public Order finOrder() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from ordertable";
		try {
			ResultSet rs = this.db.query(sql);
			while (rs.next()) {
				Order o = new Order(rs.getString("orid"), rs.getDate("ordate"), rs.getInt("stid"), rs.getInt("cuid"));
				return o;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 清空购物车
	@Override
	public boolean clearOrd() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from ordertable cascade";
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 将订餐详细信息保存到客户消费记录表中的方法
	@Override
	public String UCCR(List<Orderterm> lort, Date ordate, int cuid, double totalprice) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into CustomerConsumptionRecords(orid,diid,dinum,ordate,cuid,totalprice) values(?,?,?,?,?,?)";

		for (Orderterm orderterm : lort) {
			try {
				this.db.update(sql, orderterm.getOrid(), orderterm.getDiid(), orderterm.getDinum(), ordate, cuid,
						totalprice);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "添加失败";
			}
		}
		return "添加成功";
	}

	// 通过菜品类型id查询菜品类型名
	@Override
	public String selectByDtid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select dtname from dishestype where dtid=" + id;
		try {
			ResultSet rs = this.db.query(sql);
			while (rs.next()) {
				return rs.getString("dtname");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateStid(int stid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update ordertable set stid=? where orid=?";
		try {
			int i = this.db.update(sql, stid, uuid);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 向order表添加stid的方法
	@Override
	public String addStIf(int stid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into ordertable(stid) values(?)";
		try {
			this.db.update(sql, stid);
			return "添加成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 返回客户消费记录表中的信息中的list部分
	@Override
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from CustomerConsumptionRecords where cuid=" + cuid;
		try {
			ResultSet rs = this.db.query(sql);
			List<CustomerConsumptionRecords> list = new ArrayList<CustomerConsumptionRecords>();
			while (rs.next()) {
				list.add(new CustomerConsumptionRecords(rs.getString("orid"), rs.getString("diid"), rs.getInt("dinum"), rs.getDate("ordate"), rs.getInt("cuid"), rs.getDouble("totalprice")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
