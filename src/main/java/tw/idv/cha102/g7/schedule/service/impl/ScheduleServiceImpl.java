package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.schedule.dto.ScheduleDayDTO;
import tw.idv.cha102.g7.schedule.dto.ScheduleDaysDTO;
import tw.idv.cha102.g7.schedule.dto.TagToSchedulesDTO;
import tw.idv.cha102.g7.schedule.entity.Schedule;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<Schedule> getAllPaged(int page, int size) {
        List<Schedule> publicSche = repository.findAllPublic();
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, publicSche.size());

        List<Schedule> pagedPublicSchedules = publicSche.subList(startIndex, endIndex);
//
//        Page<Schedule> pageResult = repository.findAll(
//                PageRequest.of(page, //查詢的頁數 從0開始
//                        size,//查詢的每頁筆數
//                        Sort.by("schStart").descending())); //依造sch_start欄位降冪排序
//            List<Schedule> scheduleList = pageResult.getContent();
//            List<Schedule> filtScheList = scheduleList.stream().filter(schedule -> schedule.getSchPub() == 2).collect(Collectors.toList());
//        (航)可能會運用到的方法
//        pageResult.getNumberOfElements(); //本頁筆數
//        pageResult.getSize(); //每頁筆數
//        pageResult.getTotalElements(); //全部筆數
//        pageResult.getTotalPages(); //全部頁數
        return pagedPublicSchedules;
    }

    @Override
    public List<Schedule> findAllPublic() {
        return repository.findAllPublic();
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
    public List<ScheduleDayDTO> findByDays() {
        return repository.findByDays();
    }


    @Override
    public Schedule getById(Integer schId) {
        Schedule schedule = repository.findById(schId).orElse(null);
        return schedule;
    }

    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }


    // 查詢行程及其細節，並依照行程細節起始時間排序
    // @OneToMany的Join寫法
//    @Override
//    public Schedule getOneById(Integer schId) {
//        Schedule schedule = repository.findByIdOrderByStarttime(schId);
//        schedule.setScheduleDetails(schedule.getScheduleDetails().stream().sorted(Comparator.comparing(ScheduleDetail::getSchdeStarttime)).collect(Collectors.toList()));
//        return schedule;
//    }


    // 有重複行程資料的問題
    @Override
    public List<TagToSchedulesDTO> findTagsInOneSchdule(Integer schId) {
        List<Object[]> list = repository.findTagsByOneSchedule(schId);
        List<TagToSchedulesDTO> collect = list.stream().map(TagToSchedulesDTO::new).collect(Collectors.toList());
        return collect;
    }


    /***
     * 以上為搜瀏覽公開行程相關功能
     * 以下為管理行程功能
     */

    @Override
    public List<Schedule> getAllByMemId(Integer memId) {
        List<Schedule> schedules = repository.findByMemId(memId);
        return schedules;
    }

    @Override
    public void create(Schedule schedule) {
        repository.save(schedule);
    }

    @Override
    public void delete(Integer schId) {
        repository.deleteById(schId);
    }

    @Override
    public String edit(Integer schId, Schedule schedule) {
        // sche 為資料庫中已存在的行程，sche存在才能更新，否則回傳查詢不到資料
        Schedule sche = repository.findById(schId).orElse(null);
        if (sche != null) {  // schedule為欲修改的行程資料
            sche.setSchName(schedule.getSchName());
//            sche.setSchStart(schedule.getSchStart());
//            sche.setSchEnd(schedule.getSchEnd());
//            sche.setSchCost(schedule.getSchCost());
//            sche.setSchPub(schedule.getSchPub());
//            sche.setSchCopy(schedule.getSchCopy());
            repository.save(sche);
            return "更新成功！";
        } else {
            return "更新失敗，查詢的行程不存在";
        }
    }

    @Override
    public void hide(Integer schId) {
        // 先查詢此id的行程是否存在，再進行行程公開設定
        var schedule = repository.findById(schId);
        if (schedule.isPresent()) {
            schedule.get().setSchPub((byte) 0);
            // 修改行程公開權限為0:私人檢視
            repository.save(schedule.get());
        }
    }
}


