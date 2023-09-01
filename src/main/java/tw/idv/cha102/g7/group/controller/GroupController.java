package tw.idv.cha102.g7.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.group.dto.*;
import tw.idv.cha102.g7.group.entity.Group;
import tw.idv.cha102.g7.group.service.GroupService;

import java.util.List;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class GroupController {

    @Autowired
    private GroupService groupService;


    /**
     * 揪團團主
     * 新增揪團
     * @param group 欲新增的揪團資訊
     */
    @PostMapping("/group")
    public void insert(@RequestBody Group group){
        groupService.insert(group);
    }

    /**
     * 管理員
     * 修改揪團狀態/支付尾款狀態
     *
     * 揪團團主
     * 修改成團最大最小人數、標題、價格、行程出發時間、揪團截止時間、揪團描述、行前通知
     *
     * @param groupId 揪團ID
     * @param group 修改後的揪團資訊
     */
    @PutMapping("/group/{groupId}")
    public void update(@PathVariable Integer groupId,
                       @RequestBody Group group){

        groupService.update(groupId, group);
    }

    /**
     * 管理員
     * 刪除揪團
     * @param groupId 揪團ID
     */
    @DeleteMapping("/group/{groupId}")
    public void delete(@PathVariable Integer groupId){
        groupService.delete(groupId);
    }

    /**
     * 管理員
     * 查詢指定的揪團編號
     * @param groupId
     * @return 返回查詢單一揪團結果
     */
    @GetMapping("/group/{groupId}")
    public Group getGroupByGroupId(@PathVariable Integer groupId){
        return groupService.getGroupByGroupId(groupId);
    }

    /**
     * 遊客/揪團團主/一般使用者
     * 查詢所有揪團並依分頁顯示
     * @param page 當前分頁 (從0開始)
     * @return 返回所有揪團列表
     */
    @GetMapping("/groups/all/{page}")
    public List<Group> getAllPaged(@PathVariable Integer page){
        return groupService.getAllPaged(page,5);
    }

    /**
     * 揪團團主
     * 查詢自己的揪團列表
     * @param memId 揪團團主ID
     * @return 揪團團主的揪團列表 以groupSta升冪排序
     */
    @GetMapping("/groups/findByMemId/{memId}")
    public List<Group> findByMemIdOrderByGroupStaDesc(@PathVariable Integer memId){
        return groupService.findByMemIdOrderByGroupStaDesc(memId);
    }

    /**
     * 遊客/揪團團主/一般使用者
     * 以揪團標題查詢揪團(暫時沒用)
     * @param keyword 欲查詢的名稱
     * @return 返回查詢結果
     */
    @GetMapping("/groups/searchTheme/{keyword}")
    public List<Group> findByThemeContaining(@PathVariable String keyword){
        return groupService.findByThemeContaining(keyword);
    }

    /**
     * 管理員
     * 查詢揪團狀態
     * @param groupSta 欲查詢的揪團狀態
     * 0: 未成團,
     * 1: 揪團成功,
     * 2: 揪團取消,
     * 3: 揪團延期,
     * 4: 揪團被下架
     * @return 查詢結果
     */
    @GetMapping("/groups/searchSta/{groupSta}")
    public List<Group> findGroupByGroupSta(@PathVariable Integer groupSta){
        return groupService.findGroupByGroupSta(groupSta);
    }

    /**
     * 管理員
     * 查詢揪團尾款狀態
     * @param paymentSta 揪團尾款支付狀態
     * 0: 未撥款,
     * 1: 可申請撥款,
     * 2: 待撥款,
     * 3: 撥款完成
     * @return 查詢結果
     */
    @GetMapping("/groups/searchPaySta/{paymentSta}")
    public List<Group> findGroupByPaymentSta(@PathVariable Integer paymentSta){
        return groupService.findGroupByPaymentSta(paymentSta);
    }

    /**
     * 測試用
     * @param groupId
     * @return
     */
    @GetMapping("/test1/{groupId}")
    List<GroupRegFormDto> findGroupRegFormDtoByGroupId(@PathVariable Integer groupId){
        return groupService.findGroupRegFormDtoByGroupId(groupId);
    }

    /**
     * 遊客/揪團團主/一般使用者
     * 揪團詳情頁面
     * @param groupId 揪團ID
     * @return 單筆揪團詳情資訊
     */
    @GetMapping("/groupDetail/{groupId}")
    List<GroupGroupPicDto> findGroupRegFormDtoByGroupIdOrderByGroupPicId(@PathVariable Integer groupId){
        return groupService.findGroupRegFormDtoByGroupIdOrderByGroupPicId(groupId);
    }

    /**
     * 遊客/揪團團主/一般使用者
     * 揪團列表
     * @param groupSta 揪團狀態
     * 0: 未成團,
     * 1: 揪團成功,
     * 2: 揪團取消,
     * 3: 揪團延期,
     * 4: 揪團被下架
     * @param page 分頁頁數
     * @return 揪團列表
     */
    @GetMapping("/groupList/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupListByGroupSta(@PathVariable Integer groupSta, @PathVariable Integer page){
        return groupService.findGroupListByGroupSta(groupSta, page);
    }

    /**
     * 揪團團主
     * 顯示揪團團主舉辦的揪團
     * @param memId 揪團團主的會員ID
     * @param page 目標顯示的頁數
     * @return 查詢結果
     */
    @GetMapping("/myGroupList/{memId}/{page}")
    public Stream<MyGroupListDto> findMyGroupListDtoByGroupId(@PathVariable Integer memId,
                                                              @PathVariable Integer page){
        return groupService.findMyGroupListDtoByMemId(memId, page);
    }

    /**
     * 揪團團主
     * 更新揪團時在更新頁面顯示揪團詳情
     * @param groupId 揪團ID
     * @return 查詢結果
     */
    @GetMapping("/myGroup/update/{groupId}")
    public UpdateMyGroupDto findUpdateMyGroupByGroupId(@PathVariable Integer groupId){
        return groupService.findUpdateMyGroupByGroupId(groupId);
    }

    /**
     * 揪團團主
     * 更新揪團
     * @param groupId 揪團ID
     * @param group 前端傳送來須修改的值
     */
    @PutMapping("/myGroup/update/{groupId}")
    public ResponseEntity<?> updateMyGroupByGroupId(@PathVariable Integer groupId,
                                                    @RequestBody Group group){
        try {
            groupService.updateMyGroupByGroupId(groupId, group);
            return ResponseEntity.ok("更新成功！");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body("更新失敗！");
        }
    }

    //揪團列表金額排序
    @GetMapping("/groupList/byDeadline/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupByGroupStaOrderByDeadline(@PathVariable Integer groupSta,
                                                               @PathVariable Integer page){
           return groupService.findGroupByGroupStaOrderByDeadline(groupSta, page);
    }

    //揪團列表金額排序
    @GetMapping("/groupList/byDeadlineDesc/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupByGroupStaOrderByDeadlineDesc(@PathVariable Integer groupSta,
                                                               @PathVariable Integer page){
            return groupService.findGroupByGroupStaOrderByDeadlineDesc(groupSta, page);
    }

    //揪團列表金額排序
    @GetMapping("/groupList/byAmount/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupByGroupStaOrderByAmount(@PathVariable Integer groupSta,
                                                                       @PathVariable Integer page){
        return groupService.findGroupByGroupStaOrderByAmount(groupSta, page);
    }

    //揪團列表金額排序
    @GetMapping("/groupList/byAmountDesc/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupByGroupStaOrderByAmountDesc(@PathVariable Integer groupSta,
                                                                       @PathVariable Integer page){
        return groupService.findGroupByGroupStaOrderByAmountDesc(groupSta, page);
    }

    @GetMapping("/groupList/name{str}/{groupSta}/{page}")
    public Stream<GroupListDto> findGroupByGroupStaThemeLike(@PathVariable Integer groupSta,
                                                           @PathVariable String str,
                                                           @PathVariable Integer page){
        return groupService.findGroupByGroupStaThemeLike(groupSta, str, page);
    }
}
