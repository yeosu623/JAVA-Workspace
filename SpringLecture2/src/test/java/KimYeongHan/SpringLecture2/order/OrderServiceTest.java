package KimYeongHan.SpringLecture2.order;

import KimYeongHan.SpringLecture2.AppConfig;
import KimYeongHan.SpringLecture2.member.Grade;
import KimYeongHan.SpringLecture2.member.Member;
import KimYeongHan.SpringLecture2.member.MemberService;
import KimYeongHan.SpringLecture2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
}
