package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    // 스프링이 EntityManager를 만들어서 주입시켜준다
//    @PersistenceContext
//    private EntityManager em;
    private final EntityManager em;

    // 트랜잭션이 commit되는 시점에 db에 반영
    // insert를 날려주는 부분
    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        // jpa의 findOne라는 메소드를 사용 (단건조회)
        // find(타입, pk)
        return em.find(Member.class, id);
    }
    public List<Member> findAll() {
        // jpql은 form의 대상이 table이 아닌 entity를 대상으로 쿼리 실행
        // createQuery(qlString, 반환타입)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}