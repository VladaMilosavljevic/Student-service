package vladimir.milosavljevic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.StudentEntity;

public interface StudentMapper {

	StudentDto toStudentDto(StudentEntity student);

	StudentEntity toStudentEntity(StudentDto studentDto);

}
