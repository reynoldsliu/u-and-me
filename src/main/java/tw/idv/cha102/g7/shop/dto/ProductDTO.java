package tw.idv.cha102.g7.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.idv.cha102.g7.shop.entity.Product;
import tw.idv.cha102.g7.shop.entity.ProductPicture;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer prodId;
    private Integer prodCatId;
    private String prodName;
    private String prodCon;
    private Integer prodPri;
    private Short prodSta;

//    private Product product;

    private List<ProductPicture> productPictures;

    public ProductDTO(Object[] objects) {
        this.prodId = (Integer) objects[0];
        this.prodCatId = (Integer) objects[1];
        this.prodName = (String) objects[2];
        this.prodCon = (String) objects[3];
        this.prodPri = (Integer) objects[4];
        this.prodSta = (Short) objects[5];
        this.productPictures = (List<ProductPicture>) objects[6];
    }
}
