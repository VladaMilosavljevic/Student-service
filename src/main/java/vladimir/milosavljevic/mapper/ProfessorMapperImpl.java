package vladimir.milosavljevic.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.entity.ProfessorEntity;

@Component
public class ProfessorMapperImpl implements ProfessorMapper {

	@Autowired
	private SubjectMapper mapper;
	
	@Override
	public ProfessorDto toProfessorDto(ProfessorEntity professor) {
		ProfessorDto professorDto = new ProfessorDto();
		professorDto.setId(professor.getId());
		professorDto.setAddress(professor.getAddress());
		professorDto.setEmail(professor.getEmail());
		professorDto.setLastName(professor.getLastName());
		professorDto.setPhone(professor.getPhone());
		professorDto.setReelectionDate(professor.getReelectionDate());
		professorDto.setFirstName(professor.getFirstName());
		professorDto.setCityEntity(professor.getCityId());
		professorDto.setTitle(professor.getTitleId());
		

		return professorDto;
	}

	@Override
	public ProfessorEntity toProfessorEntity(ProfessorDto professorDto) {
		ProfessorEntity professorEntity = new ProfessorEntity();
		professorEntity.setId(professorDto.getId());
		professorEntity.setAddress(professorDto.getAddress());
		professorEntity.setEmail(professorDto.getEmail());
		professorEntity.setFirstName(professorDto.getFirstName());
		professorEntity.setLastName(professorDto.getLastName());
		professorEntity.setPhone(professorDto.getPhone());
		professorEntity.setReelectionDate(professorDto.getReelectionDate());
		professorEntity.setCityId(professorDto.getCityEntity());
		professorEntity.setTitleId(professorDto.getTitle());
		return professorEntity;

	}

}
