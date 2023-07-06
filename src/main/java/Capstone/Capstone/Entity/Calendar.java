package Capstone.Capstone.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Calendar {

    @Id @GeneratedValue
    @Column(name = "calendar_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "memberSpec_id")
    private MemberSpec memberSpec;

    private int year;
    private int month;
    private int day;
    private Long ownerId;
    private Boolean progress;

    public void setMemberSpec(MemberSpec memberSpec){
        this.memberSpec = memberSpec;
        memberSpec.getCalendar().add(this);
    }

    public Calendar(int year, int month, int day, Long ownerId ,Boolean progress) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.progress = progress;
        this.ownerId = ownerId;
    }

    public Calendar createCalendar(Calendar calendar) {
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonth().getValue();
        int day = LocalDate.now().getDayOfMonth();

        Long ownerId = memberSpec.getId();
        return new Calendar(year, month, day, ownerId, true);
    }
}
