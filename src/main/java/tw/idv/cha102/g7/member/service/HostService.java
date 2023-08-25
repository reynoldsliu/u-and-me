package tw.idv.cha102.g7.member.service;

import tw.idv.cha102.g7.member.entity.Host;
import tw.idv.cha102.g7.member.entity.Member;

public interface HostService {


//管理員資料管理
//管理員權限管理

    //管理員註冊
    public String insert(Host host);
    //管理員帳號刪除
    public void deleteById(Integer hostId);
    public String login(String hostEmail,String hostPassword);
    public Host update(Host host);

    }

