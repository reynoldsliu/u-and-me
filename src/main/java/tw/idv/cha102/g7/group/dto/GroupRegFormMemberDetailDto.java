package tw.idv.cha102.g7.group.dto;

import java.sql.Date;

public interface GroupRegFormMemberDetailDto {
    Integer getGroup_Id();

    Integer getDetailId();

    Integer getFormId();

    String getName();

    String getCitizenship();

    String getIdnumber();

    Date getBirthday();

    String getGender();

    Integer getRefundSta();

}
