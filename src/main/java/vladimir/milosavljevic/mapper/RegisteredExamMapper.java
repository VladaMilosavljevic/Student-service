package vladimir.milosavljevic.mapper;

import vladimir.milosavljevic.dto.RegisteredExamDto;

import vladimir.milosavljevic.entity.RegisteredExamEntity;

public interface RegisteredExamMapper {

	RegisteredExamDto toRegisteredExamDto(RegisteredExamEntity registeredExamEntity);

	RegisteredExamEntity toRegisteredExamEntity(RegisteredExamDto registeredExamDto);
}
