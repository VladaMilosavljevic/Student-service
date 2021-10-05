package vladimir.milosavljevic.facade;

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface ProfessorFacade {

	
	ProfessorDto save(ProfessorDto professorDto,Integer idCity,Integer idTitle) throws ExistEntityException;
}
