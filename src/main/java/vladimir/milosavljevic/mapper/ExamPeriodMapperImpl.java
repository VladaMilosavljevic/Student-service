package vladimir.milosavljevic.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.entity.ExamPeriodEntity;

@Component
public class ExamPeriodMapperImpl implements ExamPeriodMapper {

	@Autowired
	private ExamMapper mapper;

	@Override
	public ExamPeriodDto toExamPeriodDto(ExamPeriodEntity examPeriodEntity) {
		ExamPeriodDto examPeriodDto = new ExamPeriodDto();
		examPeriodDto.setId(examPeriodEntity.getId());
		examPeriodDto.setName(examPeriodEntity.getName());
		examPeriodDto.setEnd_date(examPeriodEntity.getEndDate());
		examPeriodDto.setStart_date(examPeriodEntity.getStartDate());
		examPeriodDto.setExams(mapper.toExamDtos(examPeriodEntity.getExams()));
		return examPeriodDto;
	}

	@Override
	public ExamPeriodEntity toExamPeriodEntity(ExamPeriodDto examPeriodDto) {
		ExamPeriodEntity examPeriodEntity = new ExamPeriodEntity();
		examPeriodEntity.setEndDate(examPeriodDto.getEnd_date());
		examPeriodEntity.setName(examPeriodDto.getName());
		examPeriodEntity.setId(examPeriodDto.getId());
		examPeriodEntity.setStartDate(examPeriodDto.getStart_date());
		examPeriodEntity.setExams(mapper.toexamEntities(examPeriodDto.getExams()));
		return examPeriodEntity;
	}

	@Override
	public List<ExamPeriodDto> toExamPeriodDtos(List<ExamPeriodEntity> examPeriods) {
		List<ExamPeriodDto> examPeriodDtos = new ArrayList<ExamPeriodDto>();
		for (ExamPeriodEntity examPeriodEntity : examPeriods) {
			ExamPeriodDto examPeriodDto = new ExamPeriodDto();
			examPeriodDto.setId(examPeriodEntity.getId());
			examPeriodDto.setName(examPeriodEntity.getName());
			examPeriodDto.setEnd_date(examPeriodEntity.getEndDate());
			examPeriodDto.setStart_date(examPeriodEntity.getStartDate());
			examPeriodDto.setExams(mapper.toExamDtos(examPeriodEntity.getExams()));
			examPeriodDtos.add(examPeriodDto);
		}
		return examPeriodDtos;
	}

	@Override
	public List<ExamPeriodEntity> toExamPeriodEntitys(List<ExamPeriodDto> examPeriodDtos) {
		List<ExamPeriodEntity> examPeriods = new ArrayList<ExamPeriodEntity>();
		for (ExamPeriodDto examPeriodDto : examPeriodDtos) {
			ExamPeriodEntity examPeriodEntity = new ExamPeriodEntity();
			examPeriodEntity.setEndDate(examPeriodDto.getEnd_date());
			examPeriodEntity.setName(examPeriodDto.getName());
			examPeriodEntity.setId(examPeriodDto.getId());
			examPeriodEntity.setStartDate(examPeriodDto.getStart_date());
			examPeriodEntity.setExams(mapper.toexamEntities(examPeriodDto.getExams()));
			examPeriods.add(examPeriodEntity);
		}
		return examPeriods;

	}

}
