package tw.idv.cha102.g7.activity;

import org.springframework.data.repository.CrudRepository;
import tw.idv.cha102.g7.activity.entity.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
