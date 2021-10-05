package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface ProfessorService {

	
	
	List<ProfessorDto> findAll();

	void deleteById(int id);

	ProfessorDto save(ProfessorEntity professorEntity) throws ExistEntityException;

	Optional<ProfessorDto> findById(int id);
	
	ProfessorDto update (ProfessorDto dto) throws EntityNotPresent;
	
	Page<ProfessorDto> findByPage(Pageable pageable);
}
