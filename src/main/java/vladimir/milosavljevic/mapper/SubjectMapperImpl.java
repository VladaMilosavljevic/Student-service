package vladimir.milosavljevic.mapper;

import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.entity.SubjectEntity;

@Component
public class SubjectMapperImpl implements SubjectMapper {

	@Override
	public SubjectDto toSubjectDto(SubjectEntity subjectEntity) {
		SubjectDto subjectDto = new SubjectDto();
		subjectDto.setId(subjectEntity.getId());
		subjectDto.setName(subjectEntity.getName());
		subjectDto.setNoOfESP(subjectEntity.getNoOfESP());
		subjectDto.setProfessor(subjectEntity.getProfessor());
		subjectDto.setSemester(subjectEntity.getSemester());
		subjectDto.setYearOfStudy(subjectEntity.getYearOfStudy());
		return subjectDto;
	}

	@Override
	public SubjectEntity toSubjectEntity(SubjectDto subjectDto) {

		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setId(subjectDto.getId());
		subjectEntity.setName(subjectDto.getName());
		subjectEntity.setNoOfESP(subjectDto.getNoOfESP());
		subjectEntity.setSemester(subjectDto.getSemester());
		subjectEntity.setYearOfStudy(subjectDto.getYearOfStudy());
		subjectEntity.setProfessor(subjectDto.getProfessor());
		return subjectEntity;
	}

}
