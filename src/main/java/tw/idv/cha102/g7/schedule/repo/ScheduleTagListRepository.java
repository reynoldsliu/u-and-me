package tw.idv.cha102.g7.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.schedule.dto.ScheduleTagListDTO;
import tw.idv.cha102.g7.schedule.dto.ScheduleTagListId;

import java.util.List;

public interface ScheduleTagListRepository extends JpaRepository<ScheduleTagListDTO, ScheduleTagListId> {

    public List<ScheduleTagListDTO> findByScheduleTagListId(ScheduleTagListId listId);

    public void deleteByScheduleTagListId(ScheduleTagListId listId);
}
