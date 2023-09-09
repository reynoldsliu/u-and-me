package tw.idv.cha102.g7.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.schedule.dto.ScheduleDetailsDTO;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.entity.ScheduleTag;
import tw.idv.cha102.g7.schedule.repo.ScheduleDetailRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleRepository;
import tw.idv.cha102.g7.schedule.repo.ScheduleTagRepository;
import tw.idv.cha102.g7.schedule.service.ScheduleDetailService;

import java.util.List;

@Service
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

    @Autowired
    private ScheduleDetailRepository detailRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleTagRepository tagRepository;


    @Override
    public ScheduleDetail findOneDetail(Integer schdeId) {
        return detailRepository.findById(schdeId).orElse(null);
    }

    @Override
    public List<ScheduleDetail> findBySchId(Integer schId) {
        return detailRepository.findBySchId(schId);
    }

    @Override
    public void updateDetails(ScheduleDetail scheduleDetail) {
        if (scheduleDetail != null) {
            detailRepository.save(scheduleDetail);
        }
    }

    @Override
    public void deleteDetail(Integer schdeId) {
        detailRepository.deleteById(schdeId);
    }

    @Transactional
    @Override
    public int deleteDetailsInSch(Integer schId) {
        return detailRepository.deleteBySchId(schId);
    }

//    @Override
//    public ScheduleDetailsDTO findAllDetailsBySchId(Integer schId) {
//        ScheduleDetailsDTO dto = new ScheduleDetailsDTO();
//        Object[] objects = {};
//        scheduleRepository.findById(schId);
//        detailRepository.findBySchId(schId);
//
//        return null;
//    }
}
