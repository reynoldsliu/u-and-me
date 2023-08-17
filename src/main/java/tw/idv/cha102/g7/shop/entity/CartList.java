package tw.idv.cha102.g7.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartList {

    @EmbeddedId
    private CartListId id;

    @Column(name = "cart_price")
    private Integer cartPri;
    @Column(name = "cart_qty")
    private Integer cartQty;
}
