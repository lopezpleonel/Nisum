package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PersonInfo;
import com.example.demo.service.PersonInfoService;

@RestController
@RequestMapping("/personas")
public class PersonInfoController {

	@Autowired	
	private PersonInfoService p;
	
	@RequestMapping(value = "/Listar", produces = "application/json", method = RequestMethod.GET )
	public List<PersonInfo> listar() {
		return p.getAllPersons();
	}
	
	@RequestMapping(value = "/{Id}", produces = "application/json", method = RequestMethod.GET )
	public @ResponseBody Optional<PersonInfo> getPersonById(@PathVariable final Integer Id) {
		return p.getOnePerson(Id);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/Insertar", method = RequestMethod.POST )
	public ResponseEntity insert(@Valid @RequestBody PersonInfo pers) {
		PersonInfo personInserted = p.savePerson(pers);
		return new ResponseEntity(personInserted, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/Modificar", method = RequestMethod.PUT )
	public ResponseEntity update(@Valid @RequestBody PersonInfo pers) {
		PersonInfo personUpdated = p.savePerson(pers);
		return new ResponseEntity(personUpdated, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/Eliminar/{Id}")
	public ResponseEntity deletePerson(@PathVariable final Integer Id) {
		PersonInfo personDeleted = p.deletePerson(Id);
		return new ResponseEntity(personDeleted, HttpStatus.OK) ;
	}
		
}
