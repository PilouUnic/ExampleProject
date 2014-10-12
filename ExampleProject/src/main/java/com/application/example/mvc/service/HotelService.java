package com.application.example.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.example.mvc.dao.HotelDao;
import com.application.example.mvc.model.Hotel;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDAO;

	public List<Hotel> findAll() {
		return hotelDAO.findAll();	
	}
	
	public Hotel findOne(long id) {
		return hotelDAO.findOne(id);
	}
	
	public List<Hotel> findByPattern(String pattern) {
		return hotelDAO.findHotelByPattern("%" + pattern + "%");
	}
	
	@Transactional
	public void delete(long id) {
		hotelDAO.delete(id);
	}
	
	@Transactional
	public Hotel save(Hotel hotel) {
		return hotelDAO.save(hotel);
	}
}
