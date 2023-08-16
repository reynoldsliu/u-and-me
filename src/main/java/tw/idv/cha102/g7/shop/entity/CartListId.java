package tw.idv.cha102.g7.shop.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartListId implements Serializable {

    private Integer memberId;
    private Integer prodId;

    public CartListId() {}

    public CartListId(Integer memberId, Integer prodId) {
        this.memberId = memberId;
        this.prodId = prodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartListId that = (CartListId) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(prodId, that.prodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, prodId);
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
}
