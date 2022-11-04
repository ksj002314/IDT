package kr.sj.Brain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.sj.Brain.domain.MemberDTO;
import kr.sj.Brain.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberDTO> getList() {
		return mapper.getList();
	}

}
