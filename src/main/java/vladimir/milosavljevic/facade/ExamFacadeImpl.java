package vladimir.milosavljevic.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dao.ExamPeriodDao;
import vladimir.milosavljevic.dao.SubjectDao;
import vladimir.milosavljevic.dto.ExamDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ExamPeriodEntity;
import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.mapper.ExamMapper;
import vladimir.milosavljevic.service.ExamService;

@Component
public class ExamFacadeImpl implements ExamFacade {
	@Autowired
	private ExamService examService;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ExamPeriodDao examPeriodDao;
	private ExamMapper examMapper = Mappers.getMapper(ExamMapper.class);

	@Override
	public ExamDto save(ExamDto examDto, Integer idSubject, Integer idExamPeriod) throws ExistEntityException,Exception {
		SubjectEntity subjectEntity = getSubject(idSubject);
		ExamPeriodEntity examPeriodEntity = getExamPeriod(idExamPeriod);
		ExamDto examDtoSave =null;
		ExamEntity examEntity = new ExamEntity();
		examEntity.setDateOfExam(examDto.getDateOfExam());
		examEntity.setSubjectEntity(subjectEntity);
		examEntity.setExamPeriod(examPeriodEntity);
		if(examDto.getDateOfExam().before(examPeriodEntity.getEndDate())) {
			 examDtoSave = examService.save(examEntity);
		}
		else {
			throw new Exception("exam date must be in exam period range");
		}
		
		
		return examDtoSave;
	}

	private ExamPeriodEntity getExamPeriod(Integer idExamPeriod) throws ExistEntityException {

		ExamPeriodEntity examPeriodEntity = examPeriodDao.findExamPeriodById(idExamPeriod);
		if(examPeriodEntity == null) {
			
			throw new ExistEntityException(examPeriodEntity, "exam period doesnt exist");
		}
		return examPeriodEntity;
	}

	private SubjectEntity getSubject(Integer idSubject) throws ExistEntityException {

		SubjectEntity subjectEntity = subjectDao.findSubjectById(idSubject);
		if(subjectEntity == null) {
			
			throw new ExistEntityException(subjectEntity, "subject doesnt exist");
		}
		
		return subjectEntity;
	}

}
