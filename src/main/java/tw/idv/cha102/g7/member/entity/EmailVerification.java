package tw.idv.cha102.g7.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="members")
public class EmailVerification {

    @Id
    @Column(name = "mem_id")
    private Integer memId;

    private String usermail;


}
