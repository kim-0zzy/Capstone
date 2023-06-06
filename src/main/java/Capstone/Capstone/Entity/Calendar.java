package Capstone.Capstone.Entity;

import Capstone.Capstone.Entity.E_type.Level;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calendar {
    @Id @GeneratedValue
    @Column(name = "calendar_id")
    private Long id;
    //private MemberSpec memberSpec;
    private int year;
    private int month;
    private int day;
}
