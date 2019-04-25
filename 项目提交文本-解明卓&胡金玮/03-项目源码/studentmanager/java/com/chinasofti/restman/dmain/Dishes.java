package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Dishes implements Serializable {
	private int diid;
	private String diname;
	private int diprice;
	private int dtid;
	private int dimonsv;
	public Dishes(int diid, String diname, int number, int dtid, int dimonsv) {
		super();
		this.diid = diid;
		this.diname = diname;
		this.diprice = diprice;
		this.dtid = dtid;
		this.dimonsv = dimonsv;
	}
	public Dishes() {
		super();
	}
	public int getDiid() {
		return diid;
	}
	public void setDiid(int diid) {
		this.diid = diid;
	}
	public String getDiname() {
		return diname;
	}
	public void setDiname(String diname) {
		this.diname = diname;
	}
	public int getDiprice() {
		return diprice;
	}
	public void setDiprice(int diprice) {
		this.diprice = diprice;
	}
	public int getDtid() {
		return dtid;
	}
	public void setDtid(int dtid) {
		this.dtid = dtid;
	}
	public int getDimonsv() {
		return dimonsv;
	}
	public void setDimonsv(int dimonsv) {
		this.dimonsv = dimonsv;
	}
	private void show() {
		System.out.println("菜品："+this.diid+"\t"+this.diname+"\t"+this.diprice+"\t"+this.dtid+"\t"+this.dimonsv);
	}
}
