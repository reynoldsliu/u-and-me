package tw.idv.cha102.g7.member.service;

import tw.idv.cha102.g7.member.entity.Host;

public interface HostService {

    public void insert(Host host);
    public void deleteById(Integer hostId);
    public Boolean login(Integer hostId,String hostPassword);
    public Host update(Host host);

    }

