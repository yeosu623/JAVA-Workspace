package KimYeongHan.SpringLecture2.discount;

import KimYeongHan.SpringLecture2.member.Grade;
import KimYeongHan.SpringLecture2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // data
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // process
        int discount = discountPolicy.discount(member, 10000);

        // test
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // data
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // process
        int discount = discountPolicy.discount(member, 10000);

        // test
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
