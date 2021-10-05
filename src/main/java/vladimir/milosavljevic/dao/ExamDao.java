package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ProfessorEntity;

@Repository
public interface ExamDao extends PagingAndSortingRepository<ExamEntity, Integer> {

	ExamEntity findExamById(Integer id);
	
}
