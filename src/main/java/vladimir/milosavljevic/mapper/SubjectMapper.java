package vladimir.milosavljevic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.entity.SubjectEntity;


public interface SubjectMapper {

	
	SubjectDto toSubjectDto(SubjectEntity subjectEntity);

	
	SubjectEntity toSubjectEntity(SubjectDto subjectDto);

}
