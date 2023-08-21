package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attraction_collections")
public class AttrCollectionDTO {

    @EmbeddedId
    private AttrCollectionId collectionId;

    @Column(name = "attr_col_illa")
    private String attrColIlla;

    public AttrCollectionDTO() {
    }

    public AttrCollectionDTO(AttrCollectionId collectionId, String attrColIlla) {
        this.collectionId = collectionId;
        this.attrColIlla = attrColIlla;
    }
}
