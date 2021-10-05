package vladimir.milosavljevic.mapper;

import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.entity.CityEntity;
@Component
public class CityMapperImpl implements CityMapper {

	@Override
	public CityDto toCityDto(CityEntity cityEntity) {
		CityDto cityDto = new CityDto();
		cityDto.setId(cityEntity.getId());
		cityDto.setName(cityEntity.getName());
		cityDto.setPostalCode(cityEntity.getPostalCode());
		return cityDto;
	}

	@Override
	public CityEntity toCityEntity(CityDto cityDto) {
		CityEntity cityEntity = new CityEntity();
		cityEntity.setId(cityDto.getId());
		cityEntity.setName(cityDto.getName());
		cityEntity.setPostalCode(cityDto.getPostalCode());
		return cityEntity;
	}

}
