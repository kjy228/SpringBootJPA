package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // jpa에서는 transaction 단위가 매우매우 중요하다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // try-catch문으로 해주는게 좋음.
        try {
            // 엔티티를 생성한 상태로 즉, 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

/*          // jpa는 값을 바꾸면 트랜잭션이 커밋되는 시점에 자동으로 값이 업뎃되는구나
                    굳이 이렇게 안해도 되는구나 알면 된다.
            if(member.getName().equals("ZZZZZ")){
                em.update(member);
            }*/

            // 여기서부터 영속 상태가 된다. 하지만 이때 db에 저장되는게 아니다.
            System.out.println("=== BEFORE ===");
            em.persist(member);
//            em.detach(member);    // 영속성 컨텍스트에서 분리
//            em.remove(member);    // 삭제
            System.out.println("=== AFTER ===");
            // 트랜잭션을 commit하는 순간에 db에 쿼리가 날라간다.
            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}