package com.chinasofti.restman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.restman.dao.AdministrationDao;
import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Staff;
import com.chinasofti.restman.util.DBUtil;

public class AdministrationDaoImpl implements AdministrationDao {
	private DBUtil db;

	// 添加一个员工
	@Override
	public Staff insertStaff(String stname, String stpass) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into staff(stid,stname,stpass) values(seq_sta.nextval,?,?)";
		try {
			int i = this.db.update(sql, stname, stpass);
			// 查询最新创建的数据并显示
			String sql1 = "select * from staff where rownum=1 order by stid desc";
			ResultSet rs = this.db.query(sql1);
			if (rs.next()) {
				return new Staff(rs.getInt("stid"), rs.getString("stname"), rs.getString("stpass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	// 删除一个员工通过员工号
	@Override
	public boolean delectByStid(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update staff set isdelete=0where stid=" + id;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 修改管理员信息
	@Override
	public boolean reviseAdm(String name, String password) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update administration set admname=?,admpass=?where admid=10";
		try {
			int i = this.db.update(sql, name, password);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 通过id查询员工
	@Override
	public Staff findById(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from staff where stid=" + id + "and isdelete=1";
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Staff(rs.getInt("stid"), rs.getString("stname"), rs.getString("stpass"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	// 查询菜单
	@Override
	public List<Dishes> selectDishes() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select a.diid,a.diname,a.diprice,a.dtid,a.dimonsv,a.ischeap,b.dtname from dishes a,dishestype b where a.dtid=b.dtid and isdelete=1 order by a.dtid";

		try {
			ResultSet rs = this.db.query(sql);
			// 创建一个list集合用于存储所有的课程
			List<Dishes> list = new ArrayList<Dishes>();
			while (rs.next()) {
				list.add(new Dishes(rs.getInt("diid"), rs.getString("diname"), rs.getDouble("diprice"),
						rs.getInt("dtid"), rs.getInt("dimonsv"),rs.getInt("ischeap")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 添加菜品
	@Override
	public String insertDishes(String diname, double diprice, int dtid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into dishes(diid,diname,diprice,dtid) values(seq_sta.nextval,?,?,?)";
		try {
			this.db.update(sql, diname, diprice, dtid);
			return "添加成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "添加失败";
		}

	}

	// 删除菜品
	@Override
	public boolean deleteByDiid(int diid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update dishes set isdelete=0where diid=" + diid;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// 经理登录
	@Override
	public Administration login(int id, String password) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select *from administration where admid=? and admpass=?";
		try {
			ResultSet rs = this.db.query(sql, id, password);
			while (rs.next()) {
				Administration adm = new Administration(rs.getInt("admid"), rs.getString("admpass"));
				return adm;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询菜品
	@Override
	public Dishes selectDishesById(int id) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from dishes where diid=" + id + "and isdelete=1";
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new Dishes(rs.getInt("diid"), rs.getString("diname"), rs.getDouble("diprice"), rs.getInt("dtid"),
						rs.getInt("dimonsv"), rs.getInt("ischeap"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	// 修改会员类型
	@Override
	public String upMen(int cuid, String memtype) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update customer set memtype=?where cuid=?";
		try {
			int i = this.db.update(sql,memtype,cuid);
			return "修改成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "修改失败";
		}

	}

	// 修改员工信息
	@Override
	public boolean upById(int stid, String stname, String stpass) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update staff set stname=?,stpass=? where stid=?";
		try {
			int i = this.db.update(sql, stname, stpass, stid);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 修改菜品
	@Override
	public boolean updateById(int diid, String name, double price, int dtid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update dishes set diname=?,diprice=?,dtid=? where diid=?";
		try {
			int i = this.db.update(sql, name, price, dtid, diid);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 设置特价菜
	@Override
	public String setIsc(int id, int ischeap) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update dishes set ischeap=?where diid=?";
		try {
			this.db.update(sql, ischeap, id);
			return "设置成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "设置失败";
		}

	}

	@Override
	public boolean updateDishes(int diid, int dimonsv) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql="update dishes set dimonsv=?where diid=?";
		try {
			int i = this.db.update(sql, dimonsv,diid);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
