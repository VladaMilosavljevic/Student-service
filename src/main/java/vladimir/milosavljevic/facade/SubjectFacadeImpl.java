package vladimir.milosavljevic.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dao.ProfessorDao;
import vladimir.milosavljevic.dto.SubjectDto;
import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.Semester;
import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.SubjectMapper;
import vladimir.milosavljevic.service.ProfessorService;
import vladimir.milosavljevic.service.SubjectService;

@Component
public class SubjectFacadeImpl implements SubjectFacade {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ProfessorDao professorDao;

	private final SubjectMapper mapper = Mappers.getMapper(SubjectMapper.class);

	@Override
	public SubjectDto save(SubjectDto subjectDto, Integer idProfessor) throws ExistEntityException {
		ProfessorEntity professorEntity = getProfessor(idProfessor);
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setProfessor(professorEntity);
		subjectEntity.setName(subjectDto.getName());
		subjectEntity.setNoOfESP(subjectDto.getNoOfESP());
		subjectEntity.setSemester(subjectDto.getSemester());
		subjectEntity.setYearOfStudy(subjectDto.getYearOfStudy());
		SubjectDto save = subjectService.save(subjectEntity);
		return save;

	}

	private ProfessorEntity getProfessor(Integer idProfessor) throws ExistEntityException {

		ProfessorEntity professorEntity = professorDao.findProfessorById(idProfessor);
		if (professorEntity == null) {
			throw new ExistEntityException(professorEntity, "professor doesnt exist");
		}
		return professorEntity;
	}

}
