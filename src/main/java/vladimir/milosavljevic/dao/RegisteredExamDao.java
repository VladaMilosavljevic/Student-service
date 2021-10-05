package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.RegisteredExamEntity;

@Repository
public interface RegisteredExamDao extends JpaRepository<RegisteredExamEntity, Integer> {

}
