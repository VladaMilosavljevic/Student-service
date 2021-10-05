package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vladimir.milosavljevic.dao.RegisteredExamDao;
import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.RegisteredExamEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.RegisteredExamMapper;
import vladimir.milosavljevic.service.RegisteredExamService;

@Service
@Transactional
public class RegisteredExamServiceImpl implements RegisteredExamService {

	@Autowired
	private RegisteredExamDao registeredExamDao;
	@Autowired
	private RegisteredExamMapper mapper;

	@Override
	public List<RegisteredExamDto> findAll() {
		List<RegisteredExamEntity> entities =  registeredExamDao.findAll();
		return entities.stream().map(entity -> {
			return mapper.toRegisteredExamDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(int id) {
		registeredExamDao.deleteById(id);

	}

	@Override
	public RegisteredExamDto save(RegisteredExamEntity registeredExamEntity) throws ExistEntityException {
		registeredExamEntity = registeredExamDao.save(registeredExamEntity);
		return mapper.toRegisteredExamDto(registeredExamEntity);
	}

	@Override
	public Optional<RegisteredExamDto> findById(int id) {
		Optional<RegisteredExamEntity> entity = registeredExamDao.findById(id);
		if (entity.isPresent()) {
			return Optional.of(mapper.toRegisteredExamDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public RegisteredExamDto update(RegisteredExamDto dto) throws EntityNotPresent {
		Optional<RegisteredExamEntity> entity = registeredExamDao.findById(dto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(dto.getId(), "registered exam does not exist!");
		}
		RegisteredExamEntity re = registeredExamDao.save(mapper.toRegisteredExamEntity(dto));
		return mapper.toRegisteredExamDto(re);
	}

}
