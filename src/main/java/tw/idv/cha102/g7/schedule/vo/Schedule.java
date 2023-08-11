package tw.idv.cha102.g7.schedule.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "schedules")
public class Schedule {
    @Id
    @Column(name = "sch_id")
    private Integer schId;

    @Column(name = "sch_name")
    private String schName;

    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "sch_start")
    private Date schStart;

    @Column(name = "sch_end")
    private Date schEnd;

    @Column(name = "sch_pub")
    private Integer schPub;

    @Column(name = "sch_copy")
    private Integer schCopy;

    @Column(name = "sch_cost")
    private Integer schCost;

    public Integer getSchId() {
        return schId;
    }

    public void setSchId(Integer schId) {
        this.schId = schId;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Date getSchStart() {
        return schStart;
    }

    public void setSchStart(Date schStart) {
        this.schStart = schStart;
    }

    public Date getSchEnd() {
        return schEnd;
    }

    public void setSchEnd(Date schEnd) {
        this.schEnd = schEnd;
    }

    public Integer getSchPub() {
        return schPub;
    }

    public void setSchPub(Integer schPub) {
        this.schPub = schPub;
    }

    public Integer getSchCopy() {
        return schCopy;
    }

    public void setSchCopy(Integer schCopy) {
        this.schCopy = schCopy;
    }

    public Integer getSchCost() {
        return schCost;
    }

    public void setSchCost(Integer schCost) {
        this.schCost = schCost;
    }
}
