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

import vladimir.milosavljevic.dao.SubjectDao;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.dto.SubjectDto;

import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.SubjectMapper;
import vladimir.milosavljevic.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	private final SubjectMapper mapper = Mappers.getMapper(SubjectMapper.class);

	@Override
	public List<SubjectDto> findAll() {
		List<SubjectEntity> entities = (List) subjectDao.findAll();

		return entities.stream().map(entity -> {
			return mapper.toSubjectDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(int id) {
		subjectDao.deleteById(id);

	}

	@Override
	public SubjectDto save(SubjectEntity subjectEntity) throws ExistEntityException {
		subjectEntity = subjectDao.save(subjectEntity);
		return mapper.toSubjectDto(subjectEntity);
	}

	@Override
	public Optional<SubjectDto> findById(int id) {

		Optional<SubjectEntity> entity = subjectDao.findById(id);
		if (entity.isPresent()) {
			return Optional.of(mapper.toSubjectDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public SubjectDto update(SubjectDto dto) throws EntityNotPresent {
		Optional<SubjectEntity> entity = subjectDao.findById(dto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(dto.getId(), "subject does not exist!");
		}
		SubjectEntity s = subjectDao.save(mapper.toSubjectEntity(dto));
		return mapper.toSubjectDto(s);

	}

	@Override
	public Page<SubjectDto> findByPage(Pageable pageable) {
		Page<SubjectDto> entites = subjectDao.findAll(pageable).map(mapper::toSubjectDto);
		return entites;
	}

}
