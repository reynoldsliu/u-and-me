package tw.idv.cha102.g7.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.shop.entity.Product;

//資料訪問層:對資料庫做增刪改查等操作<自定義的類別,PK的型別>
public interface ProductRepository extends JpaRepository<Product, Integer> {



}
