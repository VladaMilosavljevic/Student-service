package vladimir.milosavljevic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3574403278621655877L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "postal_code", unique = true, precision = 5)
	private String PostalCode;
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PostalCode == null) ? 0 : PostalCode.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CityEntity other = (CityEntity) obj;
		if (PostalCode == null) {
			if (other.PostalCode != null)
				return false;
		} else if (!PostalCode.equals(other.PostalCode))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public CityEntity(int id, String postalCode, String name) {
		super();
		this.id = id;
		this.PostalCode = postalCode;
		this.name = name;
	}

	public CityEntity() {
		super();
	}
}
