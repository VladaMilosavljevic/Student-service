package vladimir.milosavljevic.facade;

import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.exception.ExistEntityException;


public interface StudentFacade {

	StudentDto save(StudentDto studentDto,Integer idCity) throws ExistEntityException;
}
