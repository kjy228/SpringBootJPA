package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", insertable = false, updatable = true)
    private String username;

    private Integer age;

    // Enum타입을 ORDINAL로 하면 enum 추가 시에 순서 꼬일 수 있음.
    @Enumerated(EnumType.STRING)    // enum의 이름을 db에 저장
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob    // 매핑하는 필드가 문자니까 CLOB으로 매핑
    private String description;

    @Transient // 메모리에서만 쓰고 매핑 안할 때 사용
    private int temp;

    public void setId(long l) {
    }

    public void setName(String b) {
    }

    public void setRoleType(RoleType admin) {
    }
}