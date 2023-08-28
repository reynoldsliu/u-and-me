package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagList;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagListId;

import java.util.List;

public interface ScheduleTagListRepository extends JpaRepository<ScheduleTagList, ScheduleTagListId> {

    public List<ScheduleTagList> findByScheduleTagListId(ScheduleTagListId listId);

    public void deleteByScheduleTagListId(ScheduleTagListId listId);
}
