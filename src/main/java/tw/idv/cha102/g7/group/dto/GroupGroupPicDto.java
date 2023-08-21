package tw.idv.cha102.g7.group.dto;

import java.sql.Date;

public interface GroupGroupPicDto {

    Integer getGroupId();
    Integer getMemId();

    Integer getSchId();

    Integer getMembers();

    Integer getMinMember();

    Integer getMaxMember();

    Integer getAmount();

    String getTheme();

    Date getStarting();

    Date getDepDate();

    Date getDeadline();

    String getGroupDesc();

    String getNotice();

    Integer getGroupSta();

    Integer getPaymentSta();

    Integer getGroupPicId();

    Byte[] getGroupPic();


}
