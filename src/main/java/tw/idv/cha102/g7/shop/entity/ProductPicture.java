package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_picture")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPicture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final long serialVersionUID = 1L;
    @Column(name="prodpic_id")
    private Integer prodPicId;
    @Column(name="prod_id")
    private Integer prodId;
    @Column(name="prod_pic")
    private Byte prodPic;

}
