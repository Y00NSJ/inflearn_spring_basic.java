package ysj.core;

import ysj.core.member.Grade;
import ysj.core.member.Member;
import ysj.core.member.MemberService;
import ysj.core.member.MemberServiceImpl;
import ysj.core.order.Order;
import ysj.core.order.OrderService;
import ysj.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
