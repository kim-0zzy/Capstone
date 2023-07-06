package Capstone.Capstone.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Partition {
    private String back;
    private String chest;
    private String shoulder;
    private String leg;
    private String  reps;
    private String  sets;
    private String aerobic;

    public Partition(String back, String chest, String shoulder, String leg, String reps, String sets, String aerobic) {
        this.back = back;
        this.chest = chest;
        this.shoulder = shoulder;
        this.leg = leg;
        this.reps = reps;
        this.sets = sets;
        this.aerobic = aerobic;
    }
}
