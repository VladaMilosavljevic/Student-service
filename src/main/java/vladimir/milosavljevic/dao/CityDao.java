package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



import vladimir.milosavljevic.entity.CityEntity;


@Repository
public interface CityDao  extends PagingAndSortingRepository<CityEntity, Integer>{

	CityEntity findCityById(Integer idCity);
}
