package tw.idv.cha102.g7.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.entity.Host;
import tw.idv.cha102.g7.member.repo.HostRepository;
import tw.idv.cha102.g7.member.service.HostService;


@Component
public class HostServiceImpl implements HostService {

    @Autowired
    private HostRepository hostRepository;
    public void insert(Host host){
        hostRepository.save(host);
    }

    @Override
    public void deleteById(Integer hostId){

        hostRepository.deleteById(hostId);
    }

    public Boolean login(Integer hostId,String hostPassword) {
        return hostRepository.findById(hostId).orElseThrow().getHostPassword().equals(hostPassword);


    }

    public Host update(Host host) {
        Host existingHost = hostRepository.findById(host.getHostId()).orElse(null);
        if (existingHost != null) {
            existingHost.setHostId(host.getHostId());
            existingHost.setHostEmail(host.getHostEmail());
            existingHost.setHostPassword(host.getHostPassword());


            return hostRepository.save(existingHost);
        }
        return null;
    }

}


