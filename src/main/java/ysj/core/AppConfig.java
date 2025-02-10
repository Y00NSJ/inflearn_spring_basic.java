package ysj.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ysj.core.discount.DiscountPolicy;
import ysj.core.discount.FixDiscountPolicy;
import ysj.core.discount.RateDiscountPolicy;
import ysj.core.member.MemberRepository;
import ysj.core.member.MemberService;
import ysj.core.member.MemberServiceImpl;
import ysj.core.member.MemoryMemberRepository;
import ysj.core.order.OrderService;
import ysj.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean // 각 메서드가 스프링 컨테이너에 등록됨
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }
}
