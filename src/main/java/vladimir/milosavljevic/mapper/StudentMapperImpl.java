package vladimir.milosavljevic.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.StudentEntity;

@Component
public class StudentMapperImpl implements StudentMapper {
	private final CityMapper cityMapper;

	@Autowired
	public StudentMapperImpl(CityMapper cityMapper) {
		super();
		this.cityMapper = cityMapper;
	}

	@Override
	public StudentDto toStudentDto(StudentEntity student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setCurrentYearOfStudy(student.getCurrentYearOfStudy());
		studentDto.setEmail(student.getEmail());
		studentDto.setIndexNumber(student.getIndexNumber());
		studentDto.setIndexYear(student.getIndexYear());
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		studentDto.setAddress(student.getAddress());
		// studentDto.setCityDto(cityMapper.toCityDto(student.getCity()));
		studentDto.setCity(student.getCity());
		return studentDto;
	}

	@Override
	public StudentEntity toStudentEntity(StudentDto studentDto) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(studentDto.getId());
		studentEntity.setCurrentYearOfStudy(studentDto.getCurrentYearOfStudy());
		studentEntity.setIndexNumber(studentDto.getIndexNumber());
		studentEntity.setIndexYear(studentDto.getIndexYear());
		studentEntity.setFirstName(studentDto.getFirstName());
		studentEntity.setLastName(studentDto.getLastName());
		studentEntity.setEmail(studentDto.getEmail());
		studentEntity.setAddress(studentDto.getAddress());
		studentEntity.setCity(studentDto.getCity());

		return studentEntity;
	}

}
