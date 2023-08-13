package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;

@Repository
public interface ScheduleTagRepository extends JpaRepository<ScheduleTag, Integer> {

}
