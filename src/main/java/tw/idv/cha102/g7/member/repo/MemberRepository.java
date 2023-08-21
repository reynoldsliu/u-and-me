package tw.idv.cha102.g7.member.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.member.entity.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemEmail(String memEmail);

    public Member findByMemNameContaining(String memName);

//    @Query(value = "SELECT mem_grade FROM members WHERE mem_id = memId", nativeQuery = true)
//    public Member findMemberLevelById(@Param("memId") Integer memId);
}
