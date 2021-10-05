package vladimir.milosavljevic.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import com.sun.istack.NotNull;

import vladimir.milosavljevic.entity.ExamEntity;
import vladimir.milosavljevic.entity.StudentEntity;

public class RegisteredExamDto implements Serializable {

	private int id;
	private StudentEntity student;;
	private ExamEntity exam;;
	@NotNull
	private Date registeredExamDate;
	public RegisteredExamDto(int id, StudentEntity student, ExamEntity exam, Date registeredExamDate) {
		super();
		this.id = id;
		this.student = student;
		this.exam = exam;
		this.registeredExamDate = registeredExamDate;
	}
	public RegisteredExamDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	public ExamEntity getExam() {
		return exam;
	}
	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}
	public Date getRegisteredExamDate() {
		return registeredExamDate;
	}
	public void setRegisteredExamDate(Date registeredExamDate) {
		this.registeredExamDate = registeredExamDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + id;
		result = prime * result + ((registeredExamDate == null) ? 0 : registeredExamDate.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		RegisteredExamDto other = (RegisteredExamDto) obj;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (id != other.id)
			return false;
		if (registeredExamDate == null) {
			if (other.registeredExamDate != null)
				return false;
		} else if (!registeredExamDate.equals(other.registeredExamDate))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}


	

}
