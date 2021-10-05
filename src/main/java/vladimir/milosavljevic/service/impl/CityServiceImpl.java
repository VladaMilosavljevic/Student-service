package vladimir.milosavljevic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vladimir.milosavljevic.dao.CityDao;
import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.CityMapper;
import vladimir.milosavljevic.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;
	private final CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

	@Override
	public List<CityDto> findAll() {

		List<CityEntity> entites =  (List)cityDao.findAll();
		return entites.stream().map(entity -> {
			return cityMapper.toCityDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteById(int id) {
		cityDao.deleteById(id);
	}

	@Override
	public CityDto save(CityDto cityDto) throws ExistEntityException {
		Optional<CityEntity> entity = cityDao.findById(cityDto.getId());
		if (entity.isPresent()) {
			throw new ExistEntityException(entity.get(), "City already exists!");
		}
		CityEntity cityEntity = cityDao.save(cityMapper.toCityEntity(cityDto));
		return cityMapper.toCityDto(cityEntity);

	}

	@Override
	public Optional<CityDto> findById(int id) {

		Optional<CityEntity> city = cityDao.findById(id);
		if (city.isPresent()) {
			return Optional.of(cityMapper.toCityDto(city.get()));
		}
		return Optional.empty();
	}

	@Override
	public CityEntity findCityById(Integer idCity) throws ExistEntityException {

		CityEntity city = cityDao.findCityById(idCity);
		if (city == null) {
			throw new ExistEntityException(city, "doesnt exist");
		}
		return city;
	}

	@Override
	public CityDto update(CityDto cityDto) throws EntityNotPresent {

		Optional<CityEntity> entity = cityDao.findById(cityDto.getId());
		if (!entity.isPresent()) {
			throw new EntityNotPresent(cityDto.getId(), "City does not exist!");
		}
		CityEntity c = cityDao.save(cityMapper.toCityEntity(cityDto));
		return cityMapper.toCityDto(c);

	}
}
