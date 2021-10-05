package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface ExamService {

	List<ExamDto> findAll();

	void deleteById(int id);

	ExamDto save(ExamEntity examEntity) throws ExistEntityException;

	Optional<ExamDto> findById(int id);

	ExamDto update(ExamDto examDto) throws EntityNotPresent;
	
	Page<ExamDto> findByPage(Pageable pageable);
}
