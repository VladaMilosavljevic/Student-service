package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vladimir.milosavljevic.dao.TitleDao;
import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.dto.TitleDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.TitleEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.TitleMapper;
import vladimir.milosavljevic.service.TitleService;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {

	@Autowired
	private TitleMapper mapper;
	
	@Autowired
	private TitleDao titleDao;

	@Override
	public TitleEntity findTitleById(Integer idTitle) throws ExistEntityException {

		TitleEntity title = titleDao.findTitleById(idTitle);
		if (title == null) {
			throw new ExistEntityException(title, " title doesnt exist");
		}
		return title;
	}

	@Override
	public List<TitleDto> findAll() {
		List<TitleEntity> entites =  (List)titleDao.findAll();
		return entites.stream().map(entity -> {
			return mapper.toTitleDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<TitleDto> findById(int id) {
		Optional<TitleEntity> title = titleDao.findById(id);
		if (title.isPresent()) {
			return Optional.of(mapper.toTitleDto(title.get()));
		}
		return Optional.empty();
	}

}
