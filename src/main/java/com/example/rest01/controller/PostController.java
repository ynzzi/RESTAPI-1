package com.example.rest01.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;
import com.example.rest01.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	@Autowired
	MemberRepository memberRepo;
	
	//http:localhost:8090/api/v1/post-api/domain
	@PostMapping("/domain")
	public String postEx() {
		return "Hello Post API";
	}
	
	// http:localhost:8090/api/v1/post-api/member
	@PostMapping("/member")
	public MemberDto postMember(@RequestBody MemberDto memberDto) {
		
		return memberDto;
	}
	
	// http:localhost:8090/api/v1/post-api/member2
		@PostMapping("/member2")
		public String postMember2(@RequestBody Map<String, Object> postData) {
			StringBuilder sb = new StringBuilder();
			
			postData.entrySet().forEach(map -> {
				sb.append(map.getKey() + ":" + map.getValue() + "\n");
			});
			return sb.toString();
		}
	
	// http:localhost:8090/api/v1/post-api/member3
	@PostMapping("/member3")
	public ResponseEntity<MemberDto> postMember3(@RequestBody MemberDto memberDto) {
		
		List<MemberDto> list = memberRepo.getList();
		// email이 null인 경우
		if(memberDto.getEmail() == null) {
			return ResponseEntity.badRequest().build();			
		}
		// email이 중복인 경우
		for(MemberDto m : list) {
			if(m.getEmail().equals(memberDto.getEmail())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
		// 등록이 잘 된 경우
		if(memberRepo.addList(memberDto)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
		}
		
		return ResponseEntity.unprocessableEntity().build();
	}
	

}
