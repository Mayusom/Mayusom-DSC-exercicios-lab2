package dsc.lab2.dtos;

import lombok.Data;

@Data
public class ComentarioDTO {
	
	private String comentario;
	private int curtidas;
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}
	
	
}
