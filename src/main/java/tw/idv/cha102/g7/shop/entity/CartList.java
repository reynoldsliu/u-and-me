package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="cart_list")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name="mem_id")
    private Integer memberId;
    @Column(name="prod_id")
    private Integer prodId;
    @Column(name="cart_pri")
    private Integer cartPri ;
    @Column(name="cart_qty")
    private Integer cartQty;
}
