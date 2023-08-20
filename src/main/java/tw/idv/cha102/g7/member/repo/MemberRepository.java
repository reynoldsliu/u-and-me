package tw.idv.cha102.g7.member.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    public Member findByMemNameContaining(String memName);
}
