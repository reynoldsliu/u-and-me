package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.entity.ScheduleTagDTO;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> findAllPublic() {
        return repository.findOrderBySchStart();
    }

    @Override
    public List<Schedule> findBySchName(String schName) {
        return repository.findBySchName(schName);
    }

    @Override
    public List<Schedule> findBetweenDate(Date schStart, Date schEnd) {
        return repository.findBetweenDate(schStart, schEnd);
    }


    @Override
    public Schedule getById(Integer schId) {
        Schedule schedule = repository.findById(schId).orElse(null);
        return schedule;
    }

    @Override
    public void add(Schedule schedule) {
        repository.save(schedule);
    }


    @Override
    public void hideById(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開設定
        var schedule = repository.findById(schId);
        if (schedule.isPresent()) {
            schedule.get().setSchPub(0);
            // 修改行程公開權限為0:私人檢視
            repository.save(schedule.get());
        }
    }

    @Override
    public void deleteById(Integer schId) {
        repository.deleteById(schId);
    }

    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @Override
    public Schedule getOneById(Integer schId) {
        Schedule schedule = repository.findByIdOrderByStarttime(schId);
        schedule.setScheduleDetails(schedule.getScheduleDetails().stream().sorted(Comparator.comparing(ScheduleDetail::getSchdeStarttime)).collect(Collectors.toList()));
        return schedule;
    }

    @Override
    public List<ScheduleTagDTO> findTagsInOneSchdule(Integer schId){
        List<Object[]> list = repository.findTagsByOneSchedule(schId);
        List<ScheduleTagDTO> collect = list.stream().map(ScheduleTagDTO::new).collect(Collectors.toList());
        return collect;
    }
}


