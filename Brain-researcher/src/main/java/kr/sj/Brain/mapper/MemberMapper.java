package kr.sj.Brain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.sj.Brain.domain.MemberDTO;

@Mapper
public interface MemberMapper {

	
	public List<MemberDTO> getList();
	public void insert(MemberDTO memberi);
}
