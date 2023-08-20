package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attraction_collections")
public class CollectionDTO {

    @EmbeddedId
    private CollectionId collectionId;

    @Column(name = "attr_col_illa")
    private String attrColIlla;

    public CollectionDTO() {
    }

    public CollectionDTO(CollectionId collectionId, String attrColIlla) {
        this.collectionId = collectionId;
        this.attrColIlla = attrColIlla;
    }
}
