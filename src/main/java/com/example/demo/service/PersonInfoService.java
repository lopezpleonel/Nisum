package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.PersonInfoRepository;
import com.example.demo.model.PersonInfo;

@Service
public class PersonInfoService {
	
	@Autowired
	private PersonInfoRepository personInfoRepository;
	
	public List<PersonInfo> getAllPersons() {
		return (List<PersonInfo>) this.personInfoRepository.findAll();
	}
	
	public Optional<PersonInfo> getOnePerson(Integer id) {
		return this.personInfoRepository.findById(id);
	}	

	public PersonInfo savePerson(PersonInfo person) {
		return this.personInfoRepository.save(person);
	}	
	
	public PersonInfo deletePerson(Integer id) {
		this.personInfoRepository.deleteById(id);
		return null;
	}	
	
}
