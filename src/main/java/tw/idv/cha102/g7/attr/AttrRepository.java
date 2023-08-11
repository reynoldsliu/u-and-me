package tw.idv.cha102.g7.attr;

import org.springframework.data.repository.CrudRepository;
import tw.idv.cha102.g7.attr.model.Attr;

//                                                            //PK的資料型態
public interface AttrRepository extends CrudRepository<Attr,Integer> {
}
