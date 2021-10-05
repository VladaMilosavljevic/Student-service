package vladimir.milosavljevic.mapper;



import vladimir.milosavljevic.dto.CityDto;

import vladimir.milosavljevic.entity.CityEntity;

public interface CityMapper {

	CityDto toCityDto(CityEntity cityEntity);

	CityEntity toCityEntity(CityDto cityDto);
}
