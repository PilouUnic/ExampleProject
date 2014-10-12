package com.application.example.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.example.mvc.model.Hotel;
import com.application.example.mvc.service.HotelService;
import com.application.example.mvc.validator.HotelValidator;

@Controller
@RequestMapping("/pages")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private MessageSource messageSource;

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
		List<Hotel> hotels = hotelService.findAll();
		return new ModelAndView("/pages/hotelList.jsp", "hotels", hotels);
	}
	
	@RequestMapping(value="/delete.do")	
	public ModelAndView delete(Long id) {
		hotelService.delete(id);
		return new ModelAndView("redirect:list.do");
	}
}
