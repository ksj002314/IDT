package com.example.rest2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserProfile {
	private String id;
	private String name;
	private String phone;
	private String address;
}
