package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vladimir.milosavljevic.dao.ExamPeriodDao;
import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.dto.ExamPeriodDto;
import vladimir.milosavljevic.dto.StudentDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ExamPeriodEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.ExamPeriodMapper;
import vladimir.milosavljevic.service.ExamPeriodService;

@Service
@Transactional
public class ExamPeriodServiceImpl implements ExamPeriodService {

	@Autowired
	private ExamPeriodDao examPeriodDao;

	@Autowired
	private ExamPeriodMapper mapper;

	@Override
	public List<ExamPeriodDto> findAll() {

		List<ExamPeriodEntity> entities = (List) examPeriodDao.findAll();
		return entities.stream().map(entity -> {
			return mapper.toExamPeriodDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(int id) {
		examPeriodDao.deleteById(null);

	}

	@Override
	public ExamPeriodDto save(ExamPeriodDto examPeriodDto) throws ExistEntityException {

		Optional<ExamPeriodEntity> entity = examPeriodDao.findById(examPeriodDto.getId());
		if (entity.isPresent()) {
			throw new ExistEntityException(entity.get(), "exam period already exists!");
		}
		ExamPeriodEntity examPeriodEntity = examPeriodDao.save(mapper.toExamPeriodEntity(examPeriodDto));
		return mapper.toExamPeriodDto(examPeriodEntity);
	}

	@Override
	public Optional<ExamPeriodDto> findById(int id) {
		Optional<ExamPeriodEntity> entity = examPeriodDao.findById(id);
		if (entity.isPresent()) {
			return Optional.of(mapper.toExamPeriodDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public ExamPeriodDto update(ExamPeriodDto examPeriodDto) throws EntityNotPresent {
		Optional<ExamPeriodEntity> entity = examPeriodDao.findById(examPeriodDto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(examPeriodDto.getId(), "exam period does not exist!");
		}
		ExamPeriodEntity e = examPeriodDao.save(mapper.toExamPeriodEntity(examPeriodDto));
		return mapper.toExamPeriodDto(e);
	}

	@Override
	public Page<ExamPeriodDto> findByPage(Pageable pageable) {
		Page<ExamPeriodDto> entites = examPeriodDao.findAll(pageable).map(mapper::toExamPeriodDto);
		return entites;
	}

}
