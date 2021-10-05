package vladimir.milosavljevic.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import vladimir.milosavljevic.entity.CityEntity;
import vladimir.milosavljevic.entity.SubjectEntity;
import vladimir.milosavljevic.entity.TitleEntity;

public class ProfessorDto implements Serializable {

	private int id;
	@NotNull
	@Size(min = 3, message = "minimum 3 characters..")
	private String FirstName;
	@NotNull
	@Size(min = 3, message = "minimum 3 characters..")
	private String LastName;
	@Email
	private String email;
	@Size(min = 3, message = "minimum 3 characters..")
	private String address;
	@Size(min = 6, message = "minimum 3 characters..")
	private String phone;
	@NotNull
	private Date ReelectionDate;
	private CityEntity cityEntity;
	private TitleEntity title;


	public ProfessorDto(int id, @NotNull @Size(min = 3, message = "minimum 3 characters..") String firstName,
			@NotNull @Size(min = 3, message = "minimum 3 characters..") String lastName, @Email String email,
			@Size(min = 3, message = "minimum 3 characters..") String address,
			@Size(min = 6, message = "minimum 3 characters..") String phone, @NotNull Date reelectionDate,
			CityEntity cityEntity, TitleEntity title) {
		super();
		this.id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.ReelectionDate = reelectionDate;
		this.cityEntity = cityEntity;
		this.title = title;
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ProfessorDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReelectionDate() {
		return ReelectionDate;
	}

	public void setReelectionDate(Date reelectionDate) {
		ReelectionDate = reelectionDate;
	}

	public CityEntity getCityEntity() {
		return cityEntity;
	}

	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}

	public TitleEntity getTitle() {
		return title;
	}

	public void setTitle(TitleEntity title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((ReelectionDate == null) ? 0 : ReelectionDate.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cityEntity == null) ? 0 : cityEntity.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ProfessorDto other = (ProfessorDto) obj;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (ReelectionDate == null) {
			if (other.ReelectionDate != null)
				return false;
		} else if (!ReelectionDate.equals(other.ReelectionDate))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cityEntity == null) {
			if (other.cityEntity != null)
				return false;
		} else if (!cityEntity.equals(other.cityEntity))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
