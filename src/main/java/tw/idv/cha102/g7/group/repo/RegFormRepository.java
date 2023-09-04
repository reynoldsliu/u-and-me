package tw.idv.cha102.g7.group.repo;

import org.eclipse.tags.shaded.org.apache.bcel.generic.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.cha102.g7.group.dto.RegformIdDto;
import tw.idv.cha102.g7.group.entity.RegForm;

import java.util.List;

public interface RegFormRepository extends JpaRepository<RegForm, Integer> {
    List<RegForm> findByMemIdOrderByRegTime(Integer memId);
    List<RegForm> findByGroupIdOrderByRegTime(Integer groupId);


    @Query(value = "SELECT MAX(form_id) AS formId FROM reg_form", nativeQuery = true)
    RegformIdDto findFormId();
}
