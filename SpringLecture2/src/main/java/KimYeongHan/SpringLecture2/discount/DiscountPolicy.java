package KimYeongHan.SpringLecture2.discount;

import KimYeongHan.SpringLecture2.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
