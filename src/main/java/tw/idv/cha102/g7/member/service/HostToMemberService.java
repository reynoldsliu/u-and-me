package tw.idv.cha102.g7.member.service;

import tw.idv.cha102.g7.member.entity.Member;

public interface HostToMemberService {

    //////會員管理///////


    //會員權限管理(檢舉)

    public String setMemberStatus(String memEmail, Integer sta);

    //會員資料查詢
    public Member getMemberByEmail(String memEmail);

    //會員團主認證
    public String setMemberGroupSta(String memEmail, Integer groupSta);

    //會員通知發佈

    //會員點數管理

    //會員等級管理

}
