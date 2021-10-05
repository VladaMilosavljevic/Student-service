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

import vladimir.milosavljevic.dao.ExamDao;
import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.ExamMapper;
import vladimir.milosavljevic.service.ExamService;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;

	private ExamMapper mapper = Mappers.getMapper(ExamMapper.class);

	@Override
	public List<ExamDto> findAll() {
		List<ExamEntity> entities = (List) examDao.findAll();

		return entities.stream().map(entity -> {
			return mapper.toExamDto(entity);
		}).collect(Collectors.toList());

	}

	@Override
	public void deleteById(int id) {
		examDao.deleteById(id);

	}

	@Override
	public ExamDto save(ExamEntity examEntity) throws ExistEntityException {
		examEntity = examDao.save(examEntity);
		return mapper.toExamDto(examEntity);
	}

	@Override
	public Optional<ExamDto> findById(int id) {

		Optional<ExamEntity> exam = examDao.findById(id);
		if (exam.isPresent()) {
			return Optional.of(mapper.toExamDto(exam.get()));
		}
		return Optional.empty();
	}

	@Override
	public ExamDto update(ExamDto examDto) throws EntityNotPresent {

		Optional<ExamEntity> entity = examDao.findById(examDto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(examDto.getId(), "exam does not exist!");
		}
		ExamEntity e = examDao.save(mapper.toExamEntity(examDto));
		return mapper.toExamDto(e);

	}

	@Override
	public Page<ExamDto> findByPage(Pageable pageable) {
		Page<ExamDto> entites = examDao.findAll(pageable).map(mapper::toExamDto);
		return entites;
	}
}
