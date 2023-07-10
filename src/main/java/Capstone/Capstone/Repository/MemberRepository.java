package Capstone.Capstone.Repository;

import Capstone.Capstone.Entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    public void save(Member member){
        em.persist(member);
    }
    public Member findById(Long id){
        return em.find(Member.class, id);
    }
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    public List findByName(String name){
        return em.createQuery("select m from Member m where m.username = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List findByUserId(String id){
        return em.createQuery("select m from Member m where m.userId =: usedId", Member.class)
                .setParameter("usedId", id)
                .getResultList();
    }
}
