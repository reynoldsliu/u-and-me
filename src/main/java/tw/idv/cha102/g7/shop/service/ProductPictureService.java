package tw.idv.cha102.g7.shop.service;

import tw.idv.cha102.g7.shop.entity.ProductPicture;

public interface ProductPictureService {


    void deleteProductPictureByProdId(Integer prodId);

    public void insert(ProductPicture productPicture);


}
