package tw.idv.cha102.g7.schedule.entity;

import java.sql.Date;

public interface TestDTO {

    Integer getSchId();

    String getSchName();

    Integer getMemId();

    Date getSchStart();

    Date getSchEnd();

    Integer getSchPub();

    Integer getSchCopy();

    Integer getSchCost();

    Integer getSchTagId();

    String getSchTagName();

}
