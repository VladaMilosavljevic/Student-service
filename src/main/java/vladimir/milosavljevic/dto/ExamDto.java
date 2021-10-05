package vladimir.milosavljevic.dto;

import java.io.Serializable;
import java.sql.Date;

import vladimir.milosavljevic.entity.ExamPeriodEntity;
import vladimir.milosavljevic.entity.SubjectEntity;

public class ExamDto implements Serializable {

	private int id;
	private Date dateOfExam;
	private SubjectEntity subject;
	private ExamPeriodEntity examPeriod;

	public ExamDto(int id, Date dateOfExam, SubjectEntity subject, ExamPeriodEntity examPeriod) {
		super();
		this.id = id;
		this.dateOfExam = dateOfExam;
		this.subject = subject;
		this.examPeriod = examPeriod;
	}

	public ExamDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public ExamPeriodEntity getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriodEntity examPeriod) {
		this.examPeriod = examPeriod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfExam == null) ? 0 : dateOfExam.hashCode());
		result = prime * result + ((examPeriod == null) ? 0 : examPeriod.hashCode());
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamDto other = (ExamDto) obj;
		if (dateOfExam == null) {
			if (other.dateOfExam != null)
				return false;
		} else if (!dateOfExam.equals(other.dateOfExam))
			return false;
		if (examPeriod == null) {
			if (other.examPeriod != null)
				return false;
		} else if (!examPeriod.equals(other.examPeriod))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
