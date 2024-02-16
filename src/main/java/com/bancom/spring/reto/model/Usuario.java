package  com.bancom.spring.reto.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	 
	  private String cellphone;
	  private String name;
	  @Column(name = "lastname")
	  private String lastName;	 
	  private String password;	 
	  @JsonIgnore	  
	  @Column(name = "creation_date")
	  private Instant  creationDate;
	  @JsonIgnore	  
	  @Column(name = "modification_date")
	  private Instant  modificationDate;
   
	  public Usuario() { }
	      
   
	public Usuario(String cellphone, String name, String lastName, String password, Instant creationDate,
		Instant modificationDate) {

	this.cellphone = cellphone;
	this.name = name;
	this.lastName = lastName;
	this.password = password;
	this.creationDate = creationDate;
	this.modificationDate = modificationDate;
	
}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Instant getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}


	public Instant getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(Instant modificationDate) {
		this.modificationDate = modificationDate;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cellphone=" + cellphone + ", name=" + name + ", lastName=" + lastName
				+ ", password=" + password + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
				+ "]";
	}

	
	  
}
