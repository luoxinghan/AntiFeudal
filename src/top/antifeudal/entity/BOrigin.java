package top.antifeudal.entity;

public class BOrigin {
	
	private Integer id;
	
	private String userName;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private Byte displayPriority;
	
	private Byte isDelete;

	public BOrigin() {
		super();
	}

	public BOrigin(Integer id, String userName, String country, String state, String city, String street,
			Byte displayPriority, Byte isDelete) {
		super();
		this.id = id;
		this.userName = userName;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.displayPriority = displayPriority;
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Byte getDisplayPriority() {
		return displayPriority;
	}

	public void setDisplayPriority(Byte displayPriority) {
		this.displayPriority = displayPriority;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}
}
