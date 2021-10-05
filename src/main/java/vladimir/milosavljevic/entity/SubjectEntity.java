package vladimir.milosavljevic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "subject")
public class SubjectEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7574207767648897472L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false)
	@Length(max = 30)
	private String name;
	@Column(name = "number_of_esp", nullable = false)
	private int NoOfESP;
	@Column(name = "year_of_study")
	private int YearOfStudy;
	@Enumerated(EnumType.STRING)
	private Semester semester;
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private ProfessorEntity professor;

	public SubjectEntity(int id, @Length(max = 30) String name, @Length(max = 1) int noOfESP,
			@Length(max = 1) int yearOfStudy, @Length(max = 10) Semester semester, ProfessorEntity professor) {
		super();
		this.id = id;
		this.name = name;
		NoOfESP = noOfESP;
		YearOfStudy = yearOfStudy;
		this.semester = semester;
		this.professor = professor;
	}

	public SubjectEntity() {
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

	public ProfessorEntity getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorEntity professor) {
		this.professor = professor;
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
		SubjectEntity other = (SubjectEntity) obj;
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
