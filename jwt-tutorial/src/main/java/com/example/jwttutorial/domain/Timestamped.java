package com.example.jwttutorial.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {
	
	@CreatedDate	// Entity가 생성되어 저장될 때 시간이 자동 저장
	private LocalDateTime createdAt;
	@LastModifiedDate	// 조회한 Entity의 값을 변경할 때 시간이 자동 저장
	private LocalDateTime modifiedAt;
}
