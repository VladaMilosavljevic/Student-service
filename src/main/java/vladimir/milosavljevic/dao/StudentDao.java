package vladimir.milosavljevic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.StudentEntity;

@Repository
public interface StudentDao extends PagingAndSortingRepository<StudentEntity, Integer> {

	StudentEntity findStudentById(Integer idStudent);

}
