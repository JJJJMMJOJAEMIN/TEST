package com.example.ABC.service;

import com.example.ABC.Dto.MemberDTO;
import com.example.ABC.Entity.Member;
import com.example.ABC.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //작성
    public void write(MemberDTO memberDTO) {
        Member member = new Member();
        member.setUserId(memberDTO.getUserId());
        member.setName(memberDTO.getName());
        member.setPwd(memberDTO.getPwd());

        memberRepository.save(member);
    }


    //리스트
    public List<Member> memberList() {
        return memberRepository.findAll();
    }

    //뷰
    public Member memberview(Long idx) {
        return memberRepository.findById(idx).get();
    }

    //삭제
    public void memberDelete(Long idx) {
        memberRepository.deleteById(idx);
    }

    //업데이트
    public void memberUpdate(Long idx, MemberDTO memberDTO) {
        Optional<Member> optionalMember = memberRepository.findById(idx);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setUserId(memberDTO.getUserId());
            member.setName(memberDTO.getName());
            member.setPwd(memberDTO.getPwd());
            memberRepository.save(member);
        }
    }

    public String check(String userId) {
        Optional<Member> optionalMember = memberRepository.findByUserId(userId);
        if (optionalMember.isEmpty()) {
            return "ok";
        } else {
            return "no";
        }
    }
}
