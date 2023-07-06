package Capstone.Capstone.Service.Impl;

import Capstone.Capstone.Entity.Member;
import Capstone.Capstone.Exception.NotFoundIdException;
import Capstone.Capstone.Exception.PasswordException;
import Capstone.Capstone.Repository.MemberRepository;
import Capstone.Capstone.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service("MemberService")
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validationDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    public void login(Member member, String passwd) throws PasswordException, NotFoundIdException{
        Member findMember = memberRepository.findById(member.getId());
        if(findMember == null){
            throw new NotFoundIdException("존재하지 않는 계정입니다.");
        }
        validationPassword(member, passwd);
    }


    public List<Member> findMembers(Member member) {
        return memberRepository.findAll();
    }


    public Member findOneById(Long id) {
        return memberRepository.findById(id);
    }


    public List findOneByName(String name) {
        return memberRepository.findByName(name);
    }
    public List findByUserId(String id){
        return memberRepository.findByUserId(id);
    }
    private void validationDuplicateMember(Member member){
        List findMember = memberRepository.findByUserId(member.getUserId());
        if(!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    private void validationPassword(Member member, String passwd) throws PasswordException{
        Member findMember = memberRepository.findById(member.getId());
        if(!Objects.equals(findMember.getPassword(), passwd)){
            throw new PasswordException("비밀번호가 맞지 않습니다");
        }

    }

}
