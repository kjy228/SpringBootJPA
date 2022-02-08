package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")    // 싱글 테이블에 저장할 때 구분이 되어야하므로 넣어준다
@Getter @Setter
public class Book extends Item {
    private String author;
    private String isbn;
}