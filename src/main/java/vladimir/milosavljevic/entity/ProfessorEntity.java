package vladimir.milosavljevic.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "professor")

public class ProfessorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4388004963264403349L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@Length(max = 30)
	private String FirstName;
	@Column(name = "last_name")
	@Length(max = 30)
	private String LastName;
	@Column(name = "email", unique = true)
	@Length(max = 60)
	private String Email;
	@Column(name = "phone")
	@Length(max = 15)
	private String phone;
	@Column(name = "address")
	@Length(max = 50)
	private String address;
	@Column(name = "reelection_date")
	private Date ReelectionDate;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity cityId;
	@ManyToOne
	@JoinColumn(name = "title_id")
	private TitleEntity titleId;	


	public ProfessorEntity(int id, @Length(max = 30) String firstName, @Length(max = 30) String lastName,
			@Length(max = 60) String email, @Length(max = 15) String phone, @Length(max = 50) String address,
			Date reelectionDate, CityEntity cityId, TitleEntity titleId ) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.phone = phone;
		this.address = address;
		ReelectionDate = reelectionDate;
		this.cityId = cityId;
		this.titleId = titleId;
		
	}

	public ProfessorEntity() {
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getReelectionDate() {
		return ReelectionDate;
	}

	public void setReelectionDate(Date reelectionDate) {
		ReelectionDate = reelectionDate;
	}

	public CityEntity getCityId() {
		return cityId;
	}

	public void setCityId(CityEntity cityId) {
		this.cityId = cityId;
	}

	public TitleEntity getTitleId() {
		return titleId;
	}

	public void setTitleId(TitleEntity titleId) {
		this.titleId = titleId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((ReelectionDate == null) ? 0 : ReelectionDate.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result + id;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((titleId == null) ? 0 : titleId.hashCode());
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
		ProfessorEntity other = (ProfessorEntity) obj;
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
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (id != other.id)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (titleId == null) {
			if (other.titleId != null)
				return false;
		} else if (!titleId.equals(other.titleId))
			return false;
		return true;
	}

	

}
