package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vladimir.milosavljevic.dao.CityDao;
import vladimir.milosavljevic.dao.StudentDao;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.StudentMapper;
import vladimir.milosavljevic.service.CityService;
import vladimir.milosavljevic.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private  StudentMapper studentMapper;

	@Override
	public List<StudentDto> findAll() {
		List<StudentEntity> entities =  (List)studentDao.findAll();

		return entities.stream().map(entity -> {
			return studentMapper.toStudentDto(entity);
		}).collect(Collectors.toList());

	}

	@Override
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public StudentDto save(StudentEntity studentEntity) throws ExistEntityException {
		studentEntity = studentDao.save(studentEntity);
		return studentMapper.toStudentDto(studentEntity);

	}

	@Override
	public Optional<StudentDto> findById(int id) {
		Optional<StudentEntity> student = studentDao.findById(id);
		if (student.isPresent()) {
			return Optional.of(studentMapper.toStudentDto(student.get()));
		}
		return Optional.empty();
	}

	@Override
	public StudentDto update(StudentDto dto) throws EntityNotPresent {
		Optional<StudentEntity> entity = studentDao.findById(dto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(dto.getId(), "student does not exist!");
		}
		StudentEntity s = studentDao.save(studentMapper.toStudentEntity(dto));
		return studentMapper.toStudentDto(s);

	}

	@Override
	public Page<StudentDto> findByPage(Pageable pageable) {
		
		Page<StudentDto> entites = studentDao.findAll(pageable).map(studentMapper::toStudentDto);
		return entites;
	}

}
