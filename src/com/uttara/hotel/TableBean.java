package com.uttara.hotel;

public class TableBean 
{
	private int slno;
	private String seatno;
	private int no_of_seats;
	private int hotelSl;
	@Override
	public String toString() {
		return "TableBean [slno=" + slno + ", seatno=" + seatno + ", no_of_seats=" + no_of_seats + ", hotelSl="
				+ hotelSl + "]";
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public int getHotelSl() {
		return hotelSl;
	}
	public void setHotelSl(int hotelSl) {
		this.hotelSl = hotelSl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hotelSl;
		result = prime * result + no_of_seats;
		result = prime * result + ((seatno == null) ? 0 : seatno.hashCode());
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
		TableBean other = (TableBean) obj;
		if (hotelSl != other.hotelSl)
			return false;
		if (no_of_seats != other.no_of_seats)
			return false;
		if (seatno == null) {
			if (other.seatno != null)
				return false;
		} else if (!seatno.equals(other.seatno))
			return false;
		if (slno != other.slno)
			return false;
		return true;
	}
	public TableBean(int slno, String seatno, int no_of_seats, int hotelSl) {
		super();
		this.slno = slno;
		this.seatno = seatno;
		this.no_of_seats = no_of_seats;
		this.hotelSl = hotelSl;
	}
	public TableBean() {
		super();
	}
}