package KimYeongHan.SpringLecture2.order;

import KimYeongHan.SpringLecture2.discount.DiscountPolicy;
import KimYeongHan.SpringLecture2.discount.FixDiscountPolicy;
import KimYeongHan.SpringLecture2.member.Member;
import KimYeongHan.SpringLecture2.member.MemberRepository;
import KimYeongHan.SpringLecture2.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
