package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.ExamPeriodEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface ExamPeriodService {

	List<ExamPeriodDto> findAll();

	void deleteById(int id);

	ExamPeriodDto save(ExamPeriodDto examPeriodDto) throws ExistEntityException;

	Optional<ExamPeriodDto> findById(int id);

	ExamPeriodDto update(ExamPeriodDto examPeriodDto) throws EntityNotPresent;
	
	
	Page<ExamPeriodDto> findByPage(Pageable pageable);
	
}
