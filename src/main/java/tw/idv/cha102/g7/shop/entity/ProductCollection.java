package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_collection")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCollection  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final long serialVersionUID = 1L;
    @Column(name="prod_id")
    private Integer prodId;
    @Column(name="mem_id")
    private Integer memId;
}
