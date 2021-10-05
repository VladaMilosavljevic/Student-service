package vladimir.milosavljevic.mapper;

import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.TitleDto;
import vladimir.milosavljevic.entity.TitleEntity;

@Component
public class TitleMapperImpl implements TitleMapper {

	@Override
	public TitleDto toTitleDto(TitleEntity titleEntity) {
		TitleDto titleDto = new TitleDto();
		titleDto.setId(titleEntity.getId());
		titleDto.setName(titleEntity.getName());
		return titleDto;
	}

	@Override
	public TitleEntity toTitleEntity(TitleDto titleDto) {
		TitleEntity titleEntity = new TitleEntity();
		titleEntity.setId(titleDto.getId());
		titleEntity.setName(titleDto.getName());
		return titleEntity;
	}

}
