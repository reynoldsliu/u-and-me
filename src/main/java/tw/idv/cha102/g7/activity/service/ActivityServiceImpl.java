package tw.idv.cha102.g7.activity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.activity.entity.Activity;
import tw.idv.cha102.g7.activity.repository.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository repository;


    public Activity getById(Integer activId){
        Activity activity = repository.findById(activId).orElse(null);
        return activity;
    }

    @Override
    public List<Activity> findByActivName(String activName) {
        return repository.findByActivName(activName);
    }

    @Override
    public List<Activity> findByActivCon(String activCon) {
        return repository.findByActivCon(activCon);
    }

    @Override
    public void insert(Activity activity) {
        repository.save(activity);
    }

    @Override
    public void deleteById(Integer activId) {
        repository.deleteById(activId);
    }

    @Override
    public void updateById(Integer activId, Activity activity) {
        repository.save(activity);
    }



}
