package Capstone.Capstone.Entity;

import Capstone.Capstone.Entity.E_type.Gender;
import Capstone.Capstone.Entity.E_type.Goals;
import Capstone.Capstone.Entity.E_type.Level;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSpec {

    @Id @GeneratedValue
    @Column(name = "memberSpec_id")

    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "memberSpec")
    @JoinColumn(name = "calendar_id")
    private List<Calendar> calendar = new ArrayList<Calendar>();


    private int height;
    private int weight;
    private int waist;
    private int hip;
    private int career; // 커리어 누적로직, 업데이트 로직 구현
    private int age;
    private int times;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Goals goals;
    @Enumerated(EnumType.STRING)
    private Level level;


    // 연관관계 메서드
    public void setMember(Member member){
        this.member = member;
        member.setMemberSpec(this);
    }

    public void setRoutine(Routine routine){
        this.routine = routine;
        routine.setMemberSpec(this);
    }

    public void setCalendar(Calendar calendar){
        this.calendar = (List<Calendar>) calendar;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    } // 생성자로 만들지 고민해볼 것.

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public void setTimes(int times) {
        this.times = times;
    }
    public void addCareer(){
        this.career += 1;
    }

// 처음엔 Routine 이랑 Calendar 비워진 채로 생성됨.
    // 입력받은 데이터를 바탕으로 Controller?에서 비즈니스 로직으로 Level  산출해야함.
    public MemberSpec(Member member,
                      int height, int weight, int waist, int hip, int career, int age, int times,
                      Gender gender, Goals goals, Level level) {
        this.member = member;
        this.height = height;
        this.weight = weight;
        this.waist = waist;
        this.hip = hip;
        this.career = career;
        this.age = age;
        this.times = times;
        this.gender = gender;
        this.goals = goals;
        this.level = level;
    }
 // Member Routine Calendar 생성/영속 후 집어넣는 방식임.
    public static MemberSpec createMemberSpec(MemberSpec memberSpec, Member member, Routine routine, Calendar calendar){
        routine = new Routine();
        routine.makeNutrition(memberSpec);
        routine.makePartition(memberSpec);
        memberSpec.setRoutine(routine);

        calendar = new Calendar();
        memberSpec.setCalendar(calendar);
        return memberSpec;
    }
}
