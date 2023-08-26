package tw.idv.cha102.g7.shop.service;

import tw.idv.cha102.g7.shop.dto.ProductDTO;
import tw.idv.cha102.g7.shop.entity.Product;

import java.util.List;


public interface ProductService {

    //新增商品
    public void insert(Product product);

    //刪除單筆商品
    public void deleteProductById(Integer prodId);

    //更新商品資訊
    //參數product 表示要更新的物件，返回Product物件，代表更新後的商品
    public void updateProduct(Integer prodId, ProductDTO productDTO);

    //查詢單個商品(不一定要)
    //根據Id查詢單個商品，參數prodId表示要查詢的商品Id，返回值是一個Product物件，代表查詢到的單個產品
    public ProductDTO getProductById(Integer prodId);

//    顯示商品列表，返回值是一個包含多個Product物件的列表
    public List<ProductDTO> listAll();




    //使用者業務
    /*
     * 搜尋商品byNAME 模糊比對%name% (1-多筆)
     * */
//    public List<Product> findProductByNameContaining(Integer prodName);


    /*
     * 搜尋商品by類別 (1-多筆)
     * */
//    public List<Product> findProductByCat(Integer prodCat);

    /*
     * 顯示商品詳情 GetAllProductDetail
     * */
//    public List<Product> getAllProductDetail();



}

