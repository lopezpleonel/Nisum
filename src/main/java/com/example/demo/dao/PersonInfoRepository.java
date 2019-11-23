package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.PersonInfo;

public interface PersonInfoRepository extends CrudRepository <PersonInfo, Integer> {
	
}
