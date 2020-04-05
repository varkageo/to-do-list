package ar.java.toDoPro.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ar.java.toDoPro.Repositories.*;
import ar.java.toDoPro.DTO.*;
import ar.java.toDoPro.Models.*;
import java.util.*;

import java.lang.*;
@RestController
@RequestMapping("tarea")
public class TareaControllers {
	
	@Autowired
	private TareaRepository tareaRepository;
	
	@GetMapping("/{id}")
	public TareaDTO listarUna(@PathVariable Integer id) {
		
		TareaDTO respuesta = new TareaDTO();
		Tarea unaTarea = new Tarea();
		
		if(unaTarea == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
		}
		
		respuesta.setId(unaTarea.getId());
		respuesta.setAsignadaA(unaTarea.getAsignadaA());
		respuesta.setDescripcion(unaTarea.getDescripcion());
		respuesta.setFechaInicio(unaTarea.getFechaInicio());
		respuesta.setFechaRealizada(unaTarea.getFechaRealizada());
		respuesta.setRealizada(unaTarea.isRealizada());
	
		return respuesta;
	}
	
	@PostMapping("/")
	public TareaDTO guardar(@RequestBody TareaDTO body) {
		TareaDTO respuesta = new TareaDTO();
		Tarea tareaGuardar = new Tarea();
		
		respuesta.setAsignadaA(tareaGuardar.getAsignadaA());
		respuesta.setDescripcion(tareaGuardar.getDescripcion());
		respuesta.setFechaInicio(tareaGuardar.getFechaInicio());
		respuesta.setFechaRealizada(tareaGuardar.getFechaRealizada());
		respuesta.setRealizada(tareaGuardar.isRealizada());
		
		this.tareaRepository.save(tareaGuardar);
		
		respuesta.setId(tareaGuardar.getId());
		respuesta.setAsignadaA(tareaGuardar.getAsignadaA());
		respuesta.setDescripcion(tareaGuardar.getDescripcion());
		respuesta.setFechaInicio(tareaGuardar.getFechaInicio());
		respuesta.setFechaRealizada(tareaGuardar.getFechaRealizada());
		respuesta.setRealizada(tareaGuardar.isRealizada());
		
		
		
		
		
		return respuesta;
	}
	
	

}
