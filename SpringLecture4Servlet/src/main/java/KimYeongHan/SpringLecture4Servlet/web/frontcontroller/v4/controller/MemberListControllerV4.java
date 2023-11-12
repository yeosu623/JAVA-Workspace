package KimYeongHan.SpringLecture4Servlet.web.frontcontroller.v4.controller;

import KimYeongHan.SpringLecture4Servlet.domain.member.Member;
import KimYeongHan.SpringLecture4Servlet.domain.member.MemberRepository;
import KimYeongHan.SpringLecture4Servlet.web.frontcontroller.ModelView;
import KimYeongHan.SpringLecture4Servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
