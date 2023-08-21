package tw.idv.cha102.g7.shop.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

public class OrderDetail {
    @Id
    @Column(name = "ord_id")
    private Integer ordId;

    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "prod_qty")
    private Integer prodQty;

    @Column(name = "prod_review")
    private String prodReview;

    @Column(name = "prod_price")
    private Integer prodPrice;

    @Column(name = "ord_com_score")
    private Double ordComScore;


}
