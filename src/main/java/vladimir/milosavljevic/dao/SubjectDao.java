package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.SubjectEntity;

@Repository
public interface SubjectDao extends PagingAndSortingRepository<SubjectEntity, Integer> {

	SubjectEntity findSubjectById(Integer id);
	
}
