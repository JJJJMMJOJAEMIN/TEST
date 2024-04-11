package com.example.ABC.controller;


import com.example.ABC.Dto.MemberDTO;
import com.example.ABC.Entity.Member;
import com.example.ABC.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    //회원 가입 작성
    @GetMapping("/member/write")
    public String MemberWrite(){
        return "M_write";
    }

    //회원 가입 작성 처리
    @PostMapping("/member/writepr")
    public String MemberWritePr(@ModelAttribute MemberDTO memberDTO) {
        memberService.write(memberDTO);
        return "redirect:/member/list";
    }
    //리스트
    @GetMapping("/member/list")
    public String memberList(Model model) {
        model.addAttribute("list",memberService.memberList());
        return "M_list";
    }

    //뷰
    @GetMapping("/member/view")
    public String memberView(Model model,@RequestParam Long idx){
        model.addAttribute("member", memberService.memberview(idx));
        return "M_view";
    }

    //삭제
    @GetMapping("/member/delete")
    public String memberDelete(@RequestParam Long idx){
        memberService.memberDelete(idx);
        return "redirect:/member/list";
    }


    //수정
    @GetMapping("/member/modify/{idx}")
    public String memberModify(@PathVariable("idx") Long idx, Model model){

        model.addAttribute("member", memberService.memberview(idx));
        return "M_modify";
    }

    //업데이트
    @PostMapping("member/update/{idx}")
    public String memberUpdate(@PathVariable("idx") Long idx, @ModelAttribute MemberDTO memberDTO){
        memberService.memberUpdate(idx, memberDTO); // idx와 memberDTO를 전달합니다.
        return "redirect:/member/list";
    }

    //아이디 중복체크
    @PostMapping("/member/IdCheck")
    public @ResponseBody String idCheck(@RequestParam(name = "userId") String userId) {
        String checkResult = memberService.check(userId);
        return checkResult;
    }
}
