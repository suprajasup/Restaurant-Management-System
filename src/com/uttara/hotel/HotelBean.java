package com.uttara.hotel;

import java.io.Serializable;

public class HotelBean implements Serializable  {
	private int slno;
	 private String restaurant_name;
	 
	 double rating;
	 
	 
	public HotelBean(int slno, String restaurant_name, double rating) {
		super();
		this.slno = slno;
		this.restaurant_name = restaurant_name;
		this.rating = rating;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public HotelBean() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restaurant_name == null) ? 0 : restaurant_name.hashCode());
		result = prime * result + slno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelBean other = (HotelBean) obj;
		if (restaurant_name == null) {
			if (other.restaurant_name != null)
				return false;
		} else if (!restaurant_name.equals(other.restaurant_name))
			return false;
		if (slno != other.slno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HotelBean [slno=" + slno + ", restaurant_name=" + restaurant_name + "]";
	}
	public HotelBean(int slno, String restaurant_name) {
		super();
		this.slno = slno;
		this.restaurant_name = restaurant_name;
	}
		
}
