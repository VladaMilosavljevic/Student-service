package vladimir.milosavljevic.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "exam")
public class ExamEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798048832051072239L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "date_of_exam")
	private Date dateOfExam;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private SubjectEntity subjectEntity;

	@ManyToOne
	@JoinColumn(name = "id_exam_period")
	private ExamPeriodEntity examPeriod;

	public ExamEntity(int id, Date dateOfExam, SubjectEntity subjectEntity, ExamPeriodEntity examPeriod,
			Set<RegisteredExamEntity> registeredExamEntities) {
		super();
		this.id = id;
		this.dateOfExam = dateOfExam;
		this.subjectEntity = subjectEntity;
		this.examPeriod = examPeriod;

	}

	public ExamEntity() {
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

	public SubjectEntity getSubjectEntity() {
		return subjectEntity;
	}

	public void setSubjectEntity(SubjectEntity subjectEntity) {
		this.subjectEntity = subjectEntity;
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

		result = prime * result + ((subjectEntity == null) ? 0 : subjectEntity.hashCode());
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
		ExamEntity other = (ExamEntity) obj;
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

		if (subjectEntity == null) {
			if (other.subjectEntity != null)
				return false;
		} else if (!subjectEntity.equals(other.subjectEntity))
			return false;
		return true;
	}

}
