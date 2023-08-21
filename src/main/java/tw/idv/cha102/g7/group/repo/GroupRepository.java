package tw.idv.cha102.g7.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.cha102.g7.group.dto.GroupGroupPicDto;
import tw.idv.cha102.g7.group.dto.GroupRegFormDto;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.entity.GroupPicture;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findByMemIdOrderByGroupStaDesc(Integer memId); //揪團主的尋找揪團
//    List<Group> findGroupsByMemId(Integer memId);
    List<Group> findByThemeContaining(String keyword);

    List<Group> findGroupByGroupSta(Integer groupSta);

    List<Group> findGroupByPaymentSta(Integer paymentSta);

    @Query(value = "select g.theme, r.phone FROM `group` as g left join reg_form as r on g.group_id = r.group_id where g.group_id = ?1 Order by r.mem_id desc", nativeQuery = true)
    List<GroupRegFormDto> findGroupRegFormDtoByGroupId(Integer groupId);

    @Query(value = "Select g.*, gp.group_pic_id, gp.group_pic FROM `group` AS g LEFT JOIN group_picture AS gp ON g.group_id = gp.group_id " +
            "WHERE g.group_id = ?1 ORDER BY gp.group_pic_id", nativeQuery = true)
    List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(Integer groupId);
}
