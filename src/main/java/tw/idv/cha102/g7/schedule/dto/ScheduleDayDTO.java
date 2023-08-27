package tw.idv.cha102.g7.schedule.dto;

import java.sql.Date;

public interface ScheduleDayDTO {

//    public Integer getSch_id();
//    public String getSch_name();
//    public Integer getMem_id();
//    public Date getSch_start();
//    public Date getSch_end();
//    public Byte getSch_pub();
//    public Boolean getSch_copy();
//    public Integer getSch_cost();
//    public Integer getDays();

    public Integer getSchId();

    public String getSchName();

    public Integer getMemId();

    public Date getSchStart();

    public Date getSchEnd();

    public Byte getSchPub();

    public Boolean getSchCopy();

    public Integer getSchCost();

    public Integer getDays();

}
