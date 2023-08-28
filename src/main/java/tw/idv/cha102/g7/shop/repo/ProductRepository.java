package tw.idv.cha102.g7.shop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import tw.idv.cha102.g7.shop.dto.ProductDTO;
import tw.idv.cha102.g7.shop.entity.Product;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//資料訪問層:對資料庫做增刪改查等操作<自定義的類別,PK的型別>
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
