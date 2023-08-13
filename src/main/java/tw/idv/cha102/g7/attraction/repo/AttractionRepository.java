package tw.idv.cha102.g7.attraction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.attraction.entity.Attraction;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {


}
