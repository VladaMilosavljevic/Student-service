package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;


public interface StudentService {
	List<StudentDto> findAll();

	void deleteById(int id);

	StudentDto save(StudentEntity studentEntity) throws ExistEntityException;

	Optional<StudentDto> findById(int id);
	
	StudentDto update (StudentDto dto) throws EntityNotPresent;
	
	Page<StudentDto> findByPage(Pageable pageable);
}
