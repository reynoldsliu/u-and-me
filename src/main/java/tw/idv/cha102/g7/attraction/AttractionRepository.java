package tw.idv.cha102.g7.attraction;

import org.springframework.data.repository.CrudRepository;
import tw.idv.cha102.g7.attraction.vo.Attraction;

//                                                            //PK的資料型態
public interface AttractionRepository extends CrudRepository<Attraction,Integer> {
}
