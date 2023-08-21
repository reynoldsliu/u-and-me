package tw.idv.cha102.g7.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.group.entity.RegForm;

import java.util.List;

public interface RegFormRepository extends JpaRepository<RegForm, Integer> {
    List<RegForm> findByMemIdOrderByRegTime(Integer memId);

    List<RegForm> findByGroupIdOrderByRegTime(Integer groupId);
}
