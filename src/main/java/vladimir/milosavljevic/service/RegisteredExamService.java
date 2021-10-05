package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.entity.RegisteredExamEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface RegisteredExamService {

	List<RegisteredExamDto> findAll();

	void deleteById(int id);

	RegisteredExamDto save(RegisteredExamEntity registeredExamEntity) throws ExistEntityException;

	Optional<RegisteredExamDto> findById(int id);

	RegisteredExamDto update(RegisteredExamDto dto) throws EntityNotPresent;
}
