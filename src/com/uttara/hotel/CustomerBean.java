package com.uttara.hotel;

import java.io.Serializable;

public class CustomerBean implements Serializable {

	public CustomerBean() {
		super();
	}

	private String uname, number, address;

	
			@Override
	public String toString() {
		return "CustomerBean [uname=" + uname + ", number=" + number + ", address=" + address + "]";
	}


			@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		CustomerBean other = (CustomerBean) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}


			public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


			public String validate()
	{
		StringBuilder sb=new StringBuilder();
		if((uname==null)||(uname.trim().equals("")))
			sb.append("Name is Mandatory"+"\n");
		if((number==null)||(number.trim().equals(""))||(number.length()<10)||(number.length()>10))
			sb.append("Enter a Valid Phone Number "+"\n");
	
		if((address==null)||(address.trim().equals("")))
			sb.append("Address is Mandatory"+"\n");
		String msg=sb.toString();
		if(msg.equals(""))			
		return Constants.SUCESS;
		else 
		return msg;	
		
	}


			public CustomerBean(String uname, String number, String address) {
				super();
				this.uname = uname;
				this.number = number;
				this.address = address;
			}
}
