package com.application.example.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.example.mvc.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long>{

	@Query("select h from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
			+ "or lower(h.zip) like :pattern or lower(h.address) like :pattern")
	List<Hotel> findHotelByPattern(@Param("pattern") String pattern);
	
}
