package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Orderterm implements Serializable{
	private int diid;
	private int dinum;
	public Orderterm(int diid, int dinum) {
		super();
		this.diid = diid;
		this.dinum = dinum;
	}
	public Orderterm() {
		super();
	}
	public int getDiid() {
		return diid;
	}
	public void setDiid(int diid) {
		this.diid = diid;
	}
	public int getDinum() {
		return dinum;
	}
	public void setDinum(int dinum) {
		this.dinum = dinum;
	}
	private void show() {
		System.out.println(this.getDiid()+"\t"+this.getDinum());
	}
}
