package tw.idv.cha102.g7.group.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.group.dto.*;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.repo.GroupRepository;
import tw.idv.cha102.g7.group.service.GroupService;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public void insert(Group group) {
        groupRepository.save(group);
    }

    public void update(Integer groupId, Group group) {
        var existGroup = groupRepository.findById(groupId);
        if (existGroup.isPresent()) {
            existGroup.get().setGroupId(groupId);
            groupRepository.save(existGroup.get());
        }
    }

    @Override
    public void updateMyGroupByGroupId(Integer groupId, Group group) {
        var existGroup = groupRepository.findById(groupId);
        if (existGroup.isPresent()) {
            //以實際前端傳送情況更新
            existGroup.get().setMinMember(group.getMinMember());
            existGroup.get().setMaxMember(group.getMaxMember());
            existGroup.get().setTheme(group.getTheme());
            existGroup.get().setDepDate(group.getDepDate());
            existGroup.get().setDeadline(group.getDeadline());
            existGroup.get().setGroupDesc(group.getGroupDesc());
            existGroup.get().setNotice(group.getNotice());
            existGroup.get().setCover(group.getCover());
            groupRepository.save(existGroup.get());
        }
    }

    public void delete(Integer groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group getGroupByGroupId(Integer groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public List<Group> getAllPaged(int page, int size) {
        Page<Group> pageResult = groupRepository.findAll(
                PageRequest.of(page, //查詢的頁數 從0開始
                        size,//查詢的每頁筆數
                        Sort.by("startDate").ascending())); //依造start_Date欄位升冪排序
//        可能會運用到的方法
//        pageResult.getNumberOfElements(); //本頁筆數
//        pageResult.getSize(); //每頁筆數
//        pageResult.getTotalElements(); //全部筆數
//        pageResult.getTotalPages(); //全部頁數

        List<Group> groupList = pageResult.getContent();
        return groupList;
    }

    @Override
    public List<Group> findByMemIdOrderByGroupStaDesc(Integer memId) {
        return groupRepository.findByMemIdOrderByGroupStaDesc(memId);
    }
//    public List<Group> getGroupsByMemId(Integer memId){
//        return groupRepository.findGroupsByMemId(memId);
//    }

    @Override
    public List<Group> findByThemeContaining(String keyword) {
        return groupRepository.findByThemeContaining(keyword);
    }

    @Override
    public List<Group> findGroupByGroupSta(Integer groupSta) {
        return groupRepository.findGroupByGroupSta(groupSta);
    }

    @Override
    public List<Group> findGroupByPaymentSta(Integer paymentSta) {
        return groupRepository.findGroupByPaymentSta(paymentSta);
    }

    @Override
    public List<GroupRegFormDto> findGroupRegFormDtoByGroupId(Integer groupId) {
        return groupRepository.findGroupRegFormDtoByGroupId(groupId);
    }

    @Override
    public List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(Integer groupId) {
        return groupRepository.findGroupRegFormDtoByGroupIdOrderByGroupPicId(groupId);
    }

    @Override
    public Stream<GroupListDto> findGroupListByGroupSta(Integer groupSta, Integer page) {

        Sort sort = Sort.by(Sort.Direction.ASC, "start_Date");  //定義Sort ASC為升冪排序，通過揪團狀態排序 start_Date 是MySQL的欄位名

        //測試想法
//        if(sortType != null){
//            switch (sortType.getType()){
//                case 1:
//                    sort = Sort.by(Sort.Direction.ASC, "deadline");
//                    break;
//                case 2:
//                    sort = Sort.by(Sort.Direction.DESC, "deadline");
//                    break;
//                case 3:
//                    break;
//            }
//        }

        Pageable pageable = PageRequest.of(page, 6, sort);   //定義Pageable(page 當前頁數, size 傳入資料筆數, sort 排序方法)
        BigInteger zero = new BigInteger("0");  //比較BigInteger所以要用BigInteger互相比較

        //以下判斷取出的揪團狀態
        List<Group> groups = groupRepository.findGroupByGroupSta(0); //找出揪團狀態為0的列表
        for (Group group : groups) {

            //參團人數到最大人數
            if (group.getMembers() == group.getMaxMember()) {
                group.setGroupSta(1); //設置成團狀態
                groupRepository.save(group);
            }

            //揪團時間截止做的判斷
            Date date = group.getDeadline(); //轉換java.sql.TimeStamp 至 java.util.Date
            if (date.compareTo(new Date()) < 0) {
                if (group.getMembers() > group.getMinMember()) {
                    group.setGroupSta(1); //設置成團狀態
                    groupRepository.save(group);
                } else {
                    group.setGroupSta(2); //設置揪團取消狀態
                    groupRepository.save(group);
                }
            }
        }
        //問題 Stream.filter()後的列表是亂的(結果:因為pageable size一次傳入固定比數， 呼叫分頁時才會再給下一頁的值，所以才會挖空)
        return groupRepository.findGroupListByGroupSta(groupSta, pageable).get(); //返回值為Stream<T>
    }

    @Override
    public Stream<MyGroupListDto> findMyGroupListDtoByMemId(Integer memId, Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "Group_Sta");
        Pageable pageable = PageRequest.of(page, 6, sort);
        return groupRepository.findMyGroupListDtoByMemId(memId, pageable).get();
    }

    @Override
    public UpdateMyGroupDto findUpdateMyGroupByGroupId(Integer groupId) {
        return groupRepository.findUpdateMyGroupByGroupId(groupId);
    }

    @Override
    public Stream<GroupListDto> findGroupByGroupStaOrderByDeadline(Integer groupSta, Integer page) {
        Pageable pageable = PageRequest.of(page, 6);
        return groupRepository.findGroupByGroupStaOrderByDeadline(groupSta, pageable).get();
    }

    @Override
    public Stream<GroupListDto> findGroupByGroupStaOrderByDeadlineDesc(Integer groupSta, Integer page) {
        Pageable pageable = PageRequest.of(page, 6);
        return groupRepository.findGroupByGroupStaOrderByDeadlineDesc(groupSta, pageable).get();
    }

    @Override
    public Stream<GroupListDto> findGroupByGroupStaOrderByAmount(Integer groupSta, Integer page) {
        Pageable pageable = PageRequest.of(page, 6);
        return groupRepository.findGroupByGroupStaOrderByAmount(groupSta, pageable).get();
    }

    @Override
    public Stream<GroupListDto> findGroupByGroupStaOrderByAmountDesc(Integer groupSta, Integer page) {
        Pageable pageable = PageRequest.of(page, 6);
        return groupRepository.findGroupByGroupStaOrderByAmountDesc(groupSta, pageable).get();
    }

    @Override
    public Stream<GroupListDto> findGroupByGroupStaThemeLike(Integer groupSta, String str, Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "start_Date");
        Pageable pageable = PageRequest.of(page, 6, sort);
        return groupRepository.findGroupByGroupStaThemeLike(groupSta, str, pageable).get();
    }


}
