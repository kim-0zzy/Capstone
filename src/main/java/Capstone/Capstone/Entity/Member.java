package Capstone.Capstone.Entity;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    public Member(String username, String userId, String password) {
        this.username = username;
        this.userId = userId;
        this.password = password;
    }

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String userId;
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private MemberSpec memberSpec;

    public void setMemberSpec(MemberSpec memberSpec) {
        this.memberSpec = memberSpec;
    }
}
