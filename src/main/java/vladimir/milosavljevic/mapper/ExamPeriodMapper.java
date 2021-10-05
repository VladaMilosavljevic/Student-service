package vladimir.milosavljevic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.entity.ExamPeriodEntity;


public interface ExamPeriodMapper {
		

	ExamPeriodDto toExamPeriodDto(ExamPeriodEntity examPeriodEntity);	
	ExamPeriodEntity toExamPeriodEntity(ExamPeriodDto examPeriodDto);	
	List<ExamPeriodDto>toExamPeriodDtos(List<ExamPeriodEntity>examPeriods);
	List<ExamPeriodEntity>toExamPeriodEntitys(List<ExamPeriodDto>examPeriodDtos);
}
