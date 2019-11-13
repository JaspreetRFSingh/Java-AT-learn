package model;

public class Pet {

	private long id;
	private String name;
	private String status;
	
	public Pet(long id, String name, String status) {
		super();
		this.setId(id);
		this.setName(name);
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
