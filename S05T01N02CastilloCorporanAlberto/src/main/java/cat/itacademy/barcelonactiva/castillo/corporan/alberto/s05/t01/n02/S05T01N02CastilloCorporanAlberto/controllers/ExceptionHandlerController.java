package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.exception.EntityNoEncontradaException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(EntityNoEncontradaException.class)
	public String handleEntityNotFoundException(EntityNoEncontradaException ex) {
		return "redirect:/buscar?error=" + ex.getMessage();
	}
}