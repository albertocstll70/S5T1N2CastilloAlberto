package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.exception.EntityNoEncontradaException;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@Controller
public class FlorController {

	@Autowired
	private FlorService florServiceImpl;

	@Operation(summary = "Incio", description = "Presenta la pagina de inicio de la aplicación", tags = { "S05T01N02" })

	@GetMapping("/")
	public String welcome() {
		return "inicio";
	}

	@Operation(summary = " flomulario Añadir", description = "llama al  flomulario 'introducirDatos' para poder actualizar o añadir  una nueva  entidad ", tags = {
			"S05T01N02" })
	@GetMapping(value = "/flor/add")
	public String addFlor(Model model) {
		try {
			model.addAttribute("flor", new FlorEntity());

		} catch (DataAccessException e) {

		}
		return "introducirDatos";

	}

	@Operation(summary = "Guardar flor", description = "Recibe los datos del formulario ‘introducirDatos’ y crea una nueva entidad", tags = {
			"S05T01N02" })
	@PostMapping(value = "/flor/guardar")
	public String guardarflor(@ModelAttribute("flor") @Valid FlorEntity florEntity, BindingResult result) {
		if (result.hasErrors()) {
			return "introducirDatos";
		}

		florServiceImpl.guardar(florEntity);
		return "guardado";

	}

	@Operation(summary = "Lista de entidades", description = "Lista todas las flores", tags = { "S05T01N02" })
	@GetMapping(value = "/flor/getAll")
	public String getAll(Model model) {
		ArrayList<FlorDTO> fDTO = (ArrayList<FlorDTO>) florServiceImpl.getAll();
		model.addAttribute("flores", fDTO);
		return "vistaGetAll";

	}

	@Operation(summary = "flomulario buscar ", description = "Llama el formulario para  que se introduzca el id de la entidad a buscar  ", tags = {
			"S05T01N02" })
	@GetMapping(value = "/flor/getOne")
	public String getOneFormulario(@RequestParam Optional<Integer> id, Model model) {
		int idBuscado = id.orElse(0);
		model.addAttribute("id", idBuscado);
		return "buscar";
	}

	@Operation(summary = "Buscar una entidad", description = "Busca una entidad por su id", tags = { "S05T01N02" })
	@GetMapping(value = "/flor/getOne/{id}")
	public String getOne(@RequestParam Integer id, Model model) throws EntityNoEncontradaException {

		FlorDTO florDTO = new FlorDTO();
		FlorEntity florEntity = new FlorEntity();
		florEntity = florServiceImpl.getOne(id);

		try {
			if (florEntity == null) {
				throw new EntityNoEncontradaException("No se encontró ninguna entidad con el ID " + id);
			}

			florDTO = florServiceImpl.pasarASDto(florEntity);
			model.addAttribute("florDTO", florDTO);
			return "vistaGetOne";

		} catch (EntityNoEncontradaException e) {

			model.addAttribute("mensaje", e.getMessage());
			return "florNoEncontrada";

		}

	}

	@Operation(summary = "Actualizar ", description = "Actualiza una entidad", tags = { "S05T01N02" })
	@GetMapping(value = "flor/update/{pk_florID}")
	public String update(@ModelAttribute FlorDTO florDTO, Model model) {

		FlorEntity florEntity = florServiceImpl.getOne(florDTO.getPk_florID());

		model.addAttribute("flor", florEntity);
		return "introducirDatos";
	}

	@Operation(summary = "Borrar entidad", description = "Elimina una entidad", tags = { "S05T01N02" })
	@GetMapping("/flor/delete/{pk_florID}")
	public String delete(@ModelAttribute FlorDTO florDTO) {
		florServiceImpl.delete(florDTO.getPk_florID());
		return "redirect:/flor/getAll";
	}

}
