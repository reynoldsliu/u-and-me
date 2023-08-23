package tw.idv.cha102.g7.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.member.entity.Host;
import tw.idv.cha102.g7.member.entity.Member;
import tw.idv.cha102.g7.member.repo.HostRepository;
import tw.idv.cha102.g7.member.service.HostService;

import java.util.Optional;


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

    public String login(String hostEmail, String hostPassword) {
        Optional <Host> optionalHost = hostRepository.findByhostEmail(hostEmail);
        if (optionalHost.isPresent()) {
            Host host = optionalHost.get();
            if (host.getHostPassword().equals(hostPassword)) {
                // 登入成功，檢查團主狀態

                    return "您已成功登入管理員系統";
                }

            }

        return "登入失敗";
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


