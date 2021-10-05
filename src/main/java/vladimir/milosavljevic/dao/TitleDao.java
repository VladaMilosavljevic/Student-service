package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.TitleEntity;
import vladimir.milosavljevic.exception.ExistEntityException;

@Repository
public interface TitleDao extends PagingAndSortingRepository<TitleEntity, Integer> {
	TitleEntity findTitleById(Integer idTitle) throws ExistEntityException;
}
