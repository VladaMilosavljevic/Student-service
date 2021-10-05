package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.entity.ProfessorEntity;

@Repository
public interface ProfessorDao extends PagingAndSortingRepository<ProfessorEntity, Integer> {

	
	ProfessorEntity findProfessorById(Integer id);
}
