package dsc.lab2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import dsc.lab2.dtos.ComentarioDTO;
import dsc.lab2.dtos.DisciplinaDTO;
import dsc.lab2.dtos.NotaDTO;
import dsc.lab2.entidades.Disciplina;
import dsc.lab2.servicos.ServicoDeDisciplina;

@RestController
public class ControladorDeDisciplina {

	@Autowired
	private ServicoDeDisciplina service;

	public ControladorDeDisciplina(ServicoDeDisciplina service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/disciplinas/add")
	public ResponseEntity<Disciplina> add(@RequestBody DisciplinaDTO disciplinaDto){
		return new ResponseEntity<Disciplina>(service.add(disciplinaDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/disciplinas/addall")
	public ResponseEntity<List<Disciplina>> add(@RequestBody List<Disciplina> disciplinas){
		return new ResponseEntity<List<Disciplina>>(service.add(disciplinas), HttpStatus.CREATED);
	}
	
	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplina>> getAll(){
		return new ResponseEntity<List<Disciplina>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@PathVariable Long id){
		try {
			return new ResponseEntity<Disciplina>(service.getDisciplina(id), HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> addLikeInDisciplina(@PathVariable Long id){
		try {
			return new ResponseEntity<Disciplina>(service.addLikeInDisciplina(id), HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/disciplinas/nota/{id}")
	public ResponseEntity<Disciplina> addNotaToDisciplina(@PathVariable Long id, @RequestBody NotaDTO notaDto){
		try {
			return new ResponseEntity<Disciplina>(service.addNotaToDisciplina(id, notaDto), HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PostMapping("/disciplinas/comentario/{id}")
	public ResponseEntity<Disciplina> addComentarioToDisciplina(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDto){
		try {
			return new ResponseEntity<Disciplina>(service.addComentarioToDisciplina(id, comentarioDto), HttpStatus.OK);
		}catch(HttpClientErrorException e) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/disciplinas/ranking/notas")
	public ResponseEntity<List<Disciplina>> orderByNota(){
		return new ResponseEntity<List<Disciplina>>(service.orderByNota(), HttpStatus.OK);
	}
	
	@GetMapping("/disciplinas/ranking/likes")
	public ResponseEntity<List<Disciplina>> orderByLikes(){
		return new ResponseEntity<List<Disciplina>>(service.orderByLikes(), HttpStatus.OK);
	}
	
}
