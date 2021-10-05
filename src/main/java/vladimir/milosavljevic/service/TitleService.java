package vladimir.milosavljevic.service;

import java.util.List;
import java.util.Optional;

import vladimir.milosavljevic.dto.CityDto;
import vladimir.milosavljevic.dto.TitleDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.TitleEntity;
import vladimir.milosavljevic.exception.ExistEntityException;

public interface TitleService {

	
	TitleEntity findTitleById(Integer idTitle) throws ExistEntityException;
	
	List<TitleDto> findAll();

	Optional<TitleDto> findById(int id);
}
