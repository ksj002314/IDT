package com.example.jwttutorial;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.jwttutorial.domain.Person;
import com.example.jwttutorial.domain.PersonRepository;
import com.example.jwttutorial.domain.PersonRequestDto;
import com.example.jwttutorial.service.PersonService;

@EnableJpaAuditing
@SpringBootApplication
public class JwtTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTutorialApplication.class, args);
	}
	
	public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
		return (args) -> {
			// 데이터 추가
			Person person = new Person("Moon", "Student", "Hwaseongsi");
			personRepository.save(person);
			
			// 데이터 조회
			System.out.println("=======데이터 조회========");
			List<Person> personList = personRepository.findAll();
			
			for(int i=0; i<personList.size(); i++) {
				Person p = personList.get(i);
				System.out.println("ID: " + p.getId());
				System.out.println("이름: " + p.getName());
				System.out.println("직업: " + p.getJob());
				System.out.println("주소: " + p.getAddress());
			}
			
			// 데이터 업데이트
			PersonRequestDto requestDto = new PersonRequestDto("Moonz", "Influencer", "Suwonsi");
			personService.update(1L, requestDto);
			System.out.println("====데이터 업데이트 완료===");
			
			// 데이터 1개 조회
			System.out.println("========데이터 1개 조회========");
			Person one = personRepository.findById(1L).orElseThrow(
				() -> new NullPointerException("아이디가 존재하지 않습니다.")	
			);
			System.out.println("ID: " + one.getId());
			System.out.println("이름: " + one.getName());
			System.out.println("직업: " + one.getJob());
			System.out.println("주소: " + one.getAddress());
		};
	}

}
