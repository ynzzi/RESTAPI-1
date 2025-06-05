package com.example.rest01.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest01.dto.MemberDto;
import com.example.rest01.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	@Autowired
	MemberRepository memberRepo;
	
	List<MemberDto> list = new ArrayList<>();
	// http://localhost:8090/api/v1/get-api/hello
	// Hello World가 반환되도록 구현
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	// http://localhost:8090/api/v1/get-api/variable1/{variable}
	@GetMapping("/variable1/{variable}")
	public String variable1(@PathVariable("variable") String variable) {
		return variable;
	}
	
	// http://localhost:8090/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping("/request1")
	public String request1(@RequestParam("name") String name,
						   @RequestParam("email") String email,
						   @RequestParam("organization") String organization) {
		
		return "name : " + name + ", email : " + email + ", organization : " + organization;
	}
	
	// http://localhost:8090/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping("/request2")
	public Map<String, Object> request2() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "윤지");
		map.put("age", 20);
		return map;
	}
	
	// http://localhost:8090/api/v1/get-api/request3?key1=value1&key2=value2
	@GetMapping("/request3")
	public String getRequest3(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		System.out.println(sb);
		return sb.toString();
	}
	
	// http://localhost:8090/api/v1/get-api/request4?name=value1&email=value2&organization=value3
	@GetMapping("/request4")
	public String request4(MemberDto memberDto) {
		
		return memberDto.toString();
		
	}
	
	// http://localhost:8090/api/v1/get-api/request5/{name}
	@GetMapping("/request5/{name}")
	public MemberDto request5(@PathVariable("name") String name){
		MemberDto member1 = new MemberDto();
		member1.setName("Ann");
		member1.setEmail("ann@green.com");
		member1.setOrganization("GREEN");
		
		MemberDto member2 = new MemberDto();
		member2.setName("Ben");
		member2.setEmail("ben@green.com");
		member2.setOrganization("GREEN");
		
		MemberDto member3 = new MemberDto();
		member3.setName("Choi");
		member3.setEmail("choi@green.com");
		member3.setOrganization("GREEN");
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
		
		MemberDto member = null;
		
		// 검색
		for(MemberDto m : list) {
			if(name.equals(m.getName())) {
				return m;
			}
		}

		// 검색해서 나오면 멤버 정보 리턴
		return member;
	}
	
	// http://localhost:8090/api/v1/get-api/request5/{name}
	@GetMapping("/request6/{name}")
	public int request6(@PathVariable("name") String name){
		MemberDto member1 = new MemberDto();
		member1.setName("Ann");
		member1.setEmail("ann@green.com");
		member1.setOrganization("GREEN");
		
		MemberDto member2 = new MemberDto();
		member1.setName("Ben");
		member1.setEmail("ben@green.com");
		member1.setOrganization("GREEN");
		
		MemberDto member3 = new MemberDto();
		member1.setName("Choi");
		member1.setEmail("choi@green.com");
		member1.setOrganization("GREEN");
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
		
		
		for(MemberDto m : list) {
			if(name.equals(m.getName())) {
				return 200;
			}
		}
		return 404;

	}
	
	// http://localhost:8090/api/v1/get-api/request7/{name}
		@GetMapping("/request7/{name}")
		public Map<Integer, MemberDto> request7(@PathVariable("name") String name){
			MemberDto member1 = new MemberDto();
			member1.setName("Ann");
			member1.setEmail("ann@green.com");
			member1.setOrganization("GREEN");
			
			MemberDto member2 = new MemberDto();
			member2.setName("Ben");
			member2.setEmail("ben@green.com");
			member2.setOrganization("GREEN");
			
			MemberDto member3 = new MemberDto();
			member3.setName("Choi");
			member3.setEmail("choi@green.com");
			member3.setOrganization("GREEN");
			
			list.add(member1);
			list.add(member2);
			list.add(member3);
			
			Map<Integer, MemberDto> result = new HashMap<>(); 
			// 검색
			boolean flag = false;
			for (MemberDto m : list) {
				if(m.getName().equals(name)) {
					result.put(200, m);
					flag= true;
					break;
				}
			}
			if (!flag) {
				result.put(404, null);
			}
			return result;

		}
		
		// http://localhost:8090/api/v1/get-api/request8/{name}
		@GetMapping("/request8/{name}")
		public ResponseEntity<MemberDto> request8(@PathVariable("name") String name){
			MemberDto member1 = new MemberDto();
			member1.setName("Ann");
			member1.setEmail("ann@green.com");
			member1.setOrganization("GREEN");
			
			MemberDto member2 = new MemberDto();
			member2.setName("Ben");
			member2.setEmail("ben@green.com");
			member2.setOrganization("GREEN");
			
			MemberDto member3 = new MemberDto();
			member3.setName("Choi");
			member3.setEmail("choi@green.com");
			member3.setOrganization("GREEN");
			
			list.add(member1);
			list.add(member2);
			list.add(member3);
			// this.list = list;
		
			// 검색
			for (MemberDto m : list) {
				if(m.getName().equals(name)) {
					// 1) return ResponseEntity.status(HttpStatus.OK).body(m);
					// 2) return ResponseEntity.status(200).body(m);
					return ResponseEntity.ok(m); // 3)
				}
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
		
		// http://localhost:8090/api/v1/get-api/request9
		@GetMapping("/request9")
		public List<MemberDto> request9() {
			List<MemberDto> list = memberRepo.getList();
			return list;
		}

			

}
