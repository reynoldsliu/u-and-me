package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;

import java.util.List;

@Repository
public interface ScheduleTagRepository extends JpaRepository<ScheduleTag, Integer> {

    public List<ScheduleTag> findBySchTagNameContaining(String schTagName);
}
