package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded   // 내장 타입이다!!
    private Address address;

    @OneToMany(mappedBy = "member") //나는 Order테이블에 있는 member필드에 의해 매핑된 거울일 뿐이야
    private List<Order> orders = new ArrayList<>();
}