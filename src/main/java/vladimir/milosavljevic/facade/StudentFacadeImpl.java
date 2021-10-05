package vladimir.milosavljevic.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.StudentMapper;
import vladimir.milosavljevic.service.CityService;
import vladimir.milosavljevic.service.StudentService;

@Component
public class StudentFacadeImpl implements StudentFacade {


	private StudentService studentService;
	
	
	
	private CityService cityService;


	@Autowired
	public StudentFacadeImpl(StudentService studentService, CityService cityService) {
		super();
		this.studentService = studentService;
		this.cityService = cityService;
	}

	@Override
	public StudentDto save(StudentDto studentDto, Integer idCity) throws ExistEntityException {
		CityEntity entity = getCity(idCity);
		StudentEntity student = new StudentEntity();
		student.setCurrentYearOfStudy(studentDto.getCurrentYearOfStudy());
		student.setEmail(studentDto.getEmail());
		student.setFirstName(studentDto.getFirstName());
		student.setIndexYear(studentDto.getIndexYear());
		student.setLastName(studentDto.getLastName());
		student.setIndexNumber(studentDto.getIndexNumber());
		student.setAddress(studentDto.getAddress());
		student.setCity(entity);
		StudentDto studentDtoSave = studentService.save(student);

		return studentDtoSave;

	}

	private CityEntity getCity(Integer idCity) throws ExistEntityException {
		CityEntity cityEntity = cityService.findCityById(idCity);
		if (cityEntity == null) {
			throw new ExistEntityException(cityEntity, "city doesnt exist");
		}
		return cityEntity;

	}
}
