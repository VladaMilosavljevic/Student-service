package vladimir.milosavljevic.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import vladimir.milosavljevic.entity.CityEntity;

public class StudentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096553362495785810L;
	private int id;
	@Size(min = 4,message = "minimum 10 characters..")
	private String IndexNumber;	
	private String IndexYear;
	@Size(min = 3,message = "minimum 3 characters..")
	private String FirstName;
	@Size(min = 3,message = "minimum 3 characters..")
	private String LastName;
	@Size(min = 3,message = "minimum 3 characters..")
	private String address;
	@Email
	private String Email;
	private int CurrentYearOfStudy;
	//private CityDto cityDto;
	private CityEntity city;
	public StudentDto(int id, @Size(min = 10, message = "minimum 10 characters..") String indexNumber, String indexYear,
			@Size(min = 3, message = "minimum 3 characters..") String firstName,
			@Size(min = 3, message = "minimum 3 characters..") String lastName,
			@Email String email, int currentYearOfStudy,@Size(min = 3, message = "minimum 3 characters..")String address, CityEntity city) {
		super();
		this.id = id;
		this.IndexNumber = indexNumber;
		this.IndexYear = indexYear;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.CurrentYearOfStudy = currentYearOfStudy;
		this.city = city;
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StudentDto() {
		super();
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
		StudentDto other = (StudentDto) obj;
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
	
	

	

