package dsc.lab2.dtos;

import lombok.Data;

@Data
public class NotaDTO {

	private double nota;
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
