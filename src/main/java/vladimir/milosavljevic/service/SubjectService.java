package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;


public interface SubjectService {

	
	List<SubjectDto> findAll();

	void deleteById(int id);

	SubjectDto save(SubjectEntity subjectEntity) throws ExistEntityException;

	Optional<SubjectDto> findById(int id);
	
	SubjectDto update (SubjectDto dto) throws EntityNotPresent;

	Page<SubjectDto> findByPage(Pageable pageable);
}
