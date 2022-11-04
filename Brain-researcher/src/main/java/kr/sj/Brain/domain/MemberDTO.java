package kr.sj.Brain.domain;

import lombok.Data;

@Data
public class MemberDTO {
	
	private int memberidx;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberAddr;
}
