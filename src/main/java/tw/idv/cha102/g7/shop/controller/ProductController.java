package tw.idv.cha102.g7.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tw.idv.cha102.g7.shop.dto.ProductDTO;
import tw.idv.cha102.g7.shop.entity.Product;
import tw.idv.cha102.g7.shop.entity.ProductPicture;
import tw.idv.cha102.g7.shop.service.ProductPictureService;
import tw.idv.cha102.g7.shop.service.ProductService;

import java.util.List;

//介面層:負責接收前端請求，請業務邏輯層(Service)處理，再回傳資料給前端;也可以是View層，渲染使用者畫面
//表示這個類別是一個 REST 風格的控制器，會處理 HTTP 請求並返回 JSON 格式的數據
@RestController
@RequestMapping("/product")
public class ProductController {
    // 注入Service，取得service層的物件
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductPictureService productPictureService;

//    因上面已定義有參數的建構子，Spring 就不會尋找一个無參的預設建構函式來實例化控制器類別
//    新增這個無參建構函式後，Spring 就能夠順利實例化 ProductController 類別。同時仍可保留你的自定義有參建構函式，以便在進行依賴注入時使用

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody ProductDTO productDTO) {
        //從前端拿到productPictureDTO內的參數內容

        //從productPictureDTO把拿到的值取出，再放進 new 出來的Product裡面
        Product newProduct = new Product();
        newProduct.setProdId(productDTO.getProdId());
        newProduct.setProdCatId(productDTO.getProdCatId());
        newProduct.setProdName(productDTO.getProdName());
        newProduct.setProdCon(productDTO.getProdCon());
        newProduct.setProdPri(productDTO.getProdPri());
        newProduct.setProdSta(productDTO.getProdSta());

        //用productService的insert方法，把新的物件newProduct insert進去
        productService.insert(newProduct);

        //從前端拿到的是一個ProductPicture的集合(因為DTO裡面是用集合表示)
        //因為service裡一次只能取一個，所以從List一個一個取出來
        //ProductPicture取出的元素型態 pp每個從裡面拿出的元素(他是一個完整的productpicture物件) : productPictures
        //用productPictureService的insert方法，把新的物件pp insert進去
        List<ProductPicture> productPictures = productDTO.getProductPictures();
        for (ProductPicture pp : productPictures) {
            productPictureService.insert(pp);
        }

    }

    @DeleteMapping("/deleteProduct/{prodId}")
    @Transactional  //確保在事務範圍內(方法內)運行
    public void deleteProduct(@PathVariable Integer prodId) {
        productPictureService.deleteProductPictureByProdId(prodId);
        productService.deleteProductById(prodId);
    }

    //ResponseEntity<> Spring Framework 提供的一个類別，控制控制器方法的回應內容，包括了回應的狀態碼、回應標頭以及回應主體內容
    //    (productDTO)接住商品修改後的資訊(前端傳回的JSON參數)
    @PutMapping("/updateProduct/{prodId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer prodId,
                                           @RequestBody ProductDTO productDTO) {
        productService.updateProduct(prodId, productDTO);

        //修改商品後就可用prodId去把更新的商品數據取回
        ProductDTO updatedProduct = productService.getProductById(prodId);

        //更新後的數據放在body裡傳回給前端
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);

    }

    @GetMapping("/listAllProduct")
    public List<ProductDTO> listAllProduct() {
        List<ProductDTO> productDTOList = productService.listAll();
        return productDTOList;
    }

}





