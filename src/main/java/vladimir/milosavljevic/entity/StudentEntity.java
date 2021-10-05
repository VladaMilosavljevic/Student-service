package vladimir.milosavljevic.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Indexed;



@Entity
@Table(name = "student", uniqueConstraints=
@UniqueConstraint(columnNames={"index_number", "index_year"})
)

public class StudentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087086488144852583L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "index_number",unique = true)
	private String IndexNumber;
	@Column(name = "index_year" )
	private String IndexYear;
	@Column(name = "first_name")
	private String FirstName;
	@Column(name = "last_name")
	private String LastName;
	@Column(name = "email",  unique = true)
	private String Email;
	@Column(name = "current_year_of_study" )
	private int CurrentYearOfStudy;
	@Column(name = "address") 
	private String address;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity city;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndexNumber() {
		return IndexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		IndexNumber = indexNumber;
	}

	public String getIndexYear() {
		return IndexYear;
	}

	public void setIndexYear(String indexYear) {
		IndexYear = indexYear;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getCurrentYearOfStudy() {
		return CurrentYearOfStudy;
	}

	public void setCurrentYearOfStudy(int currentYearOfStudy) {
		CurrentYearOfStudy = currentYearOfStudy;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public StudentEntity(int id, String indexNumber, String indexYear, String firstName, String lastName, String email,
			int currentYearOfStudy,String address, CityEntity city) {
		super();
		this.id = id;
		this.IndexNumber = indexNumber;
		this.IndexYear = indexYear;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.CurrentYearOfStudy = currentYearOfStudy;
		this.address=address;
		this.city = city;
	}

	public StudentEntity() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CurrentYearOfStudy;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((IndexNumber == null) ? 0 : IndexNumber.hashCode());
		result = prime * result + ((IndexYear == null) ? 0 : IndexYear.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
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
		StudentEntity other = (StudentEntity) obj;
		if (CurrentYearOfStudy != other.CurrentYearOfStudy)
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (IndexNumber == null) {
			if (other.IndexNumber != null)
				return false;
		} else if (!IndexNumber.equals(other.IndexNumber))
			return false;
		if (IndexYear == null) {
			if (other.IndexYear != null)
				return false;
		} else if (!IndexYear.equals(other.IndexYear))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		return true;
	}



}
