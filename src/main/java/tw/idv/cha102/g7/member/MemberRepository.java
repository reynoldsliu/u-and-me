package tw.idv.cha102.g7.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.model.Member;

import java.util.List;

@Component
public interface MemberRepository extends JpaRepository<Member,Integer> {
                                            //CrudRepository
    @Query(value="select id,email,password,address,cellphone from member.memberaccountjpa where EMAIL = ?1 and PASSWORD = ?2 " ,nativeQuery = true)
    List<Member> findCheckMemberAccount(String email, String password);
    List<Member> findAll();

    List<Member> findByEmail(String email);
}
