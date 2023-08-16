package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Integer prodId;
    @Column(name = "prodcat_id")
    private Integer prodCatId;
    @Column(name = "prod_name")
    private String prodName;
    @Column(name = "prod_con")
    private String prodCon;
    @Column(name = "prod_pri")
    private Integer prodPri;
    @Column(name = "prod_qty")
    private Integer prodQTY;
    @Column(name = "prod_sta")
    private Short prodSta;
    @Column(name = "prod_spec")
    private String prodSpec;
}