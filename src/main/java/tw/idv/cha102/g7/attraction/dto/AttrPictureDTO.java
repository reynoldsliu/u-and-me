package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attraction_pictures")
public class AttrPictureDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attr_pic_id")
    private Integer attrPicId;
    @Column(name = "attr_id")
    private Integer attrId;
    @Column(name = "attr_pic_data")
    @Lob
    private String attrPicData;
}
