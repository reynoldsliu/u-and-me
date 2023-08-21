package tw.idv.cha102.g7.group.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "member_detail")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetail implements Serializable {
    private static final long serialVersionUID = -7166790294423852111L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detailId;
    @Column(name = "form_id")
    private Integer formId;
    @Column(name = "`name`")
    private String name;
    @Column(name = "citizenship")
    private String citizenship;
    @Column(name = "idnumber")
    private String idnumber;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "gender")
    private String gender;
    @Column(name = "refund_sta")
    private Integer refundSta;

//    @ManyToOne
//    @JoinColumn(name = "form_id", insertable = false,updatable = false)
//    @JsonBackReference
//    private RegForm regForm;

}
