package tw.idv.cha102.g7.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.shop.entity.Product;
import tw.idv.cha102.g7.shop.service.ProductService;

//介面層:負責接收前端請求，請業務邏輯層(Service)處理，再回傳資料給前端;也可以是View層，渲染使用者畫面
//表示這個類別是一個 REST 風格的控制器，會處理 HTTP 請求並返回 JSON 格式的數據
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired  // 注入productService，取得service層的物件
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product/add")    //用PostMapping標註接收HTTP請求，並對應到insert方法，
    public Product insert(@RequestBody Product product){
        return productService.insert(product);
    }

//    @PutMapping("/product/update/{prodId}")
//    public Product update(@PathVariable("prodId") Integer prodId){
//        Product existingProduct = productService.getOneById(prodId);
//        if(existingProduct != null){
//            product.setProdId(prodId);
//            productService.update(product);
//        }
//        return product;
//    }
}





