package vladimir.milosavljevic.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vladimir.milosavljevic.dao.ExamDao;
import vladimir.milosavljevic.dao.StudentDao;
import vladimir.milosavljevic.dto.RegisteredExamDto;
import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.RegisteredExamEntity;
import vladimir.milosavljevic.entity.StudentEntity;
import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.exception.ExistEntityException;
import vladimir.milosavljevic.service.RegisteredExamService;

@Component
public class RegisteredExamFacadeImpl implements RegisteredExamFacade {
	@Autowired
	private ExamDao examDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private RegisteredExamService service;

	@Override
	public RegisteredExamDto save(RegisteredExamDto registeredExamDto, Integer idStudent, Integer idExam)
			throws Exception {
		StudentEntity studentEntity = getStudent(idStudent);
		ExamEntity examEntity = getExam(idExam);

		RegisteredExamDto registeredExamDtoSave = null;
		RegisteredExamEntity registeredExamEntity = new RegisteredExamEntity();
		registeredExamEntity.setId(registeredExamDto.getId());
		registeredExamEntity.setRegisteredExamDate(registeredExamDto.getRegisteredExamDate());
		registeredExamEntity.setExam(examEntity);
		registeredExamEntity.setStudent(studentEntity);

		if (examEntity.getSubjectEntity().getYearOfStudy() <= studentEntity.getCurrentYearOfStudy()) {
           if(registeredExamEntity.getRegisteredExamDate().before(examEntity.getExamPeriod().getStartDate()))
			registeredExamDtoSave = service.save(registeredExamEntity);
		}

		else {
			throw new Exception("student doesnt have this subject on his year of study");
		}
		return registeredExamDtoSave;
	}

	private ExamEntity getExam(Integer idExam) throws ExistEntityException {
		ExamEntity examEntity = examDao.findExamById(idExam);
		if (examEntity == null) {
			throw new ExistEntityException(examEntity, "exam doesnt exist");
		}
		return examEntity;
	}

	private StudentEntity getStudent(Integer idStudent) throws ExistEntityException {

		StudentEntity studentEntity = studentDao.findStudentById(idStudent);
		if (studentEntity == null) {
			throw new ExistEntityException(studentEntity, "student doesnt exist");
		}
		return studentEntity;

	}

}
