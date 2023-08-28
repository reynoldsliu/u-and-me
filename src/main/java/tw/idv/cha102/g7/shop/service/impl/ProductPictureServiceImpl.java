package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.shop.entity.ProductPicture;
import tw.idv.cha102.g7.shop.repo.ProductPictureRepository;
import tw.idv.cha102.g7.shop.service.ProductPictureService;

@Service
public class ProductPictureServiceImpl implements ProductPictureService {

    @Autowired
    private ProductPictureRepository productPictureRepository;

    @Override
    public void insert(ProductPicture productPicture) {
        productPictureRepository.save(productPicture);
    }

    @Override
    public void deleteProductPictureByProdId(Integer prodId) {
        productPictureRepository.deleteByProdId(prodId);
    }


}
