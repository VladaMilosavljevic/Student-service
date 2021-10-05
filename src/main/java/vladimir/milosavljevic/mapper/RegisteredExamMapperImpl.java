package vladimir.milosavljevic.mapper;

import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.entity.RegisteredExamEntity;

@Component
public class RegisteredExamMapperImpl implements RegisteredExamMapper {

	@Override
	public RegisteredExamDto toRegisteredExamDto(RegisteredExamEntity registeredExamEntity) {

		RegisteredExamDto registeredExamDto = new RegisteredExamDto();
		registeredExamDto.setId(registeredExamEntity.getId());
		registeredExamDto.setRegisteredExamDate(registeredExamEntity.getRegisteredExamDate());
		registeredExamDto.setExam(registeredExamEntity.getExam());
		registeredExamDto.setStudent(registeredExamEntity.getStudent());
		return registeredExamDto;

	}

	@Override
	public RegisteredExamEntity toRegisteredExamEntity(RegisteredExamDto registeredExamDto) {
		RegisteredExamEntity registeredExamEntity = new RegisteredExamEntity();
		registeredExamEntity.setId(registeredExamDto.getId());
		registeredExamEntity.setRegisteredExamDate(registeredExamDto.getRegisteredExamDate());
		registeredExamEntity.setExam(registeredExamDto.getExam());
		registeredExamEntity.setStudent(registeredExamDto.getStudent());
		return registeredExamEntity;
	}

}
