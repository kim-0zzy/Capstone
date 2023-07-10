package Capstone.Capstone.Repository;

import Capstone.Capstone.Entity.MemberSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberSpecRepository {
    private final EntityManager em;

    public void save(MemberSpec memberSpec) {
        em.persist(memberSpec);
    }

    public MemberSpec findById(Long id) {
        return em.find(MemberSpec.class, id);
    }

    public List findAll() {
        return em.createQuery("select ms from MemberSpec ms", MemberSpec.class)
                .getResultList();
    }

//    public Optional<MemberSpec> findByMemberId(Long id){ // 이게맞나? 고민해볼것.
//        MemberSpec memberSpec = em.createQuery("select ms from MemberSpec ms where ms.member.id =: id")
//                .setParameter("id",id)
//                .getSingleResult();
//        return Optional.ofNullable(memberSpec);
//        }

//    public Optional findByMemberId(Long id){
//        return em.createQuery("select ms from MemberSpec ms inner join ms.member m where m.id =: id")
//                .setParameter("id",id)
//                .getResultList().stream().findFirst();
//    }

    public Optional findByMemberId(Long id) { // 이거 join 해야함
        return em.createQuery("select ms from MemberSpec ms where ms.member.id =: id", MemberSpec.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst();
    }

    public Optional findByMemberIdV2(Long id) { // join 한거임
        return em.createQuery("select ms from MemberSpec ms" +
                        " join fetch ms.member m"+
                        " where m.id =: id", MemberSpec.class)
                .setParameter("id", id)
//                .setFirstResult(offset) -> 파라미터에 추가
//                .setMaxResults(limit)
                .getResultList().stream().findFirst();
    }

}