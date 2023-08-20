package tw.idv.cha102.g7.attraction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.cha102.g7.attraction.dto.CollectionDTO;
import tw.idv.cha102.g7.attraction.dto.CollectionId;

import java.util.List;

public interface AttrCollectionRepository extends JpaRepository<CollectionDTO,CollectionId> {
    public List<CollectionDTO> findByCollectionId(CollectionId collectionId);

    public void deleteByCollectionId(CollectionId collectionId);

//    public List<CollectionDTO> findByMemId(Integer memId);


}
