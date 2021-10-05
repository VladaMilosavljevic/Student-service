package vladimir.milosavljevic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.entity.ProfessorEntity;

public interface ProfessorMapper {

	ProfessorDto toProfessorDto(ProfessorEntity professor);

	ProfessorEntity toProfessorEntity(ProfessorDto professorDto);
}
