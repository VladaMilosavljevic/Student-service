package vladimir.milosavljevic.facade;

import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface ExamFacade {

	
	ExamDto save(ExamDto examDto,Integer idSubject, Integer idExamPeriod) throws ExistEntityException, Exception;
}
