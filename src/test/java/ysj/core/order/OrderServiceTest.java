package ysj.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ysj.core.member.Grade;
import ysj.core.member.Member;
import ysj.core.member.MemberService;
import ysj.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(1000, order.getDiscountPrice());
    }
}
