package tw.idv.cha102.g7.customer.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qa")
public class CustomerQa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qa_id")
    private Integer qaId;

    @Column(name = "qa_title")
    private String qaTitle;

    @Column(name = "qa_con")
    private String qaCon;

    @Column(name = "qa_state")
    private Integer qaState;

}
