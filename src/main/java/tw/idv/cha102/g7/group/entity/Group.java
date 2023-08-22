package tw.idv.cha102.g7.group.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "`group`")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {
    private static final long serialVersionUID = 2072014924350494700L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql的主鍵也需要設置自增
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "mem_id")
    private Integer memId;
    @Column(name = "sch_id")
    private Integer schId;
    @Column(name = "members")
    private Integer members;
    @Column(name = "min_member")
    private Integer minMember;
    @Column(name = "max_member")
    private Integer maxMember;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "theme")
    private String theme;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_date")
    private Timestamp startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "dep_date")
    private Timestamp depDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "group_desc")
    private String groupDesc;
    @Column(name = "notice")
    private String notice;
    @Column(name = "group_sta")
    private Integer groupSta;
    @Column(name = "payment_sta")
    private Integer paymentSta;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "group")
//    @JsonManagedReference
//    private List<GroupPicture> groupPictureList;
}
