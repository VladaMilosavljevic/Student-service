package vladimir.milosavljevic.dto;

import java.io.Serializable;

import vladimir.milosavljevic.entity.ProfessorEntity;
import vladimir.milosavljevic.entity.Semester;

public class SubjectDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9202596410484060630L;

	private int id;	
	private String name;	
	private int NoOfESP;
	private int YearOfStudy;
	private ProfessorEntity professor;
	private Semester semester;
	public ProfessorEntity getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorEntity professor) {
		this.professor = professor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public SubjectDto(int id, String name, int noOfESP, int yearOfStudy, ProfessorEntity professor, Semester semester) {
		super();
		this.id = id;
		this.name = name;
		NoOfESP = noOfESP;
		YearOfStudy = yearOfStudy;
		this.professor = professor;
		this.semester = semester;
	}
	public SubjectDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfESP() {
		return NoOfESP;
	}
	public void setNoOfESP(int noOfESP) {
		NoOfESP = noOfESP;
	}
	public int getYearOfStudy() {
		return YearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		YearOfStudy = yearOfStudy;
	}

	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NoOfESP;
		result = prime * result + YearOfStudy;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
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
		SubjectDto other = (SubjectDto) obj;
		if (NoOfESP != other.NoOfESP)
			return false;
		if (YearOfStudy != other.YearOfStudy)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (semester != other.semester)
			return false;
		return true;
	}
	
	
}
