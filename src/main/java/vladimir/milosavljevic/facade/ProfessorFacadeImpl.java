package vladimir.milosavljevic.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dto.ProfessorDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.TitleEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.ProfessorMapper;
import vladimir.milosavljevic.service.CityService;
import vladimir.milosavljevic.service.ProfessorService;
import vladimir.milosavljevic.service.TitleService;

@Component
public class ProfessorFacadeImpl implements ProfessorFacade {
	@Autowired
	private ProfessorService service;
	
	@Autowired
	private CityService cityService;
	@Autowired
	private TitleService titleService;

	@Override
	public ProfessorDto save(ProfessorDto professorDto, Integer idCity, Integer idTitle) throws ExistEntityException {
		CityEntity city = getCity(idCity);
		TitleEntity title = getTitle(idTitle);

		ProfessorEntity professorEntity = new ProfessorEntity();
		professorEntity.setAddress(professorDto.getAddress());
		professorEntity.setEmail(professorDto.getEmail());
		professorEntity.setFirstName(professorDto.getFirstName());
		professorEntity.setLastName(professorDto.getLastName());
		professorEntity.setPhone(professorDto.getPhone());
		professorEntity.setReelectionDate(professorDto.getReelectionDate());
		professorEntity.setCityId(city);
		professorEntity.setTitleId(title);

		ProfessorDto dtoSave = service.save(professorEntity);

		return dtoSave;
	}

	private TitleEntity getTitle(Integer idTitle) throws ExistEntityException {

		TitleEntity title = titleService.findTitleById(idTitle);
		if (title == null) {
			throw new ExistEntityException(title, "title doesnt exist");
		}
		return title;
	}

	private CityEntity getCity(Integer idCity) throws ExistEntityException {
		CityEntity cityEntity = cityService.findCityById(idCity);
		if (cityEntity == null) {
			throw new ExistEntityException(cityEntity, "city doesnt exist");
		}
		return cityEntity;

	}
}
