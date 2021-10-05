package vladimir.milosavljevic.dao;

import org.aspectj.lang.JoinPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vladimir.milosavljevic.entity.ExamPeriodEntity;

@Repository
public interface ExamPeriodDao extends PagingAndSortingRepository<ExamPeriodEntity, Integer> {

	ExamPeriodEntity findExamPeriodById(int id);
}
