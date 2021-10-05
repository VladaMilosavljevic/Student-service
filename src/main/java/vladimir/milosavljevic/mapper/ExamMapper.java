package vladimir.milosavljevic.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ExamPeriodEntity;


public interface ExamMapper {

	ExamDto toExamDto(ExamEntity examEntity);	
	ExamEntity toExamEntity(ExamDto examDto);
	
	List<ExamDto>toExamDtos(List<ExamEntity>examEntities);
	List<ExamEntity>toexamEntities(List<ExamDto>examDtos);
	
	
	

}
