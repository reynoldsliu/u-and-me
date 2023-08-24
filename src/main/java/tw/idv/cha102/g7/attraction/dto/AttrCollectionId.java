package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Data
@Embeddable
public class AttrCollectionId implements Serializable {

    @Column(name = "mem_id")
    private Integer memId;

    @Column(name = "attr_id")
    private Integer attrId;

//    public AttrCollectionId(){
//
//    }
//    public AttrCollectionId(Integer memId, Integer attrId) {
//        this.memId = memId;
//        this.attrId = attrId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AttrCollectionId that = (AttrCollectionId) o;
//        return Objects.equals(memId, that.memId) && Objects.equals(attrId, that.attrId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(memId, attrId);
//    }
}
