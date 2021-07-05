package dsc.lab2.dtos;

import lombok.Data;

@Data
public class DisciplinaDTO {

	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
