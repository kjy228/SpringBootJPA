package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA를 처음 로딩될 때 JPA를 사용하는 얘구나. 관리해야겠군 인식할 수 있음.
@Table(name = "MBR")
public class Member {
    @Id
    private Long id;

    // DDL 생성 기능 (JPA실행 로직에는 영향을 주지 않음.)
    @Column(unique = true, length = 10)
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}