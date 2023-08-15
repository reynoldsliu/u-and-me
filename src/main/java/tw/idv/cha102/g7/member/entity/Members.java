package tw.idv.cha102.g7.member.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "mem_email")
    private String memEmail;

    @Column(name = "mem_password")
    private String memPassword;

    @Column(name = "mem_name")
    private String memName;

    @Column(name = "mem_gender")
    private Integer memGender;

    @Column(name = "mem_addr")
    private String memAddr;

    @Column(name = "mem_grade")
    private String memGrade;

    @Column(name = "mem_phone")
    private String memPhone;

    @Column(name = "mem_point")
    private Integer memPoint;

    @Column(name = "mem_sta")
    private Integer memSta;

    @Column(name = "mem_group")
    private Integer memGroup;
}

