package Adv.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.*;

@MappedSuperclass
public class baseAdv {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private boolean active;
	
	@Column
	private String img;
	
	@Column
	private int location;
	
	@Column
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    public boolean checkActive()
    {
    	return active;
    }
}
