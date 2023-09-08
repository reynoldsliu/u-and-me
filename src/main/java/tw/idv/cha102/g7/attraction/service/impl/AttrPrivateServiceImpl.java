package tw.idv.cha102.g7.attraction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateDTO;
import tw.idv.cha102.g7.attraction.dto.AttrPrivateId;
import tw.idv.cha102.g7.attraction.entity.Attraction;
import tw.idv.cha102.g7.attraction.repo.AttrPrivateRepository;
import tw.idv.cha102.g7.attraction.repo.AttrRepository;
import tw.idv.cha102.g7.attraction.service.AttrPrivateService;
import tw.idv.cha102.g7.member.controller.MemberController;
import tw.idv.cha102.g7.member.entity.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttrPrivateServiceImpl implements AttrPrivateService {

    @Autowired
    private AttrPrivateRepository attrPrivateRepository;

    @Autowired
    private AttrRepository attrRepository;

    /**
     * 新增到景點資料庫
     * @param attraction
     * @return ResponseEntity<Attraction>
     */
    @Override
    public ResponseEntity<AttrPrivateDTO> addAndUpdatePrivateAttraction(
                                                        HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Attraction attraction){
        Attraction savedAttraction = attrRepository.save(attraction);
        AttrPrivateId attrPrivateId = new AttrPrivateId();
        attrPrivateId.setAttrId(savedAttraction.getAttrId());
        MemberController memberController = new MemberController();
        Member member = memberController.getMemId(request,response).getBody();
        attrPrivateId.setMemId(member.getMemId());

        AttrPrivateDTO attrPrivateDTO = new AttrPrivateDTO();
        attrPrivateDTO.setAttrPrivateId(attrPrivateId);

        return new ResponseEntity(attrPrivateRepository.save(attrPrivateDTO), HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<String> deletePrivateAttraction(HttpServletRequest request,
                                          HttpServletResponse response,
                                          Integer attrId){
        AttrPrivateId attrPrivateId = new AttrPrivateId();
        MemberController memberController = new MemberController();
        Member member = memberController.getMemId(request,response).getBody();
        attrPrivateId.setAttrId(attrId);
        attrPrivateId.setMemId(member.getMemId());

        try{
            attrPrivateRepository.deleteByAttrPrivateId(attrPrivateId);
            attrRepository.deleteById(attrId);
        }catch(Exception e){
            return new ResponseEntity("delete private attraction failed.",HttpStatus.OK);
        }
        return new ResponseEntity("delete private attraction success.",HttpStatus.OK);
    }

    @Override
    public AttrPrivateDTO getPrivateAttraction(AttrPrivateId attrPrivateId){
        return attrPrivateRepository.findByAttrPrivateId(attrPrivateId);
    }



}
