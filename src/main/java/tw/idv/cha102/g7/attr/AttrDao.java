package tw.idv.cha102.g7.attr;

import java.util.List;

public interface AttrDao {

    Attr getById(Integer attrId);
    List<Attr> getAll();
}
