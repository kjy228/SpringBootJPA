package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // jpa가 처음 로딩될 때 jpa를 사용하는 얘구나. 관리해야겠군 인식할 수 있음.
public class Member {
    @Id
    private Long id;
    private String name;

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