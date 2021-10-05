package vladimir.milosavljevic.facade;

import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.exception.ExistEntityException;


public interface RegisteredExamFacade {
	
	RegisteredExamDto save(RegisteredExamDto registeredExamDto,Integer idStudent,Integer idExam)throws ExistEntityException, Exception;

}
