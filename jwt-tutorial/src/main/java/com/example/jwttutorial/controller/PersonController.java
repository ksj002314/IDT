package com.example.jwttutorial.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwttutorial.domain.Person;
import com.example.jwttutorial.domain.PersonRepository;
import com.example.jwttutorial.domain.PersonRequestDto;
import com.example.jwttutorial.service.PersonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PersonController {
	private final PersonRepository personRepository;
	private final PersonService personService;
	
	// 추가
	@PostMapping("/api/persons")
	public Person creatPerson(@RequestBody PersonRequestDto requestDto) {
		Person person = new Person(requestDto);
		return personRepository.save(person);
	}
	
	// 조회
	@GetMapping("/api/persons")
	public List<Person> getPersons() {
		return personRepository.findAll();
	}
	
	// 수정
	@PutMapping("/api/persons/{id}")
	public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
		return personService.update(id, requestDto);
	}
	
	// 삭제
	@DeleteMapping("/api/persons/{id}")
	public Long deletePerson(@PathVariable Long id) {
		personRepository.deleteById(id);
		return id;
	}
}
