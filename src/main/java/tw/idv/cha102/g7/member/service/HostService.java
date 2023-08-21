package tw.idv.cha102.g7.member.service;

import tw.idv.cha102.g7.member.entity.Host;

public interface HostService {


//管理員資料管理
//管理員權限管理
//////會員管理///////
//會員權限管理(檢舉)
//會員資料查詢
//會員通知發佈
//會員點數管理
    //管理員註冊
    public void insert(Host host);
    //管理員帳號刪除
    public void deleteById(Integer hostId);
    public Boolean login(Integer hostId,String hostPassword);
    public Host update(Host host);

    }

