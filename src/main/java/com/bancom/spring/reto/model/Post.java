package  com.bancom.spring.reto.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts")
public class Post {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Lob
	  private String text;


	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "usuario_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore	  
	  private Usuario usuario;
	  @JsonIgnore	  
	  @Column(name = "creation_date")
	  private Instant  creationDate;
	  @JsonIgnore	  
	  @Column(name = "modification_date")
	  private Instant  modificationDate;
	  
	  public Post() {};
	  
	  public Post(String text, Usuario usuario, Instant creationDate, Instant modificationDate) {
	
		this.text = text;
		this.usuario = usuario;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "Post [id=" + id + ", text=" + text + ", usuario=" + usuario + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + "]";
	}
	  
	  
}
