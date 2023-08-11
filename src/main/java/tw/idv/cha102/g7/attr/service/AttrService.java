package tw.idv.cha102.g7.attr.service;

import tw.idv.cha102.g7.attr.model.Attr;

import java.util.List;

public interface AttrService {

    Attr getById(Integer attrId);
    List<Attr> getAll();
}
