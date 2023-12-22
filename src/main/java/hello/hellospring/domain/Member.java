package hello.hellospring.domain;

import jakarta.persistence.*;

/**
 * 회원 Domain Class
 */
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 직접 생성하기 때문에 IDENTITY라고 한다.
    private Long id;

//    @Column(name= "username") // name이 DB에서 username일 경우 mapping 해준다.
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
