package kr.sj.Brain.contoller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.sj.Brain.domain.MemberDTO;
import kr.sj.Brain.service.MemberServiceImpl;

@Controller
@RestController
public class MainController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	@GetMapping("/members")
	public List<MemberDTO> selectAllMemberInfo() { 
		List<MemberDTO> getlistInfo = memberService.getList();
		return getlistInfo;
	}
	
}
	