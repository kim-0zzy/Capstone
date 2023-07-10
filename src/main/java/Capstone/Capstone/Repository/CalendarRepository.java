package Capstone.Capstone.Repository;

import Capstone.Capstone.Entity.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CalendarRepository {
    private final EntityManager em;

    public void save(Calendar calendar){
        em.persist(calendar);
    }

    public List findByOwnerId(Long id){
        return em.createQuery("select c from Calendar c where c.ownerId =: id", Calendar.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List findByOwnerIdWithYear(Long id, int year){
        return em.createQuery("select c from Calendar c where c.ownerId =: id " +
                        "and c.year =: year", Calendar.class)
                .setParameter("id", id)
                .setParameter("year", year)
                .getResultList();
    }

    public List findByOwnerIdWithYM(Long id, int year, int month){
        return em.createQuery("select c from Calendar c where c.ownerId =: id " +
                        "and c.year =: year and c.month =: month", Calendar.class)
                .setParameter("id", id)
                .setParameter("year", year)
                .setParameter("month", month)
                .getResultList();
    }

    public Optional findByOwnerIdWithYMD(Long id, int year, int month, int day){
        return em.createQuery("select c from Calendar c where c.ownerId =: id " +
                "and c.year =: year and c.month =: month and c.day =: day", Calendar.class)
                .setParameter("id", id)
                .setParameter("year", year)
                .setParameter("month", month)
                .setParameter("day", day)
                .getResultList().stream().findFirst();
    }
}
