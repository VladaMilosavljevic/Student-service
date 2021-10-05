package vladimir.milosavljevic.facade;

import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface SubjectFacade {

	
	SubjectDto save(SubjectDto subjectDto,Integer idProfessor) throws ExistEntityException;
}
