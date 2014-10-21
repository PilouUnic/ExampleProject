package com.application.example.mvc.model;

import java.util.List;

import com.application.example.mvc.entitie.Hotel;

public class HotelView {
	
	private List<Hotel> hotelList;

	public HotelView() {
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	
}
