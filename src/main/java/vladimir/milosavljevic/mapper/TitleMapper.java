package vladimir.milosavljevic.mapper;

import org.mapstruct.Mapper;
import vladimir.milosavljevic.dto.TitleDto;
import vladimir.milosavljevic.entity.TitleEntity;


public interface TitleMapper {

	TitleDto toTitleDto(TitleEntity titleEntity);

	TitleEntity toTitleEntity(TitleDto titleDto);
}
