package ysj.core.order;

import ysj.core.discount.DiscountPolicy;
import ysj.core.discount.FixDiscountPolicy;
import ysj.core.discount.RateDiscountPolicy;
import ysj.core.member.Member;
import ysj.core.member.MemberRepository;
import ysj.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 할인 관련 로직은 전혀 모름, discountPolicy에게 책임 전가
        int discountPrice = discountPolicy.discount(member, itemPrice); // 등급만 넘겨도 되나, 확장성 고려한 설계

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
