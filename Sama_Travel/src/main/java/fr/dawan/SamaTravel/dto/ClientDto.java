package fr.dawan.SamaTravel.dto;

public class ClientDto {

	private String email;
	private String password;
	
	public ClientDto() {
		super();
	}
	
	public ClientDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDto [email=" + email + ", password=" + password + "]";
	}
	
	
}
