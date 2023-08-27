package tw.idv.cha102.g7.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.cha102.g7.schedule.entity.ScheduleDetail;
import tw.idv.cha102.g7.schedule.service.ScheduleDetailService;
import tw.idv.cha102.g7.schedule.service.ScheduleService;
import tw.idv.cha102.g7.schedule.service.ScheduleTagService;

import java.util.List;

// 查看行程詳情
@RestController
@RequestMapping("/schedules/details")
public class ScheduleDetailController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleDetailService detailService;

    @Autowired
    private ScheduleTagService tagService;


    // 顯示單一行程詳細資訊(包含行程、行程細節及標籤)
    @GetMapping("/{schId}")
    public List<ScheduleDetail> findScheduleDetails(@PathVariable Integer schId){
        return detailService.findBySchId(schId);
    }

    // 見ScheduleManageController.java
    // 查詢單一行程詳細資訊(包含行程、 行程標籤、行程細節)後，對行程內容進行修改(增、刪、改、查)
    // 修改行程公開權限(私密、透過連結分享、公開)
    // 行程共同編輯成員及權限設定(可檢視、可編輯、新增及移除共編成員，透過連結分享邀請成員共編)
    // 行程細節排序要能夠依照起始時間排序
    // 新增行程天數或是移動行程天數時，要能夠調整對應行程日期
    // 行程細節中起始時間、停留時間及交通方式變動時，時間要能夠重新調整、排序
    // 行程細節時間對應到景點營業時間，要能夠標示出營業狀態(營業中、有可能錯過營業時間、結束營業時間等)
    // 要能搜尋、新增自訂私人景點、看到景點收藏
    // 複製行程細節時，向下插入複製的行程細節後，調整行程細節排序
    // 存檔行程詳細資訊

}
