package com.example.jwttutorial.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonRequestDto {
	
	private String name;
	private String job;
	private String address;
	
	
	// 생성자
	public PersonRequestDto(String name, String job, String address) {
		this.name = name;
		this.job = job;
		this.address = address;
	}
	
	
}
