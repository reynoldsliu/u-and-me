package tw.idv.cha102.g7.member.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.member.entity.Host;
import tw.idv.cha102.g7.member.entity.Member;

import java.util.Optional;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> {
    Optional<Host> findByhostEmail(String hostEmail);

}
