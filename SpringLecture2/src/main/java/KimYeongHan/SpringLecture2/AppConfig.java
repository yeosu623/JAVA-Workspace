package KimYeongHan.SpringLecture2;

import KimYeongHan.SpringLecture2.discount.DiscountPolicy;
import KimYeongHan.SpringLecture2.discount.FixDiscountPolicy;
import KimYeongHan.SpringLecture2.discount.RateDiscountPolicy;
import KimYeongHan.SpringLecture2.member.MemberRepository;
import KimYeongHan.SpringLecture2.member.MemberService;
import KimYeongHan.SpringLecture2.member.MemberServiceImpl;
import KimYeongHan.SpringLecture2.member.MemoryMemberRepository;
import KimYeongHan.SpringLecture2.order.OrderService;
import KimYeongHan.SpringLecture2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
         return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
