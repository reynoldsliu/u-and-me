package tw.idv.cha102.g7.activity.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @Column(name = "activ_id")
    private Integer activId;

    @Column(name = "activ_pic")
    private Byte[] activPic;

    @Column(name = "activ_name")
    private String activName;

    @Column(name = "activ_con")
    private String activCon;

    @Column(name = "activ_starttime")
    private Timestamp activStarttime;

    @Column(name = "activ_endtime")
    private Timestamp activEndtime;

    @Column(name = "activ_sta")
    private Byte activSta;

}
