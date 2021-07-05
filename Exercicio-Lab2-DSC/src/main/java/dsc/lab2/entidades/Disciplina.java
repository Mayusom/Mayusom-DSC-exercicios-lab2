package dsc.lab2.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "disciplinas")
@Entity
public class Disciplina {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private int curtidas;
	
	private double nota;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Nota> notas;

	@OneToMany(mappedBy = "disciplina")
	private List<Comentario> comentarios;

	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disciplina(String nome) {
		super();
		this.nome = nome;
		this.nota = 0;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public List<Nota> getNotas() {
		return notas;
	}
	
	public void addNota(Nota nota) {
		this.notas.add(nota);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void addComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
