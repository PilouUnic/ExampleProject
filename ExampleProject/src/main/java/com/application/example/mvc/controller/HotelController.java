package com.application.example.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.example.mvc.entitie.Hotel;
import com.application.example.mvc.service.HotelService;
import com.application.example.mvc.validator.HotelValidator;

@Controller
@RequestMapping("/pages")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private MessageSource messageSource;
	
	private List<Hotel> hotels;
	private List<String> cities;

	/**
	 * Init form with an Hotel object which is empty
	 * @return
	 */
	@RequestMapping(value="/save.do", method=RequestMethod.GET)
	public ModelAndView initSave() {
		return new ModelAndView("/pages/save.jsp", "hotel", new Hotel());
	}

	/**
	 * 
	 * @param hotel
	 * @return
	 */
	@RequestMapping(value="/save.do", method=RequestMethod.POST)
	//@RolesAllowed("ROLE_ADMIN")
	public ModelAndView save(@Valid Hotel hotel, BindingResult result) {

		// Appel au validator personnalis�
		HotelValidator hotelValidator = new HotelValidator();
		hotelValidator.validate(hotel, result);

		// L'annotation  @Valid d�clanche la validation sp�cifi� dans la classe POJO.
		// Si la validation est activ�, le param�tre "BindingResult result" doit �tre ajout�.
		if(result.hasErrors()) {
			// Si il ya des erreurs de validation, on retourne sur la page d'ou on viens
			// en renvoyant non pas une nouvelle instance le l'objet Hotel,
			// mais celui pass� en param�tre.
			return new ModelAndView("/pages/save.jsp", "hotel", hotel);
		}

		hotelService.save(hotel);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value="/list.do")
	public ModelAndView hotelList() {	
		hotels = new ArrayList<Hotel>();
		cities = new ArrayList<String>();
		hotels = hotelService.findAll();
		ModelAndView mav = new ModelAndView("/pages/hotelList.jsp");
		mav.addObject("hotels", hotels);
		mav.addObject("cities", cities);
		return mav;
	}

	@RequestMapping(value="/getCitiesByHotel", method = RequestMethod.GET)
	public @ResponseBody List<String> getCities(@RequestParam(value = "hotelId") String hotelId) {  

		cities.clear();
		if("W Hotel".equals(hotelId)) {
			cities.add("Avignon");
			cities.add("Aix en Provence");
			cities.add("Lyon");
			cities.add("Paris");
		} 

		return cities;  
	}

	@RequestMapping(value="/delete.do")	
	public ModelAndView delete(Long id) {
		hotelService.delete(id);
		return new ModelAndView("redirect:list.do");
	}
}
