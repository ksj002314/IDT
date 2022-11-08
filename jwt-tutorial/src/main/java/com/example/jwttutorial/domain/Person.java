package com.example.jwttutorial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String job;
	
	// API 응답 시 사용됨
	public Person(PersonRequestDto requestDto) {
		this.name = requestDto.getName();
		this.address = requestDto.getAddress();
		this.job = requestDto.getJob();
	}
	
	// main 함수에서 사용
	public Person(String name, String job, String address) {
		this.name = name;
		this.address = address;
		this.job = job;
	}
	
	// personRequestDto로 업데이트 시
	public void update(PersonRequestDto requestDto) {
		this.name = requestDto.getName();
		this.address = requestDto.getAddress();
		this.job = requestDto.getJob();
	}
}
