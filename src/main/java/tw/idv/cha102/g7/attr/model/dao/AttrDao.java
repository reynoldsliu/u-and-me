package tw.idv.cha102.g7.attr.model.dao;

import tw.idv.cha102.g7.attr.model.Attr;

import java.util.List;

public interface AttrDao {

    Attr getById(Integer attrId);
    List<Attr> getAll();
}
