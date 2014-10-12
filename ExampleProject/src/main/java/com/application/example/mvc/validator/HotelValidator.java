package com.application.example.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.application.example.mvc.model.Hotel;

public class HotelValidator implements Validator {

	/**
	 * Methode permettant de v�rifier qu'on ne valide pas un objet qui n'est pas du type
	 * d�sir�.
	 */
	@Override
	public boolean supports(Class<?> object) {
		return object.equals(Hotel.class);
	}

	/**
	 * Methode de validation.
	 */
	@Override
	public void validate(Object object, Errors error) {
		// Cast de l'objet pass� en param�tre dans le type d'objet que l'on veut valider.
		Hotel hotel = (Hotel) object;
		if(hotel.getName().equalsIgnoreCase(hotel.getCity())) {
			// Premier param�tre est le nom du champs � valider
			// Deuxi�me param�tre : le message
			error.rejectValue("name", "error.namecity");
		}		
	}
}
