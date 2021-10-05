package vladimir.milosavljevic.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.NotNull;

public class ExamPeriodDto  implements Serializable{

	private int id;
	@NotNull
	private Date start_date;
	@NotNull
	private Date end_date;	
	private List<ExamDto>exams = new ArrayList<ExamDto>();
	@NotNull
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExamPeriodDto(int id, Date start_date, Date end_date, List<ExamDto> exams,String name) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.exams = exams;
		this.name=name;
	}
	public ExamPeriodDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public List<ExamDto> getExams() {
		return exams;
	}
	public void setExams(List<ExamDto> exams) {
		this.exams = exams;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((exams == null) ? 0 : exams.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
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
		ExamPeriodDto other = (ExamPeriodDto) obj;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (exams == null) {
			if (other.exams != null)
				return false;
		} else if (!exams.equals(other.exams))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}
	
}
