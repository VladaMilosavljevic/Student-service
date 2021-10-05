package vladimir.milosavljevic.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ExamPeriodEntity;

@Component
public class ExamMapperImpl implements ExamMapper {

	private final SubjectMapper subjectMapper = Mappers.getMapper(SubjectMapper.class);
	@Autowired
	private ExamPeriodMapper examPeriodMapper;

	@Override
	public ExamDto toExamDto(ExamEntity examEntity) {
		ExamDto examDto = new ExamDto();
		examDto.setDateOfExam(examEntity.getDateOfExam());
		examDto.setId(examEntity.getId());
		examDto.setExamPeriod(examEntity.getExamPeriod());
		examDto.setSubject(examEntity.getSubjectEntity());
		return examDto;
	}

	@Override
	public ExamEntity toExamEntity(ExamDto examDto) {
		ExamEntity examEntity = new ExamEntity();
		examEntity.setDateOfExam(examDto.getDateOfExam());
		examEntity.setId(examDto.getId());
		examEntity.setExamPeriod(examDto.getExamPeriod());
		examEntity.setSubjectEntity(examDto.getSubject());
		;
		return examEntity;
	}

	@Override
	public List<ExamDto> toExamDtos(List<ExamEntity> examEntities) {

		List<ExamDto> examDtos = new ArrayList<ExamDto>();
		for (ExamEntity entity : examEntities) {
			ExamDto examDto = new ExamDto();
			examDto.setId(entity.getId());
			examDto.setDateOfExam(entity.getDateOfExam());
			examDto.setExamPeriod(entity.getExamPeriod());
			examDto.setSubject(entity.getSubjectEntity());
			// examDto.setExamPeriodDto(examPeriodMapper.toExamPeriodDto(entity.getExamPeriod()));
			// examDto.setSubjectDto(subjectMapper.toSubjectDto(entity.getSubjectEntity()));
			examDtos.add(examDto);
		}
		return examDtos;
	}

	@Override
	public List<ExamEntity> toexamEntities(List<ExamDto> examDtos) {

		List<ExamEntity> examEntities = new ArrayList<ExamEntity>();
		for (ExamDto examDto : examDtos) {
			ExamEntity examEntity = new ExamEntity();
			examEntity.setDateOfExam(examDto.getDateOfExam());
			examEntity.setId(examDto.getId());
			examEntity.setExamPeriod(examDto.getExamPeriod());
			examEntity.setSubjectEntity(examDto.getSubject());
			;
			// examEntity.setExamPeriod(examPeriodMapper.toExamPeriodEntity(examDto.getExamPeriodDto()));
			// examEntity.setSubjectEntity(subjectMapper.toSubjectEntity(examDto.getSubjectDto()));
			examEntities.add(examEntity);

		}
		return examEntities;

	}
}
