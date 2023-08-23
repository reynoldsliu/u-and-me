package tw.idv.cha102.g7.member.repo;

import tw.idv.cha102.g7.member.entity.Host;

import java.util.Optional;

public interface HostToMemberRepository {
    Optional<Host> findByhostEmail(String hostEmail);
}
