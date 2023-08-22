package tw.idv.cha102.g7.group.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public interface GroupGroupPicDto {

    Integer getGroup_Id();
    Integer getMem_Id();

    Integer getSch_Id();

    Integer getMembers();

    Integer getMin_Member();

    Integer getMax_Member();

    Integer getAmount();

    String getTheme();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp getStar_Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp getDep_Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp getDeadline();

    String getGroup_Desc();

    String getNotice();

    Integer getGroup_Sta();

    Integer getPayment_Sta();

    Integer getGroup_Pic_Id();

    byte[] getGroup_Pic();


}
