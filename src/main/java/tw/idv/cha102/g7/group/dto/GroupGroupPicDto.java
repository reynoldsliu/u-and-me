package tw.idv.cha102.g7.group.dto;

import java.sql.Date;

public interface GroupGroupPicDto {

    Integer getGroup_Id();
    Integer getMem_Id();

    Integer getSch_Id();

    Integer getMembers();

    Integer getMinMember();

    Integer getMaxMember();

    Integer getAmount();

    String getTheme();

    Date getStarting();

    Date getDep_Date();

    Date getDeadline();

    String getGroup_Desc();

    String getNotice();

    Integer getGroup_Sta();

    Integer getPayment_Sta();

    Integer getGroup_Pic_Id();

    Byte[] getGroup_Pic();


}
