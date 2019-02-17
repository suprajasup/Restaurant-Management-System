package com.uttara.hotel;

public class FoodBean 
{
	String foodname;
	int fslno,foodprice,fmenuslno;

	public FoodBean() {
		super();
	}

	public FoodBean(int fslno, String foodname, int fmenuslno, int foodprice) {
		super();
		this.fslno = fslno;
		this.foodname = foodname;
		this.fmenuslno = fmenuslno;
		this.foodprice = foodprice;
	}

	public int getFslno() {
		return fslno;
	}

	public void setFslno(int fslno) {
		this.fslno = fslno;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public int getFmenuslno() {
		return fmenuslno;
	}

	public void setFmenuslno(int fmenuslno) {
		this.fmenuslno = fmenuslno;
	}

	public int getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}

	@Override
	public String toString() {
		return "FoodBean [fslno=" + fslno + ", foodname=" + foodname + ", fmenuslno=" + fmenuslno + ", foodprice="
				+ foodprice + "]";
	}
	
	
	
	

}
