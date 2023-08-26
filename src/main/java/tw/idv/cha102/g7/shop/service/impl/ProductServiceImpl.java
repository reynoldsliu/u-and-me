package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.shop.dto.ProductDTO;
import tw.idv.cha102.g7.shop.entity.Product;
import tw.idv.cha102.g7.shop.entity.ProductPicture;
import tw.idv.cha102.g7.shop.repo.ProductPictureRepository;
import tw.idv.cha102.g7.shop.repo.ProductRepository;
import tw.idv.cha102.g7.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

//業務邏輯層，被呼叫，根據請求做資料處理&處理從DAO/Repo回來的資料
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;  //取得ProductRepository物件，productRepository變數名稱也是自定義

    @Autowired
    private ProductPictureRepository productPictureRepository;

    //從Spring容器找出物件注入給該屬性:當容器初始化時會自動將ProductRepository注入於該建構子中
    //類別的建構子，用於初始化 ProductServiceImpl物件，並設定其依賴的ProductRepository物件

    //    把insert進來的物件用productRepository的save方法存在product中
    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    // 刪除單筆商品
    @Override
    public void deleteProductById(Integer prodId) {
        productRepository.deleteById(prodId);
    }

    @Override
    public void updateProduct(Integer prodId, ProductDTO productDTO) {

        Product product = new Product();
        product.setProdId(productDTO.getProdId());
        product.setProdCatId(productDTO.getProdCatId());
        product.setProdName(productDTO.getProdName());
        product.setProdCon(productDTO.getProdCon());
        product.setProdPri(productDTO.getProdPri());
        product.setProdSta(productDTO.getProdSta());
        productRepository.save(product);


        List<ProductPicture> pplist = productDTO.getProductPictures();

        for (ProductPicture pp : pplist) {
            productPictureRepository.save(pp);
        }
        //
        //
        //


    }

    @Override
    public ProductDTO getProductById(Integer prodId) {
        Product product = productRepository.findById(prodId).orElse(null);
        List<ProductPicture> pplist = productPictureRepository.findByProdId(prodId);

        ProductDTO dto = new ProductDTO();
        dto.setProdId(product.getProdId());
        dto.setProdCatId(product.getProdCatId());
        dto.setProdName(product.getProdName());
        dto.setProdCon(product.getProdCon());
        dto.setProdPri(product.getProdPri());
        dto.setProdSta(product.getProdSta());
        dto.setProductPictures(pplist);

        return dto;
    }

    @Override
    public List<ProductDTO> listAll() {
        //找出全部商品
        List<Product> prodList = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        //找出全部照片並對應prodId
        List<ProductPicture> pp = new ArrayList<>();
        //從prodList裡面一個一個拿出放到product，再取得prodId，再從PPR裡找照片對應的prodId
        for (Product product : prodList) {
            Integer prodId = product.getProdId();
            pp = productPictureRepository.findByProdId(prodId);
            Integer prodCatId = product.getProdCatId();
            String prodName = product.getProdName();
            String prodCon = product.getProdCon();
            Integer prodPri = product.getProdPri();
            Short prodSta = product.getProdSta();

            //Object[]是ProductDTO的型態
            Object[] objects = {prodId, prodCatId, prodName, prodCon, prodPri, prodSta, pp};
            //productDTO代表每一列商品清單
            ProductDTO productDTO = new ProductDTO(objects);
            //把每一列商品清單放進productDTOS
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

}


//是否return是看自己定義，
//不return的話回傳值要寫void空值，要return 回傳值就是一個物件(Product...等)


