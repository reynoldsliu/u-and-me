package tw.idv.cha102.g7.group.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface GroupListDto {
    byte[] getCover();

    String getTheme();

    Integer getAmount();

    Integer getM();

    @JsonFormat()
    BigInteger getD();

//    Integer getGroup_Sta();
}
