package tw.idv.cha102.g7.group.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tw.idv.cha102.g7.group.dto.GroupGroupPicDto;
import tw.idv.cha102.g7.group.dto.GroupListDto;
import tw.idv.cha102.g7.group.dto.GroupRegFormDto;
import tw.idv.cha102.g7.group.dto.MyGroupListDto;
import tw.idv.cha102.g7.group.entity.Group;

import java.util.List;
import java.util.stream.Stream;

public interface GroupService {
    void insert(Group group);

    void update(Integer groupId, Group group);

    void delete(Integer groupId);

    Group getGroupByGroupId(Integer groupId);

    List<Group> getAllPaged(int page, int size);

    List<Group> findByMemIdOrderByGroupStaDesc(Integer memId);
//    List<Group> getGroupsByMemId(Integer memId);
    List<Group> findByThemeContaining(String keyword);

    List<Group> findGroupByGroupSta(Integer groupSta);

    List<Group> findGroupByPaymentSta(Integer paymentSta);

    List<GroupRegFormDto> findGroupRegFormDtoByGroupId(Integer groupId);

    List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(Integer groupId);

    //以自定義方法製作分頁時到Service必須以Stream包裝型別
    //Java 8 API添加了一個新的抽象稱爲流Stream，可以讓你以一種聲明的方式處理數據。
    //Stream 使用一種類似用 SQL 語句從數據庫查詢數據的直觀方式來提供一種對 Java 集合運算和表達的高階抽象。
    Stream<GroupListDto> findGroupListByGroupSta(Integer groupSta, Integer page);

    Stream<MyGroupListDto> findMyGroupListDtoByMemId(Integer memId, Integer page);
}
