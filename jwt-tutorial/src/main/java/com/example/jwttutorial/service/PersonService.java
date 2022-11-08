package com.example.jwttutorial.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.jwttutorial.domain.Person;
import com.example.jwttutorial.domain.PersonRepository;
import com.example.jwttutorial.domain.PersonRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	@Transactional
	public Long update(Long id, PersonRequestDto requestDto) {
		Person person1 = personRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
		); 
		person1.update(requestDto);
		return person1.getId();
	}
}
