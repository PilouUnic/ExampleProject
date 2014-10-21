package com.application.example.mvc.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.application.example.mvc.entitie.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class HotelDaoTest {
	
	static Logger logger = LoggerFactory.getLogger(HotelDaoTest.class);

	@Autowired
	private HotelDao hotelDao;

//	@Test
//	@Transactional
//	public void shouldInsertHotel() {
//
//		Hotel newHotel = new Hotel();
//		newHotel.setName("TestHotel");
//		newHotel.setAddress("TestHotel");
//
//		hotelDao.save(newHotel);
//
//	}
	
	@Test
	public void shouldReturnAllHotel(){
		logger.trace("launching 'shouldReturnSomeHotel' method in 'HotelDaoTest.java'");
		List<Hotel> list = hotelDao.findAll();
		Assert.assertTrue(list != null && !list.isEmpty());
		logger.trace("launching 'shouldReturnSomeHotel' method in 'HotelDaoTest.java'");
	}

	@Test
	public void shouldReturn4Hotel(){
		logger.trace("launching 'shouldReturn4Hotel' method in 'HotelDaoTest.java'");
		List<Hotel> list = hotelDao.findHotelByPattern("%NY%");
		Assert.assertEquals(4, list.size());
		logger.trace("launching 'shouldReturn4Hotel' method in 'HotelDaoTest.java'");
	}

}
