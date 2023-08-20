package tw.idv.cha102.g7.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.cha102.g7.shop.entity.Product;
import tw.idv.cha102.g7.shop.repo.ProductRepository;
import tw.idv.cha102.g7.shop.service.ProductService;

import java.util.List;

@Service    //業務邏輯層，被呼叫，根據請求做資料處理&處理從DAO/Repo回來的資料
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;  //取得ProductRepository物件，productRepository變數名稱也是自定義

    @Autowired  //從Spring容器找出物件注入給該屬性:當容器初始化時會自動將ProductRepository注入於該建構子中
    //類別的建構子，用於初始化 ProductServiceImpl物件，並設定其依賴的ProductRepository物件
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insert(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

//    public Product getOneById(Integer prodId){
//        return productRepository.findById(prodId).orElse(null);
//    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    //刪除單筆商品
    @Override
    public void deleteProductById(Integer prodId) {
        productRepository.deleteById(prodId);
    }
}

//是否return是看自己定義，
//不return的話回傳值要寫void空值，要return 回傳值就是一個物件(Product...等)


