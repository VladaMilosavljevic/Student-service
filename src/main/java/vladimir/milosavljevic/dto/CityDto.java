package vladimir.milosavljevic.dto;

import java.io.Serializable;
import java.util.List;

public class CityDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3122923986929364510L;
	private int id;
	private String PostalCode;
	private String name;
	public CityDto(int id, String postalCode, String name ) {
		super();
		this.id = id;
		this.PostalCode = postalCode;
		this.name = name;
	
	}
	public CityDto() {
		super();
	}
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
		this.PostalCode = postalCode;
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
		CityDto other = (CityDto) obj;
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

}
