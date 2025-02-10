package ysj.core;

import ysj.core.discount.FixDiscountPolicy;
import ysj.core.member.MemberService;
import ysj.core.member.MemberServiceImpl;
import ysj.core.member.MemoryMemberRepository;
import ysj.core.order.OrderService;
import ysj.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
