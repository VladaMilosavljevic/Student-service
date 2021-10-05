package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.exception.EntityNotPresent;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface CityService {

	List<CityDto> findAll();

	void deleteById(int id);

	CityDto save(CityDto cityDto) throws ExistEntityException  ;

	CityEntity findCityById(Integer idCity) throws ExistEntityException;

	Optional<CityDto> findById(int id);

	CityDto update(CityDto cityDto) throws EntityNotPresent ;
}
