package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_picture")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPicture {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prodpic_id")
    private Integer prodPicId;

    @Column(name = "prod_id")
    private Integer prodId;

    @Lob
    @Column(name ="prod_pic")
    private Byte[] prodPic;


}
