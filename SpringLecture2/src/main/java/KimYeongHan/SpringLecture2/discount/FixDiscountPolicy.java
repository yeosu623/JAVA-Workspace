package KimYeongHan.SpringLecture2.discount;

import KimYeongHan.SpringLecture2.member.Grade;
import KimYeongHan.SpringLecture2.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
