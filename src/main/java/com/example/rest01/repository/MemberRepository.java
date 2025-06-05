package com.example.rest01.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rest01.dto.MemberDto;

// DB 역할
@Repository
public class MemberRepository {
	
	private List<MemberDto> list = new ArrayList<>();
	
	public MemberRepository() {
		initList();
	}
	
	public void initList() {
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
	}
	
	
	public List<MemberDto> getList(){
		System.out.println(list);
		return list;
	}
	
	public boolean addList(MemberDto member) {
		return list.add(member);
	}
}
