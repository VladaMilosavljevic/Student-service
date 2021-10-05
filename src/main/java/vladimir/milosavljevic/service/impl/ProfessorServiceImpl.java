package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vladimir.milosavljevic.dao.CityDao;
import vladimir.milosavljevic.dao.ProfessorDao;
import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.ProfessorMapper;
import vladimir.milosavljevic.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private CityDao cityDao;
	@Autowired
	private ProfessorDao professorDao;

	private final ProfessorMapper professorMapper = Mappers.getMapper(ProfessorMapper.class);

	@Override
	public List<ProfessorDto> findAll() {
		List<ProfessorEntity> entities = (List) professorDao.findAll();
		return entities.stream().map(entity -> {
			return professorMapper.toProfessorDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(int id) {					
		professorDao.deleteById(id);

	}

	@Override
	public ProfessorDto save(ProfessorEntity professorEntity) throws ExistEntityException {
		professorEntity = professorDao.save(professorEntity);
		return professorMapper.toProfessorDto(professorEntity);
	}

	@Override
	public Optional<ProfessorDto> findById(int id) {

		Optional<ProfessorEntity> profesor = professorDao.findById(id);
		if (profesor.isPresent()) {
			return Optional.of(professorMapper.toProfessorDto(profesor.get()));
		}
		return Optional.empty();
	}

	@Override
	public ProfessorDto update(ProfessorDto dto) throws EntityNotPresent {
		Optional<ProfessorEntity> entity = professorDao.findById(dto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(dto.getId(), "profesor does not exist!");
		}
		ProfessorEntity p = professorDao.save(professorMapper.toProfessorEntity(dto));
		return professorMapper.toProfessorDto(p);

	}

	@Override
	public Page<ProfessorDto> findByPage(Pageable pageable) {

		Page<ProfessorDto> entites = professorDao.findAll(pageable).map(professorMapper::toProfessorDto);
		return entites;
	}

}
